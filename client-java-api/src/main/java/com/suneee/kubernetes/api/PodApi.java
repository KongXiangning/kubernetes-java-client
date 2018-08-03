package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.deployment.AppsV1beta1Deployment;
import com.suneee.kubernetes.model.pod.V1Pod;
import com.suneee.kubernetes.model.pod.V1PodList;
import com.suneee.kubernetes.model.pod.V1PodStatus;
import okhttp3.Call;

import java.lang.reflect.Type;

public class PodApi {
    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public PodApi(){
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

    public V1PodStatus getPodStatus(String namespace,String podname) throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (podname == null || podname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'podname'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/pods/{name}/status"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(podname));

        Call call = apiCommon.getCallGet(localVarPath);

        Type localVarReturnType = new TypeToken<V1PodStatus>(){}.getType();
        ApiResponse<V1PodStatus> resp = apiClient.execute(call, localVarReturnType);
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

    public void deletePodByLabel(String namespace,String labelname)throws ApiException{
        V1PodList podList = getPodListByLabel(namespace,labelname);
        for (V1Pod pod : podList.getItems()) {
            deletePodByName(namespace,pod.getMetadata().getName());
        }
    }

    public void deletePodByName(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        deletePodByName(namespace,name,deleteOptions);
    }

    public void deletePodByName(String namespace,String name,V1DeleteOptions deleteOptions)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/pods/{name}"
                .replaceAll("\\{namespace\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{name\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        Type localVarReturnType = new TypeToken<AppsV1beta1Deployment>(){}.getType();
        apiClient.execute(call,localVarReturnType);
    }
}
