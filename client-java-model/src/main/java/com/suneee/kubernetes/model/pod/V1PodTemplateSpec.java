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


package com.suneee.kubernetes.model.pod;

import com.google.gson.annotations.SerializedName;
import com.suneee.kubernetes.model.V1ObjectMeta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * PodTemplateSpec describes the data a pod should have when created from a template
 */
@ApiModel(description = "PodTemplateSpec describes the data a pod should have when created from a template")

public class V1PodTemplateSpec {
  @SerializedName("metadata")
  private V1ObjectMeta metadata = null;

  @SerializedName("spec")
  private V1PodSpec spec = null;

  public V1PodTemplateSpec metadata(V1ObjectMeta metadata) {
    this.metadata = metadata;
    return this;
  }

  public V1PodTemplateSpec(){
    this.metadata = new V1ObjectMeta();
    this.spec = new V1PodSpec();
    spec.terminationGracePeriodSeconds(new Long(30));

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

  public V1PodTemplateSpec spec(V1PodSpec spec) {
    this.spec = spec;
    return this;
  }

   /**
   * Specification of the desired behavior of the pod. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#spec-and-status
   * @return spec
  **/
  @ApiModelProperty(value = "Specification of the desired behavior of the pod. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#spec-and-status")
  public V1PodSpec getSpec() {
    return spec;
  }

  public void setSpec(V1PodSpec spec) {
    this.spec = spec;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1PodTemplateSpec v1PodTemplateSpec = (V1PodTemplateSpec) o;
    return Objects.equals(this.metadata, v1PodTemplateSpec.metadata) &&
        Objects.equals(this.spec, v1PodTemplateSpec.spec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, spec);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1PodTemplateSpec {\n");

    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
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
