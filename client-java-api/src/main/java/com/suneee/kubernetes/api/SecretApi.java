package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.KubernetesClient;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.secret.V1Secret;
import okhttp3.Call;

import java.lang.reflect.Type;

public class SecretApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public SecretApi(){
        apiClient = KubernetesClient.getKubernetesClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public SecretApi(String kubernetesClientName){
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        apiCommon = new ApiCommon(apiClient);
    }
    public SecretApi setClient(String kubernetesClientName)throws ApiException{
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        if (apiClient == null){
            throw new ApiException("apiClient is null");
        }
        apiCommon = new ApiCommon(apiClient);
        return this;
    }


    public V1Secret createSecret(String namespace, String name, String key, String value)throws ApiException{
        V1Secret secret = new V1Secret(namespace,name);
        secret.setData(key,value);
        return createSecret(namespace,secret);
    }

    public V1Secret createSecret(String namespace, V1Secret secret)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (secret ==null){
            throw new ApiException("Missing the required parameter 'V1Secret'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/secrets"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,secret);
        Type localVarReturnType = new TypeToken<V1Secret>(){}.getType();
        ApiResponse<V1Secret> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1Secret getSecret(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/secrets/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1Secret>(){}.getType();
        ApiResponse<V1Secret> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public void deleteSecret(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        deleteSecret(namespace,name,deleteOptions);
    }

    public void deleteSecret(String namespace,String name,V1DeleteOptions deleteOptions)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/secrets/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        apiClient.execute(call,null);
    }
}
