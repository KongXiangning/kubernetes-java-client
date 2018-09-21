package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.KubernetesClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.endpoints.V1Endpoints;
import com.suneee.kubernetes.model.endpoints.V1EndpointsList;
import com.suneee.kubernetes.model.service.V1Service;
import com.suneee.kubernetes.model.service.V1ServiceList;
import com.suneee.kubernetes.model.status.V1Status;
import okhttp3.Call;

import java.lang.reflect.Type;

public class ServiceApi {
    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public ServiceApi(){
        apiClient = KubernetesClient.getKubernetesClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public ServiceApi(String kubernetesClientName){
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        apiCommon = new ApiCommon(apiClient);
    }

    public V1ServiceList getServiceList(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/services"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1ServiceList>(){}.getType();
        ApiResponse<V1ServiceList> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1ServiceList getServiceByLabel(String namespace,String labelname)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (labelname == null || labelname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'labelname'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/services?labelSelector=app in ({labelname})"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{labelname\\}", apiClient.escapeString(labelname));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1ServiceList>(){}.getType();
        ApiResponse<V1ServiceList> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Service getServiceByName(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/services/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1Service>(){}.getType();
        ApiResponse<V1Service> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Service createService(String namespace,V1Service service)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (service == null){
            throw new ApiException("Missing the required parameter 'V1Service'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/services"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,service);
        Type localVarReturnType = new TypeToken<V1Service>(){}.getType();
        ApiResponse<V1Service> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Service updateService(String namespace,String name,V1Service service)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        if (service ==null){
            throw new ApiException("Missing the required parameter 'V1Service'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/services/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallPut(localVarPath,service);
        Type localVarReturnType = new TypeToken<V1Service>(){}.getType();
        ApiResponse<V1Service> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Status deleteService(String namespace, String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        return deleteService(namespace,name,deleteOptions);
    }

    public V1Status deleteService(String namespace, String name, V1DeleteOptions deleteOptions)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/services/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);

        Type localVarReturnType = new TypeToken<V1Status>(){}.getType();
        ApiResponse<V1Status> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1EndpointsList getEndpointList(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/endpoints"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1EndpointsList>(){}.getType();
        ApiResponse<V1EndpointsList> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Endpoints getEndpointByLabel(String namespace,String labelname)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (labelname == null || labelname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'labelname'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/endpoints?labelSelector=app in ({labelname})"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{labelname\\}", apiClient.escapeString(labelname));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1Endpoints>(){}.getType();
        ApiResponse<V1Endpoints> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Endpoints getEndpointByName(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/endpoints/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1Endpoints>(){}.getType();
        ApiResponse<V1Endpoints> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Endpoints createEndpoint(String namespace,V1Endpoints endpoints)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (endpoints == null){
            throw new ApiException("Missing the required parameter 'V1Endpoints'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/endpoints"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,endpoints);
        Type localVarReturnType = new TypeToken<V1Endpoints>(){}.getType();
        ApiResponse<V1Endpoints> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Status deleteEndpoint(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        return deleteEndpoint(namespace,name,deleteOptions);
    }

    public V1Status deleteEndpoint(String namespace, String name, V1DeleteOptions deleteOptions)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/endpoints/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);

        Type localVarReturnType = new TypeToken<V1Status>(){}.getType();
        ApiResponse<V1Status> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }
}
