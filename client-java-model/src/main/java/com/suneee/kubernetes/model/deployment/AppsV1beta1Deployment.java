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
import com.suneee.kubernetes.constant.ImagePullPolicy;
import com.suneee.kubernetes.custom.IntOrString;
import com.suneee.kubernetes.custom.Quantity;
import com.suneee.kubernetes.model.*;
import com.suneee.kubernetes.model.container.V1Container;
import com.suneee.kubernetes.model.container.V1ContainerPort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.*;

/**
 * DEPRECATED - This group version of Deployment is deprecated by apps/v1beta2/Deployment. See the release notes for more information. Deployment enables declarative updates for Pods and ReplicaSets.
 */
@ApiModel(description = "DEPRECATED - This group version of Deployment is deprecated by apps/v1beta2/Deployment. See the release notes for more information. Deployment enables declarative updates for Pods and ReplicaSets.")

public class AppsV1beta1Deployment {
  @SerializedName("apiVersion")
  private String apiVersion = null;

  @SerializedName("kind")
  private String kind = null;

  @SerializedName("metadata")
  private V1ObjectMeta metadata = null;

  @SerializedName("spec")
  private AppsV1beta1DeploymentSpec spec = null;

  @SerializedName("status")
  private AppsV1beta1DeploymentStatus status = null;

  public AppsV1beta1Deployment apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  public AppsV1beta1Deployment(){
    this.apiVersion = "apps/v1beta1";
    this.kind = "Deployment";
    this.metadata = new V1ObjectMeta();
    this.spec = new AppsV1beta1DeploymentSpec();
//    this.spec.getTemplate().getSpec().setDnsPolicy("Default");
  }

  public AppsV1beta1Deployment(V1ObjectMeta metadata,AppsV1beta1DeploymentSpec spec){
    this.apiVersion = "apps/v1beta1";
    this.kind = "Deployment";
    this.metadata = metadata;
    this.spec = spec;
  }

  public AppsV1beta1Deployment(String namespace,String name){
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

  public AppsV1beta1Deployment addEnv(String key,String value){
    return addEnv(0,key,value);
  }

  public AppsV1beta1Deployment addEnv(int index,String key,String value){
    if (spec.getTemplate().getSpec().getContainers().get(index) != null){
      spec.getTemplate().getSpec().getContainers().get(index).addEnvItem(new V1EnvVar(key,value));
    }
    return this;
  }

  public AppsV1beta1Deployment addPort(int port){
    return addPort(0,port);
  }

  public AppsV1beta1Deployment addPort(int index,int port){
    if (spec.getTemplate().getSpec().getContainers().get(index) != null){
        deletePort(index,port);
        spec.getTemplate().getSpec().getContainers().get(index).addPortsItem(new V1ContainerPort().containerPort(port));
    }
    return this;
  }

  public AppsV1beta1Deployment deletePort(int port){
      return deletePort(0,port);
  }

  public AppsV1beta1Deployment deletePort(int index,int port){
      if (spec.getTemplate().getSpec().getContainers().get(index) != null){
          List<V1ContainerPort> portList = spec.getTemplate().getSpec().getContainers().get(index).getPorts();
          for (int i = 0; i < portList.size(); i++) {
              V1ContainerPort containerPort = portList.get(i);
              if (containerPort.getContainerPort() == port){
                  portList.remove(i);
                  break;
              }
          }
      }
      return this;
  }

  public AppsV1beta1Deployment setResource(String limitsCpu,String limitsmem){
    return setResource(0,limitsCpu,limitsmem);
  }

  public AppsV1beta1Deployment setResource(String limitsCpu,String limitsmem,String requestsCpu,String requestsmen){
    return setResource(0,limitsCpu,limitsmem,requestsCpu,requestsmen);
  }

  public AppsV1beta1Deployment setResource(int index,String limitsCpu,String limitsmem){
    return setResource(index,limitsCpu,limitsmem,null,null);
  }

  public AppsV1beta1Deployment setResource(int index,String limitsCpu,String limitsmem,String requestsCpu,String requestsmen){
    if (spec.getTemplate().getSpec().getContainers().get(index) != null){
      V1ResourceRequirements resource = new V1ResourceRequirements();
      if (limitsCpu != null && !limitsCpu.isEmpty()){
        resource.putLimitsItem("cpu",new Quantity(limitsCpu));
      }
      if (limitsmem != null && !limitsmem.isEmpty()){
        resource.putLimitsItem("memory",new Quantity(limitsmem));
      }
      if (requestsCpu != null && !requestsCpu.isEmpty()){
        resource.putRequestsItem("cpu",new Quantity(requestsCpu));
      }
      if (requestsmen != null && !requestsmen.isEmpty()){
        resource.putRequestsItem("memory",new Quantity(requestsmen));
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

  public void addContainer(String name,String imagesName,List<Integer> portList,HashMap<String,String> envs){
    addContainer(name,imagesName,portList,envs,null);
  }

  public void addContainer(String name,String imagesName,Integer port,HashMap<String,String> envs){
    List<Integer> portList = new ArrayList<Integer>();
    portList.add(port);
    addContainer(name,imagesName,portList,envs,null);
  }

  public AppsV1beta1Deployment addContainer(String name, String imagesName, List<Integer> portList,HashMap<String,String> envs,V1ResourceRequirements resource){
    V1Container container = new V1Container();
    this.addContainer(container);
    container.setName(name);
    container.setImage(imagesName);
    container.setImagePullPolicy(ImagePullPolicy.Always);
    if (portList != null && portList.size()>0){
      for (Integer port : portList) {
        container.addPortsItem(new V1ContainerPort().containerPort(port));
      }
      addReadinessProbe(portList.get(0));
      addLivenessProbe(portList.get(0));
    }


    if (envs != null && envs.size()>0){
      for (Map.Entry<String, String> entry : envs.entrySet()) {
        container.addEnvItem(new V1EnvVar(entry.getKey(),entry.getValue()));
      }
    }

    container.addEnvItem(new V1EnvVar("TZ","Asia/Shanghai"));

    if (resource != null) container.resources(resource);
    return this;
  }

  public AppsV1beta1Deployment updateImageName(String imageName){
    return updateImageName(0,imageName);
  }

  public AppsV1beta1Deployment updateImageName(int index,String imageName){
    spec.getTemplate().getSpec().getContainers().get(index).setImage(imageName);
    return this;
  }

  public AppsV1beta1Deployment addReadinessProbe(int port){
    return addReadinessProbe(0,port);
  }

  public AppsV1beta1Deployment addReadinessProbe(int index,int port){
    V1TCPSocketAction tcpSocket = new V1TCPSocketAction().port(new IntOrString(port));
    V1Probe probe = new V1Probe().tcpSocket(tcpSocket).initialDelaySeconds(30).timeoutSeconds(30).failureThreshold(10).periodSeconds(30);
    spec.getTemplate().getSpec().getContainers().get(index).readinessProbe(probe);
    return this;
  }

  public AppsV1beta1Deployment deleteReadinessProbe(){
      return deleteReadinessProbe(0);
  }

  public AppsV1beta1Deployment deleteReadinessProbe(int index){
      spec.getTemplate().getSpec().getContainers().get(index).readinessProbe(null);
      return this;
  }

  public AppsV1beta1Deployment addLivenessProbe(int port){
    return addLivenessProbe(0,port,600);
  }

  public AppsV1beta1Deployment addLivenessProbe(int port,int delaySecond){
    return addLivenessProbe(0,port,delaySecond);
  }

  public AppsV1beta1Deployment addLivenessProbe(int index,int port,int delaySecond){
    V1TCPSocketAction tcpSocket = new V1TCPSocketAction().port(new IntOrString(port));
    V1Probe probe = new V1Probe().tcpSocket(tcpSocket).initialDelaySeconds(delaySecond).timeoutSeconds(30).failureThreshold(10).periodSeconds(30);
    spec.getTemplate().getSpec().getContainers().get(index).livenessProbe(probe);
    return this;
  }

  public AppsV1beta1Deployment deleteLivenessProbe(){
      return deleteLivenessProbe(0);
  }

  public AppsV1beta1Deployment deleteLivenessProbe(int index){
      spec.getTemplate().getSpec().getContainers().get(index).livenessProbe(null);
      return this;
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

  public AppsV1beta1Deployment kind(String kind) {
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

  public AppsV1beta1Deployment metadata(V1ObjectMeta metadata) {
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

  public AppsV1beta1Deployment spec(AppsV1beta1DeploymentSpec spec) {
    this.spec = spec;
    return this;
  }

   /**
   * Specification of the desired behavior of the Deployment.
   * @return spec
  **/
  @ApiModelProperty(value = "Specification of the desired behavior of the Deployment.")
  public AppsV1beta1DeploymentSpec getSpec() {
    return spec;
  }

  public void setSpec(AppsV1beta1DeploymentSpec spec) {
    this.spec = spec;
  }

  public AppsV1beta1Deployment status(AppsV1beta1DeploymentStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Most recently observed status of the Deployment.
   * @return status
  **/
  @ApiModelProperty(value = "Most recently observed status of the Deployment.")
  public AppsV1beta1DeploymentStatus getStatus() {
    return status;
  }

  public void setStatus(AppsV1beta1DeploymentStatus status) {
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
    AppsV1beta1Deployment appsV1beta1Deployment = (AppsV1beta1Deployment) o;
    return Objects.equals(this.apiVersion, appsV1beta1Deployment.apiVersion) &&
        Objects.equals(this.kind, appsV1beta1Deployment.kind) &&
        Objects.equals(this.metadata, appsV1beta1Deployment.metadata) &&
        Objects.equals(this.spec, appsV1beta1Deployment.spec) &&
        Objects.equals(this.status, appsV1beta1Deployment.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiVersion, kind, metadata, spec, status);
  }

  public String getNamespace(){
    return metadata.getNamespace();
  }

  public String getName(){
    return metadata.getName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppsV1beta1Deployment {\n");

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

