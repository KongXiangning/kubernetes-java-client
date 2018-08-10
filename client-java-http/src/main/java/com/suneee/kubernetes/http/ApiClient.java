package com.suneee.kubernetes.http;

import com.suneee.kubernetes.ApiResponse;
import okhttp3.Call;
import okhttp3.OkHttpClient;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public interface ApiClient {

    List<Pair> parameterToPair(String name, Object value) throws ApiException;

    String selectHeaderAccept(String[] accepts) throws ApiException;

    String selectHeaderContentType(String[] contentTypes) throws ApiException;

    OkHttpClient getHttpClient() throws ApiException;

    Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException;

    <T> ApiResponse<T> execute(Call call, Type returnType) throws ApiException;

    String escapeString(String str);
}
