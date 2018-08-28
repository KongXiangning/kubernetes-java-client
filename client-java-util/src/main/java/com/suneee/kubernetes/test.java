package com.suneee.kubernetes;

import com.suneee.kubernetes.api.*;
import com.suneee.kubernetes.auth.ApiKeyAuth;
import com.suneee.kubernetes.constant.ServiceType;
import com.suneee.kubernetes.http.KubernetesClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.deployment.AppsV1beta1Deployment;
import com.suneee.kubernetes.model.deployment.AppsV1beta1DeploymentStatus;
import com.suneee.kubernetes.model.event.V1Event;
import com.suneee.kubernetes.model.persistentvolume.V1PersistentVolume;
import com.suneee.kubernetes.model.persistentvolume.V1PersistentVolumeClaim;
import com.suneee.kubernetes.model.pod.V1Pod;
import com.suneee.kubernetes.model.pod.V1PodList;
import com.suneee.kubernetes.model.secret.V1Secret;
import com.suneee.kubernetes.model.service.V1Service;
import com.suneee.kubernetes.services.AppApi;

import java.util.List;
import java.util.Map;

public class test {

//    final static String value = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLW54dDJtIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI1NjJjMTM4MS01ZmMxLTExZTgtOWJjNC0wMDBjMjkwMmI2NTkiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06YWRtaW4tdXNlciJ9.RFeYjT0ZovID2sihAO6kothjAQYCrCSqWnRl9uIiTYA-fP1l-pIKiSVRBUx8pK4XnPyEu5ORYfsIivJtx4TRJEuWmV7ad7UmPeUreD9jnYowUvkHhbkFRQExtcWSLFyGQRc7RxsLC6qDE9LHv3lBxiV_rlQ1v9LhfFpLuxTHu9ouVMZrXE-r1kcRe8hKoibMSFLoCWNt4oWB1SKnmyQyEoLg8x3Gja3HtEyz4TjOOfCQQhTf1MluMEFwExnEXT3kQyHVejiAFA-GeHU1jVG_YLqNa9l4cxb4uaath7e-DcagI4m28wu6Mnkx3qXBeeV4yVUVOAMfUH9FOc4WH3Cu9g";
    final static String value = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLWtyYm1xIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiJiOTU3MzQ0Mi05M2M1LTExZTgtOWEwMy1mYTE2M2UxMTdjN2MiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06YWRtaW4tdXNlciJ9.mhIGMjSzoIBEmy66XY39fq2E75j7KkpXQxQXauMZVHFTyBa92mUwQdf3WRleEvSbknjKaqe6h_5z8J7RLc1T8vJeD--qtB86V9lijKac9kOYcY0-NQ352li42wsTTyh1KwJGpHpqBrVvxX36Lyg7cmEpJ1ql3sIDN3PJz-4KX6KndfVkYtTtmFWucJnalYgRO2KaK4OWSYpiHPlTtNzNnmAjeWhaoB9KaBV1fERU63IiRAFSk8dp8VviZTvlsJa6Yq5QywxARCx96PspEKYacWbzRnQl5At3AJ45OHeGEw9eO_SwwwFl2KWc_yLvTcAWc_7lEEmJluRr2dTekxsf7g";
    final static String ip = "https://10.6.250.253:6443";
    final static String namespace = "njxs-test";

    /*public static void main(String[] args) {
        KubernetesClient apiClient = KubernetesClient.getKubernetesClient();
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
        KubernetesClient apiClient = KubernetesClient.getKubernetesClient();
        apiClient.setBasePath(ip);
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

//        String json = "{\"apiVersion\": \"v1\",\"kind\": \"Namespace\",\"metadata\": {\"name\": \"testdev\"}}";
//        V1Namespace v1Namespace = new V1Namespace();
//        v1Namespace.setApiVersion("v1");
//        v1Namespace.setKind("Namespace");
//        V1ObjectMeta meta = new V1ObjectMeta();
//        meta.setName("optest");
//        v1Namespace.setMetadata(meta);

        V1Namespace v1Namespace = new V1Namespace("mes-test");

        NamespaceApi instance = new NamespaceApi();
        try {
            V1Namespace result = instance.createNamespaceDeployment(v1Namespace);
            System.out.println(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        KubernetesClient apiClient = KubernetesClient.getKubernetesClient();
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
        KubernetesClient apiClient = KubernetesClient.getKubernetesClient();
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
        KubernetesClient apiClient = KubernetesClient.getKubernetesClient();
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
        KubernetesClient apiClient = KubernetesClient.getKubernetesClient();
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
        KubernetesClient apiClient = KubernetesClient.getKubernetesClient();
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
        KubernetesClient kubernetesClient = KubernetesClient.getKubernetesClient();
        kubernetesClient.setBasePath(ip);
        ApiKeyAuth BearerToken = (ApiKeyAuth) kubernetesClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        String namespace = "mes-test";
        /*AppsV1beta1Deployment deployment = new AppsV1beta1Deployment(namespace,"system-rest");
        */
        /*NamespaceApi namespaceApi = new NamespaceApi();
        V1Namespace namespaceBody = new V1Namespace("mes-test");
        try {
            namespaceApi.createNamespaceDeployment(namespaceBody);
        } catch (ApiException e) {
            e.printStackTrace();
        }*/

        /*AppApi appApi = new AppApi();
        try {
            appApi.createEndpointService("mes-test","redis-mes","10.1.11.92",6379);
//            appApi.deleteEndpointService("mes-test","db-mes");
        } catch (ApiException e) {
            e.printStackTrace();
        }*/


        /*AppsV1beta1Deployment deploymentBody = new AppsV1beta1Deployment("mes-test","system-rest");
        deploymentBody.addContainer("system-rest","172.16.36.69:5000/vr-mes/system-rest:t1.0.0",30928,null);
        deploymentBody.addEnv("JENV","prod").addEnv("PROD","mes-system");
        deploymentBody.addPort(30938);
        deploymentBody.addPort(30938);
        deploymentBody.setResource("16","10Gi");

        V1Service serviceBody = new V1Service(namespace,"system-rest")
                .addPort("system-rest-sv",30928,30928)
                .setSelector("app","system-rest");

        V1beta1Ingress ingressBody = new V1beta1Ingress(namespace,"system-rest").addRule("test.mes.weilian.cn","system-rest",30928);

        DeploymentApi deploymentApi = new DeploymentApi();
        ServiceApi serviceApi = new ServiceApi();
        IngressApi ingressApi = new IngressApi();

        try {
            deploymentApi.createNamespaceDeployment(namespace,deploymentBody);
            serviceApi.createService(namespace,serviceBody);
            ingressApi.createIngress(namespace,ingressBody);
        } catch (ApiException e) {
            e.printStackTrace();
        }*/


        /*AppsV1beta1Deployment deploymentBody = new AppsV1beta1Deployment("mes-test","system-provider");
        deploymentBody.addContainer("system-provider","172.16.36.69:5000/vr-mes/system-provider:t1.0.0",40917,null);
        deploymentBody.addEnv("JENV","prod").addEnv("PROD","mes-system");
        deploymentBody.setResource("2","2Gi");

        V1Service serviceBody = new V1Service(namespace,"system-provider").addPort("system-provider-sv",40917,40917).setSelector("app","system-provider").setType(ServiceType.ClusterIP);

        DeploymentApi deploymentApi = new DeploymentApi();
        ServiceApi serviceApi = new ServiceApi();

        try {
            deploymentApi.createNamespaceDeployment(namespace,deploymentBody);
            serviceApi.createService(namespace,serviceBody);
        } catch (ApiException e) {
            e.printStackTrace();
        }*/

        /*DeploymentApi deploymentApi = new DeploymentApi();
        try {
            AppsV1beta1Deployment deploymentBody = deploymentApi.getNamespaceDeploymentByName(namespace,"system-rest");
            V1TCPSocketAction tcpSocket = new V1TCPSocketAction().port(new IntOrString(30928));
            V1Probe probe = new V1Probe().tcpSocket(tcpSocket).initialDelaySeconds(600).timeoutSeconds(60);
            deploymentBody.getSpec().getTemplate().getSpec().getContainers().get(0).livenessProbe(probe);
            deploymentBody.getSpec().getTemplate().getSpec().getContainers().get(0).readinessProbe(probe);

            deploymentApi.updateNamespaceDeployment(namespace,"system-rest",deploymentBody);
        } catch (ApiException e) {
            e.printStackTrace();
        }*/

        /*AppApi appApi = new AppApi();
        try {
            appApi.deleteDeploymentService(namespace,"system-rest");
        } catch (ApiException e) {
            e.printStackTrace();
        }*/

        /*AppApi appApi = new AppApi();

        try {
//            appApi.createDeploymentProvider("mes-test","system-provider","172.16.36.69:5000/vr-mes/system-provider:t1.0.0",20928,null,"4","4Gi");
            appApi.deleteDeploymentService("mes-test","system");
        } catch (ApiException e) {
            e.printStackTrace();
        }*/

        /*DeploymentApi deploymentApi = new DeploymentApi();
        PodApi podApi = new PodApi();
        try {
//            AppsV1beta1Deployment deployment = deploymentApi.getNamespaceDeploymentByName(namespace,"system-rest");
            AppsV1beta1Deployment deployment = deploymentApi.getNamespaceDeploymentStatusByName(namespace,"system-rest");
//            V1PodList podList = podApi.getPodListByLabel(namespace,"system-rest");
//            deployment.deletePort(30938);
//            deploymentApi.updateNamespaceDeployment(namespace,"system-rest",deployment);
            System.out.println(deployment);
        } catch (ApiException e) {
            e.printStackTrace();
        }*/

        EventApi eventApi = new EventApi();
        AppApi appApi = new AppApi();
        PodApi podApi = new PodApi();
        DeploymentApi deploymentApi = new DeploymentApi();
        NamespaceApi namespaceApi = new NamespaceApi();
        SecretApi secretApi = new SecretApi();
        VolumeApi volumeApi = new VolumeApi();
        try {
////            V1EventList eventList = eventApi.getEventListByName("mes-test","system-rest");
////            V1EventList eventList = eventApi.getEventList("mes-test");
//            Map<String,List<V1Event>> result = appApi.getPodEventListByName("mes-test","system-provider");
////            System.out.println(eventApi);
//            for (String s : result.keySet()) {
//                System.out.println(s);
//                for (V1Event v1Event : result.get(s)) {
//                    System.out.println(v1Event.getMessage());
//                }
//                System.out.println("-----------------------------------");
//            }
//            V1PodList podList = podApi.getPodListByLabel("mes-test","system-provider");
//            for (V1Pod v1Pod : podList.getItems()) {
//                List<V1Event> list = appApi.getPodEventListByName("mes-test",v1Pod.getMetadata().getName());
//                for (V1Event v1Event : list) {
//                    System.out.println(v1Event.getMessage());
//                }
//            }
//            AppsV1beta1Deployment deployment = deploymentApi.getNamespaceDeploymentStatusByName("mes-test","system-rest1");
//            System.out.println(deployment);
//            namespaceApi.createNamespaceDeployment("mes-test");
//            secretApi.createSecret("njxs-l","ceph-secret","key","AQAlnh9bYYnYLRAAL9RD7zNRPU0JQ6L6bxHpDA==");
//            V1Secret secret = secretApi.getSecret("njxs-l","ceph-secret");
//            String n = new String(secret.getData().get("key"));
//            System.out.println(n);
//            System.out.println(secret);
//            V1PersistentVolumeClaim claim = volumeApi.getPersistentVolumeClaim("njxs-l","cephfs-pv-claim");
//            System.out.println(claim);
            V1PersistentVolume volume = volumeApi.getPersistentVolume("cephfs-pv-njxs");
            System.out.println(volume);
        } catch (ApiException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}