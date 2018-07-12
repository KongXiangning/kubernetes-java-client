package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.deployment.*;
import okhttp3.Call;

import java.lang.reflect.Type;

public class Deployment {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public Deployment(){
        apiClient = ApiClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public ExtensionsV1beta1Deployment createNamespacedDeployment(String namespace, ExtensionsV1beta1Deployment deployment) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (deployment ==null){
            throw new ApiException("Missing the required parameter 'V1Deployment'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/deployments"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,deployment);
        Type localVarReturnType = new TypeToken<ExtensionsV1beta1Deployment>(){}.getType();
        ApiResponse<ExtensionsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public ExtensionsV1beta1Deployment getNamespaceDeploymentlist(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/deployments"
                 .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<ExtensionsV1beta1Deployment>(){}.getType();
        ApiResponse<ExtensionsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }


    public ExtensionsV1beta1Deployment deleteNamespaceDeployment(String namespace,String name,V1DeleteOptions deleteOptions) throws ApiException{

        if (deleteOptions == null){
            deleteOptions = new V1DeleteOptions();
        }

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/deployments/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}",apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        Type localVarReturnType = new TypeToken<ExtensionsV1beta1Deployment>(){}.getType();
        ApiResponse<ExtensionsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }
}
