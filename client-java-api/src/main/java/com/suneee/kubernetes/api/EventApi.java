package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.event.V1Event;
import com.suneee.kubernetes.model.event.V1EventList;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EventApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public EventApi(){
        apiClient = ApiClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public V1EventList getEventList(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/events"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1EventList>(){}.getType();
        ApiResponse<V1EventList> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1EventList getEventListByName(String namespace,String name)throws ApiException{
        return getEventListByName(namespace,name,null);
    }

    public V1EventList getEventListByName(String namespace,String name,String kind)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/events?fieldSelector=involvedObject.name={name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1EventList>(){}.getType();
        ApiResponse<V1EventList> resp = apiClient.execute(call,localVarReturnType);
        V1EventList result = resp.getData();

        if (kind != null && !kind.isEmpty()){
            List<V1Event> tmp = new ArrayList<>();
            for (int i = 0; i < result.getItems().size(); i++) {
                 if (result.getItems().get(i).getInvolvedObject().getKind().equalsIgnoreCase(kind)){
                    tmp.add(result.getItems().get(i));
                 }
            }
            result.items(tmp);
        }
        return result;
    }
}
