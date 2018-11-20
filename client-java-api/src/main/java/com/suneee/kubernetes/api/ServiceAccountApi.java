package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.KubernetesClient;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.role.V1Role;
import com.suneee.kubernetes.model.role.V1RoleBinding;
import com.suneee.kubernetes.model.service.V1ServiceAccount;
import okhttp3.Call;

import java.lang.reflect.Type;

public class ServiceAccountApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public ServiceAccountApi(){
        apiClient = KubernetesClient.getKubernetesClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public ServiceAccountApi(String kubernetesClientName){
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        apiCommon = new ApiCommon(apiClient);
    }

    public ServiceAccountApi setClient(String kubernetesClientName)throws ApiException {
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        if (apiClient == null){
            throw new ApiException("apiClient is null");
        }
        apiCommon = new ApiCommon(apiClient);
        return this;
    }

    public V1ServiceAccount createServiceAccount(String namespace, V1ServiceAccount serviceAccount) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (serviceAccount ==null){
            throw new ApiException("Missing the required parameter 'V1ServiceAccount'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/serviceaccounts"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,serviceAccount);
        Type localVarReturnType = new TypeToken<V1ServiceAccount>(){}.getType();
        ApiResponse<V1ServiceAccount> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1ServiceAccount updateServiceAccount(String namespace, String name, V1ServiceAccount serviceAccount)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        if (serviceAccount ==null){
            throw new ApiException("Missing the required parameter 'V1ServiceAccount'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/serviceaccounts/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallPut(localVarPath,serviceAccount);
        Type localVarReturnType = new TypeToken<V1ServiceAccount>(){}.getType();
        ApiResponse<V1ServiceAccount> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1ServiceAccount deleteServiceAccount(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        return deleteServiceAccount(namespace,name,deleteOptions);
    }


    public V1ServiceAccount deleteServiceAccount(String namespace,String name,V1DeleteOptions deleteOptions) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/api/v1/namespaces/{namespace}/serviceaccounts/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        Type localVarReturnType = new TypeToken<V1ServiceAccount>(){}.getType();
        ApiResponse<V1ServiceAccount> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1Role createRole(String namespace, V1Role role) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (role ==null){
            throw new ApiException("Missing the required parameter 'V1Role'");
        }

        String localVarPath = "/apis/rbac.authorization.k8s.io/v1/namespaces/{namespace}/roles"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,role);
        Type localVarReturnType = new TypeToken<V1Role>(){}.getType();
        ApiResponse<V1Role> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1Role deleteRole(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        return deleteRole(namespace,name,deleteOptions);
    }


    public V1Role deleteRole(String namespace,String name,V1DeleteOptions deleteOptions) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/apis/rbac.authorization.k8s.io/v1/namespaces/{namespace}/roles/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        Type localVarReturnType = new TypeToken<V1Role>(){}.getType();
        ApiResponse<V1Role> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public V1RoleBinding createRoleBinding(String namespace, V1RoleBinding roleBinding) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (roleBinding ==null){
            throw new ApiException("Missing the required parameter 'V1RoleBinding'");
        }

        String localVarPath = "/apis/rbac.authorization.k8s.io/v1/namespaces/{namespace}/rolebindings"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,roleBinding);
        Type localVarReturnType = new TypeToken<V1RoleBinding>(){}.getType();
        ApiResponse<V1RoleBinding> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }


    public V1RoleBinding deleteRoleBinding(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        return deleteRoleBinding(namespace,name,deleteOptions);
    }


    public V1RoleBinding deleteRoleBinding(String namespace,String name,V1DeleteOptions deleteOptions) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/apis/rbac.authorization.k8s.io/v1/namespaces/{namespace}/rolebindings/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        Type localVarReturnType = new TypeToken<V1RoleBinding>(){}.getType();
        ApiResponse<V1RoleBinding> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }
}
