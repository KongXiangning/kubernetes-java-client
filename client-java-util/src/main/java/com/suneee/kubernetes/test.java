package com.suneee.kubernetes;

import com.google.gson.Gson;
import com.suneee.kubernetes.api.Deployment;
import com.suneee.kubernetes.api.Namespace;
import com.suneee.kubernetes.api.Pod;
import com.suneee.kubernetes.auth.ApiKeyAuth;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.JSON;
import com.suneee.kubernetes.model.V1ObjectMeta;
import com.suneee.kubernetes.model.deployment.V1Deployment;
import com.suneee.kubernetes.model.namespace.V1Namespace;
import com.suneee.kubernetes.model.namespace.V1NamespaceList;
import com.suneee.kubernetes.model.pod.V1Pod;

import java.util.ArrayList;
import java.util.List;

public class test {

    final static String value = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLW54dDJtIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI1NjJjMTM4MS01ZmMxLTExZTgtOWJjNC0wMDBjMjkwMmI2NTkiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06YWRtaW4tdXNlciJ9.RFeYjT0ZovID2sihAO6kothjAQYCrCSqWnRl9uIiTYA-fP1l-pIKiSVRBUx8pK4XnPyEu5ORYfsIivJtx4TRJEuWmV7ad7UmPeUreD9jnYowUvkHhbkFRQExtcWSLFyGQRc7RxsLC6qDE9LHv3lBxiV_rlQ1v9LhfFpLuxTHu9ouVMZrXE-r1kcRe8hKoibMSFLoCWNt4oWB1SKnmyQyEoLg8x3Gja3HtEyz4TjOOfCQQhTf1MluMEFwExnEXT3kQyHVejiAFA-GeHU1jVG_YLqNa9l4cxb4uaath7e-DcagI4m28wu6Mnkx3qXBeeV4yVUVOAMfUH9FOc4WH3Cu9g";


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

        String json = "{\"apiVersion\": \"v1\",\"kind\": \"Namespace\",\"metadata\": {\"name\": \"testdev\"}}";
        V1Namespace v1Namespace = new V1Namespace();
        v1Namespace.setApiVersion("v1");
        v1Namespace.setKind("Namespace");
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("optest");
        v1Namespace.setMetadata(meta);

        Namespace instance = new Namespace();
        try {
            V1Namespace result = instance.createNamespaceDeployment("optest",v1Namespace,"true",null,null);
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

    public static void main(String[] args) {
        ApiClient apiClient = ApiClient.getApiClient();
        apiClient.setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) apiClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        String yaml = "{ apiVersion: 'apps/v1beta1',kind: 'Deployment',metadata: { name: 'mytest', namespace: 'optest' },spec: { replicas: 2,template:{ metadata: { labels: { app: 'mytest' } },spec:{ containers:[ { name: 'mytest',image: 'tomcat:v1',imagePullPolicy: 'IfNotPresent',ports: [ { containerPort: 8080 } ] } ] } } } }";
        Gson gson = new JSON().getGson();
        V1Deployment deployment = gson.fromJson(yaml,V1Deployment.class);

        System.out.println(deployment);
        /*V1Deployment body = new V1Deployment();
        body.setApiVersion("extensions/v1beta1");
        body.setKind("Deployment");
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("myweb");
        meta.setNamespace("optest");
        body.setMetadata(meta);*/

        /*V1Deployment deployment = new V1Deployment("optest","testweb");

        deployment.addContainer("testweb","tomcat:v1");
        deployment.addPort(8080).addPort(80);
        deployment.addEnv("JENV","test").addEnv("po","test");*/

        System.out.println(deployment);

        Deployment instance = new Deployment();
        try {
//            V1Deployment result = instance.deleteNamespaceDeployment(deployment.getMetadata().getNamespace(),deployment);
            V1Deployment result = instance.createNamespacedDeployment(deployment.getMetadata().getNamespace(),deployment);
            System.out.println(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
