package com.suneee.kubernetes.services;

import com.google.gson.Gson;
import com.suneee.kubernetes.api.DeploymentApi;
import com.suneee.kubernetes.api.IngressApi;
import com.suneee.kubernetes.api.PodApi;
import com.suneee.kubernetes.api.ServiceApi;
import com.suneee.kubernetes.constant.ServiceType;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.JSON;
import com.suneee.kubernetes.model.deployment.AppsV1beta1Deployment;
import com.suneee.kubernetes.model.endpoints.V1Endpoints;
import com.suneee.kubernetes.model.ingress.V1beta1Ingress;
import com.suneee.kubernetes.model.service.V1Service;
import com.suneee.kubernetes.model.status.V1Status;

import java.util.HashMap;

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


}
