package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.KubernetesClient;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.deployment.AppsV1beta1Deployment;
import com.suneee.kubernetes.model.deployment.AppsV1beta1DeploymentList;
import com.suneee.kubernetes.model.statefulset.V1StatefulSet;
import com.suneee.kubernetes.model.statefulset.V1StatefulSetList;
import okhttp3.Call;

import java.lang.reflect.Type;

public class StatefulSetApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public StatefulSetApi(){
        apiClient = KubernetesClient.getKubernetesClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public StatefulSetApi(String kubernetesClientName){
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        apiCommon = new ApiCommon(apiClient);
    }

    public StatefulSetApi setClient(String kubernetesClientName)throws ApiException {
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        if (apiClient == null){
            throw new ApiException("apiClient is null");
        }
        apiCommon = new ApiCommon(apiClient);
        return this;
    }

    public V1StatefulSet createStatefulSet(String namespace, V1StatefulSet statefulSet) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (statefulSet ==null){
            throw new ApiException("Missing the required parameter 'V1StatefulSet'");
        }

        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/statefulsets"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,statefulSet);
        Type localVarReturnType = new TypeToken<V1StatefulSet>(){}.getType();
        ApiResponse<V1StatefulSet> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1StatefulSet updateStatefulSet(String namespace, String name, V1StatefulSet statefulSet)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        if (statefulSet ==null){
            throw new ApiException("Missing the required parameter 'V1StatefulSet'");
        }

        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/statefulsets/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallPut(localVarPath,statefulSet);
        Type localVarReturnType = new TypeToken<V1StatefulSet>(){}.getType();
        ApiResponse<V1StatefulSet> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1StatefulSetList getNamespaceStatefulSetlist(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/statefulsets"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1StatefulSetList>(){}.getType();
        ApiResponse<V1StatefulSetList> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1StatefulSetList getNamespaceStatefulSetByLabelname(String namespace,String labelname)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (labelname == null || labelname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'labelname'");
        }

        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/statefulsets?labelSelector=app in ({labelname})"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"labelname"+"\\}", apiClient.escapeString(labelname));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1StatefulSetList>(){}.getType();
        ApiResponse<V1StatefulSetList> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1StatefulSet getNamespaceStatefulSetByName(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/statefulsets/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1StatefulSet>(){}.getType();
        ApiResponse<V1StatefulSet> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1StatefulSet getNamespaceStatefulSetStatusByName(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/statefulsets/{name}/status"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<V1StatefulSet>(){}.getType();
        ApiResponse<V1StatefulSet> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1StatefulSet deleteNamespaceStatefulSet(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        return deleteNamespaceDeployment(namespace,name,deleteOptions);
    }


    public V1StatefulSet deleteNamespaceDeployment(String namespace,String name,V1DeleteOptions deleteOptions) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/statefulsets/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        Type localVarReturnType = new TypeToken<V1StatefulSet>(){}.getType();
        ApiResponse<V1StatefulSet> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

}
