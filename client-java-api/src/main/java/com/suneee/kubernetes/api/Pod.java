package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.pod.V1Pod;
import com.suneee.kubernetes.model.pod.V1PodList;
import okhttp3.Call;

import java.lang.reflect.Type;

public class Pod {
    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public Pod(){
        apiClient = ApiClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public V1Pod getPod(String namespace,String podname) throws ApiException {

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (podname == null || podname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'podname'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/pods/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(podname));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1Pod>(){}.getType();
        ApiResponse<V1Pod> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1PodList getPodListByLabel(String namespace,String labelname)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (labelname == null || labelname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'labelname'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/pods?labelSelector=app in ({labelname})"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{labelname\\}", apiClient.escapeString(labelname));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1PodList>(){}.getType();
        ApiResponse<V1PodList> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }
}
