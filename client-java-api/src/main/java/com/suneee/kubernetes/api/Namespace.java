package com.suneee.kubernetes.api;


import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.namespace.V1Namespace;
import com.suneee.kubernetes.model.namespace.V1NamespaceList;
import okhttp3.Call;

import java.lang.reflect.Type;

public class Namespace {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public Namespace(){
        apiClient = ApiClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public V1NamespaceList getNamespaces() throws ApiException {
        String localVarPath = "/api/v1/namespaces/";

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1NamespaceList>(){}.getType();
        ApiResponse<V1NamespaceList> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

    public V1Namespace createNamespaceDeployment(V1Namespace body)throws ApiException{
        String localVarPath = "/api/v1/namespaces/";

        Call call = apiCommon.getCallPost(localVarPath,body);
        Type localVarReturnType = new TypeToken<V1Namespace>(){}.getType();
        ApiResponse<V1Namespace> resp = apiClient.execute(call, localVarReturnType);
        return resp.getData();
    }

}
