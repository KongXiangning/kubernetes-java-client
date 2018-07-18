package com.suneee.kubernetes.common;

import com.suneee.kubernetes.http.*;
import io.swagger.annotations.Api;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiCommon {

    private ApiClient apiClient;
    public ApiCommon(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    final String[] localVarAccepts = {
            "application/json", "application/yaml", "application/vnd.kubernetes .protobuf"
    };

    final String[] localVarContentTypes = {
            "application/json", "application/yaml", "application/vnd.kubernetes.protobuf"
    };

    public void isNotNull(Object... objects)throws ApiException{
        for (Object object : objects) {

        }
    }

    public Call getCall(final String localVarPath,final String method,final Object localVarPostBody,final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        localVarQueryParams.addAll(apiClient.parameterToPair("pretty", "true"));

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "BearerToken" };
        Call call = apiClient.buildCall(localVarPath, method, localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
        return call;
    }

    public Call getCallnoListener(final String localVarPath,final String method,final Object localVarPostBody)throws ApiException{
        return getCall(localVarPath,method,localVarPostBody,null,null);
    }

    public Call getCallGet(final String localVarPath)throws ApiException{
        return getCallnoListener(localVarPath,"GET",null);
    }

    public Call getCallPost(final String localVarPath,final Object localVarPostBody)throws ApiException{
        return getCallnoListener(localVarPath,"POST",localVarPostBody);
    }

    public Call getCallPut(final String localVarPath,final Object localVarPostBody)throws ApiException{
        return getCallnoListener(localVarPath,"PUT",localVarPostBody);
    }

    public Call getCallDelete(final String localVarPath,final Object localVarPostBody)throws ApiException{
        return getCallnoListener(localVarPath,"DELETE",localVarPostBody);
    }
}
