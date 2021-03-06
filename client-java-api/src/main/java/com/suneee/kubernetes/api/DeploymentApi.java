package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.KubernetesClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.model.V1DeleteOptions;
import com.suneee.kubernetes.model.deployment.*;
import okhttp3.Call;

import java.lang.reflect.Type;

public class DeploymentApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public DeploymentApi(){
        apiClient = KubernetesClient.getKubernetesClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public DeploymentApi(String kubernetesClientName){
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        apiCommon = new ApiCommon(apiClient);
    }

    public DeploymentApi setClient(String kubernetesClientName)throws ApiException{
        apiClient = KubernetesClient.getKubernetesClient(kubernetesClientName);
        if (apiClient == null){
            throw new ApiException("apiClient is null");
        }
        apiCommon = new ApiCommon(apiClient);
        return this;
    }

    public AppsV1beta1Deployment createNamespaceDeployment(String namespace, AppsV1beta1Deployment deployment) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (deployment ==null){
            throw new ApiException("Missing the required parameter 'V1Deployment'");
        }

        String localVarPath = "/apis/apps/v1beta1/namespaces/{namespace}/deployments"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallPost(localVarPath,deployment);
        Type localVarReturnType = new TypeToken<AppsV1beta1Deployment>(){}.getType();
        ApiResponse<AppsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public AppsV1beta1Deployment updateNamespaceDeployment(String namespace, String name, AppsV1beta1Deployment deployment)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }

        if (deployment ==null){
            throw new ApiException("Missing the required parameter 'V1Deployment'");
        }

        String localVarPath = "/apis/apps/v1beta1/namespaces/{namespace}/deployments/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallPut(localVarPath,deployment);
        Type localVarReturnType = new TypeToken<AppsV1beta1Deployment>(){}.getType();
        ApiResponse<AppsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public AppsV1beta1DeploymentList getNamespaceDeploymentlist(String namespace)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        String localVarPath = "/apis/apps/v1beta1/namespaces/{namespace}/deployments"
                 .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<AppsV1beta1DeploymentList>(){}.getType();
        ApiResponse<AppsV1beta1DeploymentList> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public AppsV1beta1DeploymentList getNamespaceDeploymentByLabelname(String namespace,String labelname)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (labelname == null || labelname.isEmpty()) {
            throw new ApiException("Missing the required parameter 'labelname'");
        }

        String localVarPath = "/apis/apps/v1beta1/namespaces/{namespace}/deployments?labelSelector=app in ({labelname})"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"labelname"+"\\}", apiClient.escapeString(labelname));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<AppsV1beta1DeploymentList>(){}.getType();
        ApiResponse<AppsV1beta1DeploymentList> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public AppsV1beta1Deployment getNamespaceDeploymentByName(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        String localVarPath = "/apis/apps/v1beta1/namespaces/{namespace}/deployments/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<AppsV1beta1Deployment>(){}.getType();
        ApiResponse<AppsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public AppsV1beta1Deployment getNamespaceDeploymentStatusByName(String namespace,String name)throws ApiException{
        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }

        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        String localVarPath = "/apis/apps/v1beta1/namespaces/{namespace}/deployments/{name}/status"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGet(localVarPath);
        Type localVarReturnType = new TypeToken<AppsV1beta1Deployment>(){}.getType();
        ApiResponse<AppsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }


    public AppsV1beta1Deployment deleteNamespaceDeployment(String namespace,String name)throws ApiException{
        V1DeleteOptions deleteOptions = new V1DeleteOptions();
        return deleteNamespaceDeployment(namespace,name,deleteOptions);
    }


    public AppsV1beta1Deployment deleteNamespaceDeployment(String namespace,String name,V1DeleteOptions deleteOptions) throws ApiException{

        if (namespace == null || namespace.isEmpty()) {
            throw new ApiException("Missing the required parameter 'namespace'");
        }
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        if (deleteOptions ==null){
            throw new ApiException("Missing the required parameter 'V1DeleteOptions'");
        }

        String localVarPath = "/apis/apps/v1beta1/namespaces/{namespace}/deployments/{name}"
                .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace))
                .replaceAll("\\{"+"name"+"\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallDelete(localVarPath,deleteOptions);
        Type localVarReturnType = new TypeToken<AppsV1beta1Deployment>(){}.getType();
        ApiResponse<AppsV1beta1Deployment> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }
}
