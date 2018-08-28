package com.suneee.kubernetes.services;

import com.google.gson.Gson;
import com.suneee.kubernetes.api.*;
import com.suneee.kubernetes.constant.ServiceType;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.JSON;
import com.suneee.kubernetes.model.deployment.AppsV1beta1Deployment;
import com.suneee.kubernetes.model.endpoints.V1Endpoints;
import com.suneee.kubernetes.model.event.V1Event;
import com.suneee.kubernetes.model.event.V1EventList;
import com.suneee.kubernetes.model.ingress.V1beta1Ingress;
import com.suneee.kubernetes.model.persistentvolume.V1PersistentVolume;
import com.suneee.kubernetes.model.persistentvolume.V1PersistentVolumeClaim;
import com.suneee.kubernetes.model.pod.V1Pod;
import com.suneee.kubernetes.model.pod.V1PodList;
import com.suneee.kubernetes.model.service.V1Service;
import com.suneee.kubernetes.model.status.V1Status;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppApi {

    public V1Service createEndpointService(String namespace,String name,String addr,Integer port)throws ApiException{
        ServiceApi serviceApi = new ServiceApi();
        V1Service serviceBody = new V1Service(namespace,name).addPort(null,port).setType(ServiceType.ClusterIP);
        V1Endpoints endpointsBody = new V1Endpoints(namespace,name).addSubset(addr,port);

        Gson gson = new JSON().getGson();
        String json = gson.toJson(serviceBody);
        System.out.println(json);


        serviceApi.createEndpoint(namespace,endpointsBody);
        serviceApi.createService(namespace,serviceBody);
        return null;
    }

    public void deleteEndpointService(String namespace,String name)throws ApiException{
        ServiceApi serviceApi = new ServiceApi();
        serviceApi.deleteService(namespace,name);
        serviceApi.deleteEndpoint(namespace,name);
    }

    public AppsV1beta1Deployment createDeploymentService(String namespace, String name, String imagesName, String host, Integer port, HashMap<String,String> envs,String limitsCpu,String limitsmem) throws ApiException {
        DeploymentApi deploymentApi = new DeploymentApi();
        ServiceApi serviceApi = new ServiceApi();
        IngressApi ingressApi = new IngressApi();

        AppsV1beta1Deployment deploymentBody = new AppsV1beta1Deployment(namespace,name);
        deploymentBody.addContainer(name,imagesName,port,envs);
        deploymentBody.setResource(limitsCpu,limitsmem);

        try {
            deploymentBody = deploymentApi.createNamespaceDeployment(namespace,deploymentBody);
        } catch (ApiException e) {
            if (!e.getMessage().equals("Conflict")){
                throw e;
            }
        }

        V1Service serviceBody = new V1Service(namespace,name).addPort(name+"sv",port,port).setSelector("app",name);

        try {
            serviceApi.createService(namespace,serviceBody);
        } catch (ApiException e) {
            if (!e.getMessage().equals("Conflict")){
                throw e;
            }
        }

        V1beta1Ingress ingressBody = new V1beta1Ingress(namespace,name).addRule(host,name,port);


        ingressApi.createIngress(namespace,ingressBody);

        return deploymentBody;
    }

    public AppsV1beta1Deployment createDeploymentProvider(String namespace, String name, String imagesName, Integer port, HashMap<String,String> envs,String limitsCpu,String limitsmem) throws ApiException {
        DeploymentApi deploymentApi = new DeploymentApi();
        ServiceApi serviceApi = new ServiceApi();

        AppsV1beta1Deployment deploymentBody = new AppsV1beta1Deployment(namespace,name);
        deploymentBody.addContainer(name,imagesName,port,envs);
        deploymentBody.setResource(limitsCpu,limitsmem);

        try {
            deploymentBody = deploymentApi.createNamespaceDeployment(namespace,deploymentBody);
        } catch (ApiException e) {
            if (!e.getMessage().equals("Conflict")){
                throw e;
            }
        }

        V1Service serviceBody = new V1Service(namespace,name).addPort(name+"sv",port,port).setSelector("app",name);

        try {
            serviceApi.createService(namespace,serviceBody);
        } catch (ApiException e) {
            if (!e.getMessage().equals("Conflict")){
                throw e;
            }
        }

        return deploymentBody;
    }

    public void deleteDeploymentService(String namespace,String name) throws ApiException {
        DeploymentApi deploymentApi = new DeploymentApi();
        ServiceApi serviceApi = new ServiceApi();
        IngressApi ingressApi = new IngressApi();

        try {
            AppsV1beta1Deployment deployment = deploymentApi.deleteNamespaceDeployment(namespace,name);
            System.out.println(deployment);
        } catch (ApiException e) {
            if (!e.getMessage().equals("Not Found")){
                throw e;
            }
        }
        try {
            V1beta1Ingress ingress = ingressApi.deleteIngress(namespace,name);
            System.out.println(ingress);
        } catch (ApiException e) {
            if (!e.getMessage().equals("Not Found")){
                throw e;
            }
        }
        try {
            V1Status status = serviceApi.deleteService(namespace,name);
            System.out.println(status);
        } catch (ApiException e) {
            if (!e.getMessage().equals("Not Found")){
                throw e;
            }
        }
    }

    public void updateDeploymentNoChange(String namespace,String labelname)throws ApiException{
        PodApi podApi = new PodApi();
        podApi.deletePodByLabel(namespace,labelname);
    }

    public List<V1Event> getPodEventListByName(String namespace, String name)throws ApiException{
        EventApi eventApi = new EventApi();

        V1EventList eventList = eventApi.getEventList(namespace);

        List<V1Event> list = new ArrayList<>();
        for (V1Event v1Event : eventList.getItems()) {
            if (v1Event.getInvolvedObject().getName().contains(name)){
                list.add(v1Event);
            }
        }

        return list;
    }

    public Map<String,List<V1Event>> getPodEventListByLabel(String namespace, String name)throws ApiException{
        EventApi eventApi = new EventApi();
        PodApi podApi = new PodApi();

        V1PodList podList = podApi.getPodListByLabel(namespace,name);
        List<String> podNames = new ArrayList<>();

        V1EventList eventList = eventApi.getEventList(namespace);

        Map<String,List<V1Event>> result = new HashMap<>();

        for (V1Pod pod : podList.getItems()) {
            String podName = pod.getMetadata().getName();
            List<V1Event> list = new ArrayList<>();
            for (V1Event v1Event : eventList.getItems()) {
                if (v1Event.getInvolvedObject().getName().contains(podName)){
                    list.add(v1Event);
                }
            }
            result.put(podName,list);
        }

        return result;
    }

    public void createPVC(String namespace,String name,List<String> monitors,String capacity,String secretRef)throws ApiException{
        VolumeApi volumeApi = new VolumeApi();

        V1PersistentVolume pv = new V1PersistentVolume("pv-"+name);
        pv.setMonitors(monitors).setStorage(capacity).setSecretRef(secretRef);

        V1PersistentVolumeClaim pvc = new V1PersistentVolumeClaim(namespace,"pvc-"+name);
        pvc.setMatchLabels("pv-"+name).setStorage(capacity);

        volumeApi.createPersistentVolume(pv);
        volumeApi.createPersistentVolumeClaim(namespace,pvc);
    }

}
