package com.suneee.kubernetes.http;


import com.google.gson.Gson;
import com.suneee.kubernetes.model.pod.V1Pod;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.AppsApi;
import io.kubernetes.client.auth.ApiKeyAuth;
import io.kubernetes.client.models.V1APIGroup;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpTools {
    //private Context context;
    //private final RequestParams req;
    //private final Handler handler;

    String value = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLW54dDJtIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI1NjJjMTM4MS01ZmMxLTExZTgtOWJjNC0wMDBjMjkwMmI2NTkiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06YWRtaW4tdXNlciJ9.RFeYjT0ZovID2sihAO6kothjAQYCrCSqWnRl9uIiTYA-fP1l-pIKiSVRBUx8pK4XnPyEu5ORYfsIivJtx4TRJEuWmV7ad7UmPeUreD9jnYowUvkHhbkFRQExtcWSLFyGQRc7RxsLC6qDE9LHv3lBxiV_rlQ1v9LhfFpLuxTHu9ouVMZrXE-r1kcRe8hKoibMSFLoCWNt4oWB1SKnmyQyEoLg8x3Gja3HtEyz4TjOOfCQQhTf1MluMEFwExnEXT3kQyHVejiAFA-GeHU1jVG_YLqNa9l4cxb4uaath7e-DcagI4m28wu6Mnkx3qXBeeV4yVUVOAMfUH9FOc4WH3Cu9g";

    /*public HttpTools(Builder builder)
    {
        // TODO Auto-generated constructor stub
        context = builder.context;
        req = builder.req;
        handler = builder.handler;
    }*/

    public void testone(){
        ApiClient defaultClient = Configuration.getDefaultApiClient().setBasePath("https://192.168.29.100:6443");
        ApiKeyAuth BearerToken = (ApiKeyAuth) defaultClient.getAuthentication("BearerToken");
        BearerToken.setApiKey(value);

        AppsApi apiInstance = new AppsApi();
        try {
            V1APIGroup result = apiInstance.getAPIGroup();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AppsApi#getAPIGroup");
            e.printStackTrace();
        }
    }

    public void test(){
        OkHttpClient okHttpClient = OkHttpUtil.getInstance();
        final Request request = new Request.Builder()
                .url("https://192.168.29.100:6443/api/v1/namespaces/testdev/pods/myweb-5449977fcd-6bm6h")
                .addHeader("Authorization",value).build();
        final Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String result = response.body().string();
            //System.out.println(response.body().string());
            Gson gson = new JSON().getGson();
            V1Pod pod = gson.fromJson(result,V1Pod.class);
            System.out.println(pod);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    String result = response.body().string();
                    //System.out.println(response.body().string());
                    Gson gson = new JSON().getGson();
                    V1Pod pod = gson.fromJson(result,V1Pod.class);
                    System.out.println(pod);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
        System.out.println("end");
    }

    public static void main(String[] args) {
        HttpTools httpTools = new HttpTools();
        httpTools.testone();
        /*Gson gson = new JSON().getGson();
        String json = "{\"kind\":\"Pod\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"myweb-5449977fcd-6bm6h\",\"generateName\":\"myweb-5449977fcd-\",\"namespace\":\"testdev\",\"selfLink\":\"/api/v1/namespace/testdev/pods/myweb-5449977fcd-6bm6h\",\"uid\":\"d1018cec-7532-11e8-97df-000c2902b659\",\"resourceVersion\":\"389689\",\"creationTimestamp\":\"2018-06-21T09:09:35Z\",\"labels\":{\"deapp\":\"myweb\",\"pod-template-hash\":\"1005533978\"},\"ownerReferences\":[{\"apiVersion\":\"extensions/v1beta1\",\"kind\":\"ReplicaSet\",\"name\":\"myweb-5449977fcd\",\"uid\":\"d0fd021c-7532-11e8-97df-000c2902b659\",\"controller\":true,\"blockOwnerDeletion\":true}]},\"spec\":{\"volumes\":[{\"name\":\"default-token-h27zh\",\"secret\":{\"secretName\":\"default-token-h27zh\",\"defaultMode\":420}}],\"containers\":[{\"name\":\"myweb\",\"image\":\"tomcat:v1\",\"ports\":[{\"containerPort\":8080,\"protocol\":\"TCP\"}],\"resources\":{},\"volumeMounts\":[{\"name\":\"default-token-h27zh\",\"readOnly\":true,\"mountPath\":\"/var/run/secrets/kubernetes.io/serviceaccount\"}],\"terminationMessagePath\":\"/dev/termination-log\",\"terminationMessagePolicy\":\"File\",\"imagePullPolicy\":\"IfNotPresent\"}],\"restartPolicy\":\"Always\",\"terminationGracePeriodSeconds\":30,\"dnsPolicy\":\"ClusterFirst\",\"serviceAccountName\":\"default\",\"serviceAccount\":\"default\",\"nodeName\":\"node01\",\"securityContext\":{},\"schedulerName\":\"default-scheduler\",\"tolerations\":[{\"key\":\"node.kubernetes.io/not-ready\",\"operator\":\"Exists\",\"effect\":\"NoExecute\",\"tolerationSeconds\":300},{\"key\":\"node.kubernetes.io/unreachable\",\"operator\":\"Exists\",\"effect\":\"NoExecute\",\"tolerationSeconds\":300}]},\"status\":{\"phase\":\"Running\",\"conditions\":[{\"type\":\"Initialized\",\"status\":\"True\",\"lastProbeTime\":null,\"lastTransitionTime\":\"2018-06-21T09:09:35Z\"},{\"type\":\"Ready\",\"status\":\"True\",\"lastProbeTime\":null,\"lastTransitionTime\":\"2018-06-26T01:39:24Z\"},{\"type\":\"PodScheduled\",\"status\":\"True\",\"lastProbeTime\":null,\"lastTransitionTime\":\"2018-06-21T09:09:35Z\"}],\"hostIP\":\"192.168.29.11\",\"podIP\":\"10.244.1.41\",\"startTime\":\"2018-06-21T09:09:35Z\",\"containerStatuses\":[{\"name\":\"myweb\",\"state\":{\"running\":{\"startedAt\":\"2018-06-26T01:39:22Z\"}},\"lastState\":{\"terminated\":{\"exitCode\":255,\"reason\":\"Error\",\"startedAt\":\"2018-06-24T23:23:57Z\",\"finishedAt\":\"2018-06-26T01:36:01Z\",\"containerID\":\"docker://297c78709e61bc0bc61308f5c4dff74d0da9046efa14525f3f7e070fbb2d1617\"}},\"ready\":true,\"restartCount\":6,\"image\":\"tomcat:v1\",\"imageID\":\"docker://sha256:61205f6444f9e917faec4aea5d29e3c4b81c5b47fb206535ea035900a89aef38\",\"containerID\":\"docker://f3cf62027c59454d3affe1e7e099d256ba3329392a03211ed9eee9ff0a313910\"}],\"qosClass\":\"BestEffort\"}}";
        System.out.println(json);
        V1Pod pod = gson.fromJson(json,V1Pod.class);
        System.out.println("test");*/
    }
}
