package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.JenkinsClient;
import com.suneee.kubernetes.model.jenkins.JenkinsState;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.util.Map;

public class JenkinsApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public JenkinsApi(){
        apiClient = JenkinsClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public String buildProject(String jobName,Map<String, Object> formParams) throws ApiException{
        if (jobName == null || jobName.isEmpty()) {
            throw new ApiException("Missing the required parameter 'jobName'");
        }
        if (formParams == null || formParams.size()==0){
            throw new ApiException("Missing the required parameter 'formParams'");
        }

        String buildVarPath = "/job/{jobName}/buildWithParameters"
                .replaceAll("\\{" + "jobName" + "\\}", apiClient.escapeString(jobName));

        String searchVarPath = "/job/{jobName}/lastBuild/buildNumber"
                .replaceAll("\\{" + "jobName" + "\\}", apiClient.escapeString(jobName));


        Call buildCall = apiCommon.getCallPostFormData(buildVarPath,formParams);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        synchronized (JenkinsApi.class){
            Call jobNumCall = apiCommon.getCallGetFormData(searchVarPath);
            ApiResponse<String> tmpResp = apiClient.execute(jobNumCall,localVarReturnType);
            int jobNum = Integer.parseInt(tmpResp.getData())+1;
            System.out.println("image_name:"+formParams.get("image_name"));
            System.out.println("jobNum:"+jobNum);

            apiClient.execute(buildCall,null);

            int tmpNum = -1;
            while (jobNum != tmpNum){
                Call searchCall = apiCommon.getCallGetFormData(searchVarPath);
                ApiResponse<String> resp = apiClient.execute(searchCall,localVarReturnType);
                tmpNum = Integer.parseInt(resp.getData());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return String.valueOf(tmpNum);
        }
    }

    public String getBuildState(String jobName,String jobNum)throws ApiException{
        if (jobName == null || jobName.isEmpty()) {
            throw new ApiException("Missing the required parameter 'jobName'");
        }
        if (jobNum == null || jobNum.isEmpty()){
            throw new ApiException("Missing the required parameter 'jobNum'");
        }

        String localVarPath = "/job/{jobName}/{jobNum}/api/json?pretty=true&tree=result"
                .replaceAll("\\{" + "jobName" + "\\}", apiClient.escapeString(jobName))
                .replaceAll("\\{" + "jobNum" + "\\}", apiClient.escapeString(jobNum));

        Call call = apiCommon.getCallGetFormData(localVarPath);
        Type localVarReturnType = new TypeToken<JenkinsState>(){}.getType();
        ApiResponse<JenkinsState> resp = apiClient.execute(call,localVarReturnType);
        JenkinsState state = resp.getData();
        if (state.getResult() == null || state.getResult().isEmpty()){
            return "build";
        }
        return state.getResult();
    }

    public String getBuildLog(String jobName,String jobNum)throws ApiException{
        if (jobName == null || jobName.isEmpty()) {
            throw new ApiException("Missing the required parameter 'jobName'");
        }
        if (jobNum == null || jobNum.isEmpty()){
            throw new ApiException("Missing the required parameter 'jobNum'");
        }

        /*String localVarPath = "/job/{jobName}/{jobNum}/consoleText?pretty=true"
                .replaceAll("\\{" + "jobName" + "\\}", apiClient.escapeString(jobName))
                .replaceAll("\\{" + "jobNum" + "\\}", apiClient.escapeString(jobNum));*/
        String localVarPath = "/job/{jobName}/{jobNum}/logText/progressiveHtml"
                .replaceAll("\\{" + "jobName" + "\\}", apiClient.escapeString(jobName))
                .replaceAll("\\{" + "jobNum" + "\\}", apiClient.escapeString(jobNum));

        Call call = apiCommon.getCallGetFormData(localVarPath);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        ApiResponse<String> resp = apiClient.execute(call,localVarReturnType);

        return resp.getData();
    }
}
