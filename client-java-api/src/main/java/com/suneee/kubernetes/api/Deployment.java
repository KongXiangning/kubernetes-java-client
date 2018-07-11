package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.deployment.V1Deployment;
import com.suneee.kubernetes.model.deployment.V1DeploymentList;
import okhttp3.Call;

import java.lang.reflect.Type;

public class Deployment {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public Deployment(){
        apiClient = ApiClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public V1Deployment createNamespacedDeployment(String namespace,V1Deployment deployment) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (deployment ==null){
            throw new ApiException("Missing the required parameter 'V1Deployment'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/deployments"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,deployment);
        Type localVarReturnType = new TypeToken<V1Deployment>(){}.getType();
        ApiResponse<V1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1DeploymentList getNamespaceDeploymentlist(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/deployments"
                 .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1DeploymentList>(){}.getType();
        ApiResponse<V1DeploymentList> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }


    public V1Deployment deleteNamespaceDeployment(String namespace,String name) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/deployments/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}",apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,null);
        Type localVarReturnType = new TypeToken<V1Deployment>(){}.getType();
        ApiResponse<V1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }
}
