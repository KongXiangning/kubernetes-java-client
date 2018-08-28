package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.KubernetesClient;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.persistentvolume.V1PersistentVolume;
import com.suneee.kubernetes.model.persistentvolume.V1PersistentVolumeClaim;
import okhttp3.Call;

import java.lang.reflect.Type;

public class VolumeApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public VolumeApi(){
        apiClient = KubernetesClient.getKubernetesClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public V1PersistentVolume createPersistentVolume(V1PersistentVolume persistentVolume)throws ApiException{
        if (persistentVolume == null) {
            throw new ApiException("Missing the required parameter 'V1PersistentVolume'");
        }

        String localVarPath = "/api/v1/persistentvolumes";

        Call call = apiCommon.getCallPost(localVarPath,persistentVolume);
        Type localVarReturnType = new TypeToken<V1PersistentVolume>(){}.getType();
        ApiResponse<V1PersistentVolume> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1PersistentVolume getPersistentVolume(String name)throws ApiException{
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/persistentvolumes/{name}"
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1PersistentVolume>(){}.getType();
        ApiResponse<V1PersistentVolume> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public void deletePersistentVolume(String name)throws ApiException{
        deletePersistentVolume(name,new V1DeleteOptions());
    }

    public void deletePersistentVolume(String name,V1DeleteOptions deleteOptions)throws ApiException{
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/persistentvolumes/{name}"
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        apiClient.execute(call,null);
    }

    public V1PersistentVolumeClaim createPersistentVolumeClaim(String namespace,V1PersistentVolumeClaim persistentVolumeClaim)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (persistentVolumeClaim == null) {
            throw new ApiException("Missing the required parameter 'V1PersistentVolumeClaim'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/persistentvolumeclaims"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,persistentVolumeClaim);
        Type localVarReturnType = new TypeToken<V1PersistentVolumeClaim>(){}.getType();
        ApiResponse<V1PersistentVolumeClaim> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1PersistentVolumeClaim getPersistentVolumeClaim(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/persistentvolumeclaims/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1PersistentVolumeClaim>(){}.getType();
        ApiResponse<V1PersistentVolumeClaim> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public void deletePersistentVolumeClaim(String namespace,String name)throws ApiException{
        deletePersistentVolumeClaim(namespace,name,new V1DeleteOptions());
    }

    public void deletePersistentVolumeClaim(String namespace,String name,V1DeleteOptions deleteOptions)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/persistentvolumeclaims/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        apiClient.execute(call,null);
    }

}
