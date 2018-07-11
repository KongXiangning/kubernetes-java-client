package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.ingress.V1beta1Ingress;
import com.suneee.kubernetes.model.ingress.V1beta1IngressList;
import com.suneee.kubernetes.model.service.V1Service;
import okhttp3.Call;

import java.lang.reflect.Type;

public class Ingress {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public Ingress(){
        apiClient = ApiClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public V1beta1IngressList getIngressList(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/ingresses"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1beta1IngressList>(){}.getType();
        ApiResponse<V1beta1IngressList> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1beta1Ingress getIngressByName(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/ingresses/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1beta1Ingress>(){}.getType();
        ApiResponse<V1beta1Ingress> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1beta1Ingress getIngressByLabelname(String namespace,String labelname)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (labelname == null || labelname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'labelname'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/ingresses?labelSelector=app in ({labelname})"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{labelname\\}", apiClient.escapeString(labelname));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1beta1Ingress>(){}.getType();
        ApiResponse<V1beta1Ingress> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1beta1Ingress createIngress(String namespace,V1beta1Ingress ingressBody)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (ingressBody == null){
            throw new ApiException("Missing the required parameter 'V1beta1Ingress'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/ingresses"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,ingressBody);
        Type localVarReturnType = new TypeToken<V1beta1Ingress>(){}.getType();
        ApiResponse<V1beta1Ingress> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1beta1Ingress deleteIngress(String namespace,String ingressName)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (ingressName == null || ingressName.isEmpty()) {
            throw new ApiException("Missing the required parameter 'ingressName'");
        }

        String localVarPath = "/apis/extensions/v1beta1/namespaces/{namespace}/ingresses/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(ingressName));

        Call call = apiCommon.getCallDelete(localVarPath,null);

        Type localVarReturnType = new TypeToken<V1beta1Ingress>(){}.getType();
        ApiResponse<V1beta1Ingress> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

}
