package com.suneee.kubernetes;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.api.JenkinsApi;
import com.suneee.kubernetes.auth.HttpBasicAuth;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.JenkinsClient;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MyThread extends Thread {

    private int i = 0;

    public void setI(int i){
        this.i = i;
    }

    public void run(){

        Map<String, Object> formParams = new HashMap<>();
        formParams.put("git_path","wnzc/vr-mall/trade");
        formParams.put("git_tag","development");
        formParams.put("rest_path","trade-rest-enterprise-1.0.0-SNAPSHOT.jar");
        formParams.put("version","test");
        formParams.put("module_name","trade");
        formParams.put("type","rest");
        formParams.put("bpmn_private","false");
        formParams.put("image_name",i);

        JenkinsApi jenkinsApi = new JenkinsApi();
        try {
            jenkinsApi.buildProject("pre-build",formParams);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ApiException {
        String ip = "http://10.6.250.253:30002";
        JenkinsClient apiClient = JenkinsClient.getApiClient();
        apiClient.setBasePath(ip);
        HttpBasicAuth basicAuth = (HttpBasicAuth) apiClient.getAuthentication("BasicAuth");
        basicAuth.setUsername("root");
        basicAuth.setPassword("suneeedba");

        ApiCommon apiCommon = new ApiCommon(apiClient);

        for (int i = 0; i < 10; i++) {

            MyThread thread = new MyThread();
            thread.setI(i);
            thread.start();
        }
    }
}
