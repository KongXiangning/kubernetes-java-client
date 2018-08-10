package com.suneee.kubernetes;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.api.JenkinsApi;
import com.suneee.kubernetes.auth.HttpBasicAuth;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.JenkinsClient;
import com.suneee.kubernetes.model.deployment.AppsV1beta1Deployment;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class jenkinsTest {

    private static ApiCommon apiCommon;

    final static String ip = "http://10.6.250.253:30002";

    public static void main(String[] args) {
        JenkinsClient apiClient = JenkinsClient.getApiClient();
        apiClient.setBasePath(ip);
        HttpBasicAuth basicAuth = (HttpBasicAuth) apiClient.getAuthentication("BasicAuth");
        basicAuth.setUsername("root");
        basicAuth.setPassword("suneeedba");

        apiCommon = new ApiCommon(apiClient);

        String localVarPath = "/job/pre-build/lastBuild/buildNumber";
//        String localVarPath = "/job/pre-build/buildWithParameters";

        Map<String, Object> formParams = new HashMap<>();
        formParams.put("git_path","wnzc/vr-mall/trade");
        formParams.put("git_tag","development");
        formParams.put("rest_path","trade-rest-enterprise-1.0.0-SNAPSHOT.jar");
        formParams.put("version","test");
        formParams.put("module_name","trade");
        formParams.put("type","rest");
        formParams.put("bpmn_private","false");

        try {
            /*Call call = apiCommon.getCallPostFormData(localVarPath,formParams);
            Type localVarReturnType = new TypeToken<String>(){}.getType();
            ApiResponse<String> resp = apiClient.execute(call,null);
            System.out.println(resp.getData());*/

            /*Call call = apiCommon.getCallPostFormData(localVarPath,formParams);
            Type localVarReturnType = new TypeToken<String>(){}.getType();
            ApiResponse<String> resp = apiClient.execute(call,null);
            System.out.println(resp.getData());*/

            JenkinsApi jenkinsApi = new JenkinsApi();

            System.out.println(jenkinsApi.getBuildLog("pre-build","41"));




        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
