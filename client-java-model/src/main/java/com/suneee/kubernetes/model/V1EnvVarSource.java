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


package com.suneee.kubernetes.model;

import com.google.gson.annotations.SerializedName;
import com.suneee.kubernetes.model.configmap.V1ConfigMapKeySelector;
import com.suneee.kubernetes.model.secret.V1SecretKeySelector;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * EnvVarSource represents a source for the value of an EnvVar.
 */
@ApiModel(description = "EnvVarSource represents a source for the value of an EnvVar.")

public class V1EnvVarSource {
  @SerializedName("configMapKeyRef")
  private V1ConfigMapKeySelector configMapKeyRef = null;

  @SerializedName("fieldRef")
  private V1ObjectFieldSelector fieldRef = null;

  @SerializedName("resourceFieldRef")
  private V1ResourceFieldSelector resourceFieldRef = null;

  @SerializedName("secretKeyRef")
  private V1SecretKeySelector secretKeyRef = null;

  public V1EnvVarSource configMapKeyRef(V1ConfigMapKeySelector configMapKeyRef) {
    this.configMapKeyRef = configMapKeyRef;
    return this;
  }

   /**
   * Selects a key of a ConfigMap.
   * @return configMapKeyRef
  **/
  @ApiModelProperty(value = "Selects a key of a ConfigMap.")
  public V1ConfigMapKeySelector getConfigMapKeyRef() {
    return configMapKeyRef;
  }

  public void setConfigMapKeyRef(V1ConfigMapKeySelector configMapKeyRef) {
    this.configMapKeyRef = configMapKeyRef;
  }

  public V1EnvVarSource setConfigMapKeyRef(String key,String name,boolean optional){
    this.configMapKeyRef = new V1ConfigMapKeySelector(key,name,optional);
    return this;
  }

  public V1EnvVarSource fieldRef(V1ObjectFieldSelector fieldRef) {
    this.fieldRef = fieldRef;
    return this;
  }

   /**
   * Selects a field of the pod: supports metadata.name, metadata.namespace, metadata.labels, metadata.annotations, spec.nodeName, spec.serviceAccountName, status.hostIP, status.podIP.
   * @return fieldRef
  **/
  @ApiModelProperty(value = "Selects a field of the pod: supports metadata.name, metadata.namespace, metadata.labels, metadata.annotations, spec.nodeName, spec.serviceAccountName, status.hostIP, status.podIP.")
  public V1ObjectFieldSelector getFieldRef() {
    return fieldRef;
  }

  public void setFieldRef(V1ObjectFieldSelector fieldRef) {
    this.fieldRef = fieldRef;
  }

  public V1EnvVarSource setFieldRef(String apiVersion,String fieldPath){
    this.fieldRef = new V1ObjectFieldSelector(apiVersion,fieldPath);
    return this;
  }

  public V1EnvVarSource resourceFieldRef(V1ResourceFieldSelector resourceFieldRef) {
    this.resourceFieldRef = resourceFieldRef;
    return this;
  }

   /**
   * Selects a resource of the container: only resources limits and requests (limits.cpu, limits.memory, limits.ephemeral-storage, requests.cpu, requests.memory and requests.ephemeral-storage) are currently supported.
   * @return resourceFieldRef
  **/
  @ApiModelProperty(value = "Selects a resource of the container: only resources limits and requests (limits.cpu, limits.memory, limits.ephemeral-storage, requests.cpu, requests.memory and requests.ephemeral-storage) are currently supported.")
  public V1ResourceFieldSelector getResourceFieldRef() {
    return resourceFieldRef;
  }

  public void setResourceFieldRef(V1ResourceFieldSelector resourceFieldRef) {
    this.resourceFieldRef = resourceFieldRef;
  }

  public V1EnvVarSource setResourceFieldRef(String containerName,String divisor,String resource){
    this.resourceFieldRef = new V1ResourceFieldSelector(containerName,divisor,resource);
    return this;
  }

  public V1EnvVarSource secretKeyRef(V1SecretKeySelector secretKeyRef) {
    this.secretKeyRef = secretKeyRef;
    return this;
  }

   /**
   * Selects a key of a secret in the pod&#39;s namespace
   * @return secretKeyRef
  **/
  @ApiModelProperty(value = "Selects a key of a secret in the pod's namespace")
  public V1SecretKeySelector getSecretKeyRef() {
    return secretKeyRef;
  }

  public void setSecretKeyRef(V1SecretKeySelector secretKeyRef) {
    this.secretKeyRef = secretKeyRef;
  }

  public V1EnvVarSource setSecretKeyRef(String key, String name, Boolean optional){
    this.secretKeyRef = new V1SecretKeySelector(key,name,optional);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1EnvVarSource v1EnvVarSource = (V1EnvVarSource) o;
    return Objects.equals(this.configMapKeyRef, v1EnvVarSource.configMapKeyRef) &&
        Objects.equals(this.fieldRef, v1EnvVarSource.fieldRef) &&
        Objects.equals(this.resourceFieldRef, v1EnvVarSource.resourceFieldRef) &&
        Objects.equals(this.secretKeyRef, v1EnvVarSource.secretKeyRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configMapKeyRef, fieldRef, resourceFieldRef, secretKeyRef);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1EnvVarSource {\n");

    sb.append("    configMapKeyRef: ").append(toIndentedString(configMapKeyRef)).append("\n");
    sb.append("    fieldRef: ").append(toIndentedString(fieldRef)).append("\n");
    sb.append("    resourceFieldRef: ").append(toIndentedString(resourceFieldRef)).append("\n");
    sb.append("    secretKeyRef: ").append(toIndentedString(secretKeyRef)).append("\n");
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

