package com.suneee.kubernetes.api;

import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;

public class Event {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public Event(){
        apiClient = ApiClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }


}
