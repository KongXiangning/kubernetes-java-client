package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.service.V1Service;
import com.suneee.kubernetes.model.service.V1ServiceList;
import okhttp3.Call;

import java.lang.reflect.Type;

public class Service {
    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public Service(){
        apiClient = ApiClient.getApiClient();
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

    public V1Service getServiceByLabel(String namespace,String labelname)throws ApiException{
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

    public V1Service deleteService(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/services/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,null);

        Type localVarReturnType = new TypeToken<V1Service>(){}.getType();
        ApiResponse<V1Service> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }
}
