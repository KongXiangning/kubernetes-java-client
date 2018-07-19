package com.suneee.kubernetes;

import com.google.gson.Gson;
import com.suneee.kubernetes.api.*;
import com.suneee.kubernetes.auth.ApiKeyAuth;
import com.suneee.kubernetes.constant.ImagePullPolicy;
import com.suneee.kubernetes.constant.KindType;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.JSON;
import com.suneee.kubernetes.model.V1ObjectMeta;
import com.suneee.kubernetes.model.deployment.AppsV1beta1Deployment;
import com.suneee.kubernetes.model.event.V1Event;
import com.suneee.kubernetes.model.event.V1EventList;
import com.suneee.kubernetes.model.namespace.V1Namespace;
import com.suneee.kubernetes.model.pod.V1PodList;
import com.suneee.kubernetes.model.service.V1Service;
import com.suneee.kubernetes.services.AppApi;

import javax.xml.stream.events.Namespace;

public class test {

//    final static String value = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLW54dDJtIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI1NjJjMTM4MS01ZmMxLTExZTgtOWJjNC0wMDBjMjkwMmI2NTkiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06YWRtaW4tdXNlciJ9.RFeYjT0ZovID2sihAO6kothjAQYCrCSqWnRl9uIiTYA-fP1l-pIKiSVRBUx8pK4XnPyEu5ORYfsIivJtx4TRJEuWmV7ad7UmPeUreD9jnYowUvkHhbkFRQExtcWSLFyGQRc7RxsLC6qDE9LHv3lBxiV_rlQ1v9LhfFpLuxTHu9ouVMZrXE-r1kcRe8hKoibMSFLoCWNt4oWB1SKnmyQyEoLg8x3Gja3HtEyz4TjOOfCQQhTf1MluMEFwExnEXT3kQyHVejiAFA-GeHU1jVG_YLqNa9l4cxb4uaath7e-DcagI4m28wu6Mnkx3qXBeeV4yVUVOAMfUH9FOc4WH3Cu9g";
    final static String value = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLTl6cGdoIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI3YjA0NjYwZS01ZGEwLTExZTgtOWIxMC1mYTE2M2UxMTdjN2MiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06YWRtaW4tdXNlciJ9.qYWTc5M2RGFgXfSqyaLdbrWlR13EVBZar_C2ruEez4PuX2_ypnvk0qJb3qsbip99RECmlu6evayaDL4kDVZGeZI9EnFS_RRqOyX96ME_m1ZpWQI54oJC7hxLycvXWbsevUeA0pfrQG5bQp2ZvWGcELQZilTWWvhUGkUfcgr-udK1Xr51BkOQNKSXgfxlaEo64H5Iruo0CMyoBDUpaboaM3h7gj8AOzGm5JjHDvhe1OifeUIClhn88mt_HYTTsSZlC_Fl7k8j1M1LjyBS4ukxZS1WloxpVm3PnfKr5vrheSVhnc2-6_Vw-dGi9e8NP4I0vfw74rMDRggZk9IWzfnsug";
    final static String ip = "https://10.6.250.253:6443";
    final static String namespace = "njxs-test";

    /*public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        Namespace instance = new Namespace();
        try {
            V1NamespaceList result = instance.getNamespaces(null,null);
            System.out.println(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        *//*String json = "{\"apiVersion\": \"v1\",\"kind\": \"Namespace\",\"metadata\": {\"name\": \"testdev\"}}";
        V1Namespace v1Namespace = new V1Namespace();
        v1Namespace.setApiVersion("v1");
        v1Namespace.setKind("Namespace");
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("optest");
        v1Namespace.setMetadata(meta);*//*

        V1Namespace v1Namespace = new V1Namespace("testdev");

        NamespaceApi instance = new NamespaceApi();
        try {
            V1Namespace result = instance.createNamespaceDeployment(v1Namespace);
            System.out.println(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);


        Pod instance = new Pod();
        try {
            V1Pod result = instance.getPod("optest","myweb-6bf7f68b77-wc95g");
            System.out.println(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) throws ApiException {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        *//*Namespace namespaceApi = new Namespace();
        namespaceApi.createNamespaceDeployment(new V1Namespace("devtest"));*//*

        *//*String yaml = "{ apiVersion: 'apps/v1beta1',kind: 'Deployment',metadata: { name: 'mytest', namespace: 'devtest' },spec: { replicas: 2,template:{ metadata: { labels: { app: 'mytest' } },spec:{ containers:[ { name: 'mytest',image: 'tomcat:v1',imagePullPolicy: 'IfNotPresent',ports: [ { containerPort: 8080 } ] } ] } } } }";
        Gson gson = new JSON().getGson();
        AppsV1beta1Deployment deployment = gson.fromJson(yaml,AppsV1beta1Deployment.class);

        System.out.println(deployment);*//*
        *//*V1Deployment body = new V1Deployment();
        body.setApiVersion("extensions/v1beta1");
        body.setKind("Deployment");
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("myweb");
        meta.setNamespace("optest");
        body.setMetadata(meta);*//*

        AppsV1beta1Deployment deployment = new AppsV1beta1Deployment("devtest","mytest");

        deployment.addContainer("testweb","tomcat:v1");
        deployment.addPort(8080).addPort(80);
        deployment.addEnv("JENV","test").addEnv("po","test");
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).setImagePullPolicy(ImagePullPolicy.IfNotPresent);
        deployment.setReplicas(3);

        System.out.println(deployment);

        Deployment instance = new Deployment();
        try {
//            V1Deployment result = instance.deleteNamespaceDeployment(deployment.getMetadata().getNamespace(),deployment);
//            AppsV1beta1Deployment result = instance.createNamespaceDeployment(deployment.getNamespace(),deployment);
            AppsV1beta1Deployment r = instance.updateNamespaceDeployment(deployment.getNamespace(),deployment.getName(),deployment);
//            AppsV1beta1Deployment result1 = instance.deleteNamespaceDeployment("devtest","mytest",null);

            System.out.println(r);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        V1Service v1Service = new V1Service("devtest","mytest");
        v1Service.addPort("mytest-sv",8080,8080);
        v1Service.setSelector("app","mytest");

        System.out.println(v1Service);

        Gson gson = new JSON().getGson();
        String json = gson.toJson(v1Service);
        System.out.println(json);

        ServiceApi instance = new ServiceApi();
        try {
//            V1Service result = instance.createService("devtest",v1Service);
//            V1Service result = instance.getServiceByName("testdev","myweb");
//            V1ServiceList result = instance.getServiceList("testdev");
            V1Service result = instance.deleteService("devtest","mytest");
            System.out.println(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }*/

    /*public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);
        AppApi instance = new AppApi();
        try {
//            String imagesName = "tomcat";//
            String imagesName = "172.16.36.69:5000/root/tomcatdev:v1";
            Integer imagePort = 8080;
            instance.createDeploymentService("testdev","myweb",imagesName,"ingress.tomcat.com",imagePort,null,"1","1Gi");
//            instance.deleteDeploymentService("testdev","myweb");
        } catch (ApiException e) {
            e.printStackTrace();
        }

//        DeploymentApi deploymentApi = new DeploymentApi();
//        try {
//            AppsV1beta1Deployment deployment = deploymentApi.getNamespaceDeploymentByName("testdev","myweb");
//            deployment.getSpec().getTemplate().getSpec().getContainers().get(0).setImagePullPolicy(ImagePullPolicy.IfNotPresent);
//            deployment.getSpec().getTemplate().getSpec().getContainers().get(0).setImage("tomcat");
//            deploymentApi.updateNamespaceDeployment("testdev","myweb",deployment);
//
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//
//        ServiceApi serviceApi = new ServiceApi();
//        try {
//            V1Service service = serviceApi.deleteService("testdev","myweb");
////            V1Service service = serviceApi.getServiceByName("testdev","myweb");
//            System.out.println(service);
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
    }*/

    /*public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        EventApi eventApi = new EventApi();
        DeploymentApi deploymentApi = new DeploymentApi();
        PodApi podApi = new PodApi();

        try {
            *//*V1EventList v1EventList = eventApi.getEventList("testdev");
            System.out.println(v1EventList.getItems().size());
            for (int i = 0; i < v1EventList.getItems().size(); i++) {
                V1Event event = v1EventList.getItems().get(i);
                if (event.getInvolvedObject().getKind().equalsIgnoreCase("Pod")&&event.getInvolvedObject().getName().equals("myweb-746c75bf7f-5jn7m")){
                    System.out.println(event.getType()+"|"+event.getReason()+"|"+event.getMessage());
                }
            }
            System.out.println(v1EventList);*//*
            String namespace = "testdev";
            String label = "myweb";
            String name = "myweb";
            AppsV1beta1Deployment deployment = deploymentApi.getNamespaceDeploymentByName(namespace,name);
            System.out.println();
            for (int i = 0; i < deployment.getSpec().getTemplate().getSpec().getContainers().size(); i++) {
                System.out.println();

            }

            V1PodList podList = podApi.getPodListByLabel(namespace,label);
            for (int i = 0; i < podList.getItems().size(); i++) {
                String podName = podList.getItems().get(i).getMetadata().getName();
                System.out.println("podName:"+podName);

                V1EventList eventList = eventApi.getEventListByName(namespace,podName,KindType.POD);

                for (int j = 0; j < eventList.getItems().size(); j++) {
                    V1Event event = eventList.getItems().get(j);
                    System.out.println(event.getType()+"|"+event.getReason()+"|"+event.getMessage());
                }
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath(ip);
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        AppApi appApi = new AppApi();
        try {
            appApi.createEndpointService(namespace,"db.configcenter.weilian.cn","172.16.36.70",5432);
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }
}
