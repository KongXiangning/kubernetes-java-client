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


package com.suneee.kubernetes.model.persistentvolume;

import com.google.gson.annotations.SerializedName;
import com.suneee.kubernetes.custom.Quantity;
import com.suneee.kubernetes.model.V1ObjectMeta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * PersistentVolumeClaim is a user&#39;s request for and claim to a persistent volume
 */
@ApiModel(description = "PersistentVolumeClaim is a user's request for and claim to a persistent volume")

public class V1PersistentVolumeClaim{
  @SerializedName("apiVersion")
  private String apiVersion = null;

  @SerializedName("kind")
  private String kind = null;

  @SerializedName("metadata")
  private V1ObjectMeta metadata = null;

  @SerializedName("spec")
  private V1PersistentVolumeClaimSpec spec = null;

  @SerializedName("status")
  private V1PersistentVolumeClaimStatus status = null;

  public V1PersistentVolumeClaim(){
    this.apiVersion = "v1";
    this.kind = "PersistentVolumeClaim";
    this.metadata = new V1ObjectMeta();
    this.spec = new V1PersistentVolumeClaimSpec();
  }

  public V1PersistentVolumeClaim(String namespace,String name){
    this();
    setNamespace(namespace);
    setName(name);
  }

  public V1PersistentVolumeClaim setNamespace(String namespace){
    metadata.setNamespace(namespace);
    return this;
  }

  public String getNamespace(){
    return metadata.getNamespace();
  }

  public V1PersistentVolumeClaim setName(String name){
    metadata.setName(name);
    return this;
  }

  public String getName(){
    return metadata.getName();
  }

  public V1PersistentVolumeClaim putLabel(String key, String value){
    metadata.putLabelsItem(key,value);
    return this;
  }

  public V1PersistentVolumeClaim apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  public V1PersistentVolumeClaim setAccessModes(String accessModes){
    spec.addAccessModesItem(accessModes);
    return this;
  }

  public V1PersistentVolumeClaim setStorage(String capacity){
    spec.getResources().putRequestsItem("storage",new Quantity(capacity));
    return this;
  }

  public V1PersistentVolumeClaim setMatchLabels(String pvName){
    spec.getSelector().putMatchLabelsItem("pv",pvName);
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

  public V1PersistentVolumeClaim kind(String kind) {
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

  public V1PersistentVolumeClaim metadata(V1ObjectMeta metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Standard object&#39;s metadata. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "Standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata")
  public V1ObjectMeta getMetadata() {
    return metadata;
  }

  public void setMetadata(V1ObjectMeta metadata) {
    this.metadata = metadata;
  }

  public V1PersistentVolumeClaim spec(V1PersistentVolumeClaimSpec spec) {
    this.spec = spec;
    return this;
  }

   /**
   * Spec defines the desired characteristics of a volume requested by a pod author. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims
   * @return spec
  **/
  @ApiModelProperty(value = "Spec defines the desired characteristics of a volume requested by a pod author. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims")
  public V1PersistentVolumeClaimSpec getSpec() {
    return spec;
  }

  public void setSpec(V1PersistentVolumeClaimSpec spec) {
    this.spec = spec;
  }

  public V1PersistentVolumeClaim status(V1PersistentVolumeClaimStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Status represents the current information/status of a persistent volume claim. Read-only. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims
   * @return status
  **/
  @ApiModelProperty(value = "Status represents the current information/status of a persistent volume claim. Read-only. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims")
  public V1PersistentVolumeClaimStatus getStatus() {
    return status;
  }

  public void setStatus(V1PersistentVolumeClaimStatus status) {
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
    V1PersistentVolumeClaim v1PersistentVolumeClaim = (V1PersistentVolumeClaim) o;
    return Objects.equals(this.apiVersion, v1PersistentVolumeClaim.apiVersion) &&
        Objects.equals(this.kind, v1PersistentVolumeClaim.kind) &&
        Objects.equals(this.metadata, v1PersistentVolumeClaim.metadata) &&
        Objects.equals(this.spec, v1PersistentVolumeClaim.spec) &&
        Objects.equals(this.status, v1PersistentVolumeClaim.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiVersion, kind, metadata, spec, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1PersistentVolumeClaim {\n");

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

