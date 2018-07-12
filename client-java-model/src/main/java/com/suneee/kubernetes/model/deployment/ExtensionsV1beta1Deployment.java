/*
 * Kubernetes
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.10.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.suneee.kubernetes.model.deployment;

import com.google.gson.annotations.SerializedName;
import com.suneee.kubernetes.custom.IntOrString;
import com.suneee.kubernetes.custom.Quantity;
import com.suneee.kubernetes.model.*;
import com.suneee.kubernetes.model.container.V1Container;
import com.suneee.kubernetes.model.container.V1ContainerPort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * DEPRECATED - This group version of Deployment is deprecated by apps/v1beta2/Deployment. See the release notes for more information. Deployment enables declarative updates for Pods and ReplicaSets.
 */
@ApiModel(description = "DEPRECATED - This group version of Deployment is deprecated by apps/v1beta2/Deployment. See the release notes for more information. Deployment enables declarative updates for Pods and ReplicaSets.")

public class ExtensionsV1beta1Deployment {
  @SerializedName("apiVersion")
  private String apiVersion = null;

  @SerializedName("kind")
  private String kind = null;

  @SerializedName("metadata")
  private V1ObjectMeta metadata = null;

  @SerializedName("spec")
  private ExtensionsV1beta1DeploymentSpec spec = null;

  @SerializedName("status")
  private ExtensionsV1beta1DeploymentStatus status = null;

  public ExtensionsV1beta1Deployment apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  public ExtensionsV1beta1Deployment(){
    this.apiVersion = "extensions/v1beta1";
    this.kind = "Deployment";
    this.metadata = new V1ObjectMeta();
    this.spec = new ExtensionsV1beta1DeploymentSpec();
  }

  public ExtensionsV1beta1Deployment(V1ObjectMeta metadata,ExtensionsV1beta1DeploymentSpec spec){
    this.apiVersion = "extensions/v1beta1";
    this.kind = "Deployment";
    this.metadata = metadata;
    this.spec = spec;
  }

  public ExtensionsV1beta1Deployment(String namespace,String name){
    this();
    setNamespace(namespace);
    setName(name);
  }

  public void setNamespace(String namespace){
    metadata.setNamespace(namespace);
  }

  public void setName(String name){
    metadata.setName(name);
    Map<String,String> labels = new HashMap<>();
    labels.put("app",name);
    metadata.setLabels(labels);

    Map<String,String> labelsspec = (Map<String, String>) ((HashMap<String, String>) labels).clone();
    spec.getTemplate().getMetadata().setLabels(labelsspec);
  }

  public void setReplicas(Integer replicas){
    spec.setReplicas(replicas);
  }

  public void setRevisionHistoryLimit(Integer revisionHistoryLimit){
    spec.setRevisionHistoryLimit(revisionHistoryLimit);
  }

  public void addContainer(V1Container container) {
    spec.getTemplate().getSpec().addContainersItem(container);
  }

  public ExtensionsV1beta1Deployment addEnv(String key,String value){
    return addEnv(0,key,value);
  }

  public ExtensionsV1beta1Deployment addEnv(int index,String key,String value){
    if (spec.getTemplate().getSpec().getContainers().get(index) != null){
      spec.getTemplate().getSpec().getContainers().get(index).addEnvItem(new V1EnvVar(key,value));
    }
    return this;
  }

  public ExtensionsV1beta1Deployment addPort(Integer port){
    return addPort(0,port);
  }

  public ExtensionsV1beta1Deployment addPort(int index,Integer port){
    if (spec.getTemplate().getSpec().getContainers().get(index) != null){
      spec.getTemplate().getSpec().getContainers().get(index).addPortsItem(new V1ContainerPort().containerPort(port));
    }
    return this;
  }

  public ExtensionsV1beta1Deployment setResource(String limitsCpu,String limitsmem){
    return setResource(0,limitsCpu,limitsmem);
  }

  public ExtensionsV1beta1Deployment setResource(String limitsCpu,String limitsmem,String requestsCpu,String requestsmen){
    return setResource(0,limitsCpu,limitsmem,requestsCpu,requestsmen);
  }

  public ExtensionsV1beta1Deployment setResource(int index,String limitsCpu,String limitsmem){
    return setResource(index,limitsCpu,limitsmem,null,null);
  }

  public ExtensionsV1beta1Deployment setResource(int index,String limitsCpu,String limitsmem,String requestsCpu,String requestsmen){
    if (spec.getTemplate().getSpec().getContainers().get(index) != null){
      V1ResourceRequirements resource = new V1ResourceRequirements();
      if (limitsCpu != null && !limitsCpu.isEmpty()){
        resource.putLimitsItem("cpu",new Quantity(limitsCpu));
      }
      if (limitsmem != null && !limitsmem.isEmpty()){
        resource.putLimitsItem("menory",new Quantity(limitsmem));
      }
      if (requestsCpu != null && !requestsCpu.isEmpty()){
        resource.putRequestsItem("cpu",new Quantity(requestsCpu));
      }
      if (requestsmen != null && !requestsmen.isEmpty()){
        resource.putRequestsItem("menory",new Quantity(requestsmen));
      }
      spec.getTemplate().getSpec().getContainers().get(index).resources(resource);
    }
    return this;
  }

  public void addContainer(String name,String imagesName){
    addContainer(name,imagesName,null,null,null);
  }

  public void addContainer(String name,String imagesName,List<Integer> portList){
    addContainer(name,imagesName,portList,null,null);
  }

  public void addContainer(String name, String imagesName, List<Integer> portList,HashMap<String,String> envs,V1ResourceRequirements resource){
    V1Container container = new V1Container();
    container.setName(name);
    container.setImage(imagesName);
    container.setImagePullPolicy("Always");
    if (portList != null && portList.size()>0){
      for (Integer port : portList) {
        container.addPortsItem(new V1ContainerPort().containerPort(port));
      }
      V1TCPSocketAction tcpSocket = new V1TCPSocketAction().port(new IntOrString(portList.get(0)));
      V1Probe probe = new V1Probe().tcpSocket(tcpSocket);
      container.livenessProbe(probe);
      container.readinessProbe(probe);
    }


    if (envs != null && envs.size()>0){
      for (Map.Entry<String, String> entry : envs.entrySet()) {
        container.addEnvItem(new V1EnvVar(entry.getKey(),entry.getValue()));
      }
    }

    if (resource != null) container.resources(resource);
    this.addContainer(container);
  }

   /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#resources
   * @return apiVersion
  **/
  @ApiModelProperty(value = "APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#resources")
  public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public ExtensionsV1beta1Deployment kind(String kind) {
    this.kind = kind;
    return this;
  }

   /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#types-kinds
   * @return kind
  **/
  @ApiModelProperty(value = "Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#types-kinds")
  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public ExtensionsV1beta1Deployment metadata(V1ObjectMeta metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Standard object metadata.
   * @return metadata
  **/
  @ApiModelProperty(value = "Standard object metadata.")
  public V1ObjectMeta getMetadata() {
    return metadata;
  }

  public void setMetadata(V1ObjectMeta metadata) {
    this.metadata = metadata;
  }

  public ExtensionsV1beta1Deployment spec(ExtensionsV1beta1DeploymentSpec spec) {
    this.spec = spec;
    return this;
  }

   /**
   * Specification of the desired behavior of the Deployment.
   * @return spec
  **/
  @ApiModelProperty(value = "Specification of the desired behavior of the Deployment.")
  public ExtensionsV1beta1DeploymentSpec getSpec() {
    return spec;
  }

  public void setSpec(ExtensionsV1beta1DeploymentSpec spec) {
    this.spec = spec;
  }

  public ExtensionsV1beta1Deployment status(ExtensionsV1beta1DeploymentStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Most recently observed status of the Deployment.
   * @return status
  **/
  @ApiModelProperty(value = "Most recently observed status of the Deployment.")
  public ExtensionsV1beta1DeploymentStatus getStatus() {
    return status;
  }

  public void setStatus(ExtensionsV1beta1DeploymentStatus status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtensionsV1beta1Deployment extensionsV1beta1Deployment = (ExtensionsV1beta1Deployment) o;
    return Objects.equals(this.apiVersion, extensionsV1beta1Deployment.apiVersion) &&
        Objects.equals(this.kind, extensionsV1beta1Deployment.kind) &&
        Objects.equals(this.metadata, extensionsV1beta1Deployment.metadata) &&
        Objects.equals(this.spec, extensionsV1beta1Deployment.spec) &&
        Objects.equals(this.status, extensionsV1beta1Deployment.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiVersion, kind, metadata, spec, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtensionsV1beta1Deployment {\n");

    sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

