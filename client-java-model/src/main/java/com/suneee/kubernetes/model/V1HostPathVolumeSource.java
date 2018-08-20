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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a host path mapped into a pod. Host path volumes do not support ownership management or SELinux relabeling.
 */
@ApiModel(description = "Represents a host path mapped into a pod. Host path volumes do not support ownership management or SELinux relabeling.")

public class V1HostPathVolumeSource {
  @SerializedName("path")
  private String path = null;

  @SerializedName("type")
  private String type = null;

  public V1HostPathVolumeSource path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Path of the directory on the host. If the path is a symlink, it will follow the link to the real path. More info: https://kubernetes.io/docs/concepts/storage/volumes#hostpath
   * @return path
  **/
  @ApiModelProperty(required = true, value = "Path of the directory on the host. If the path is a symlink, it will follow the link to the real path. More info: https://kubernetes.io/docs/concepts/storage/volumes#hostpath")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public V1HostPathVolumeSource type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type for HostPath Volume Defaults to \&quot;\&quot; More info: https://kubernetes.io/docs/concepts/storage/volumes#hostpath
   * @return type
  **/
  @ApiModelProperty(value = "Type for HostPath Volume Defaults to \"\" More info: https://kubernetes.io/docs/concepts/storage/volumes#hostpath")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HostPathVolumeSource v1HostPathVolumeSource = (V1HostPathVolumeSource) o;
    return Objects.equals(this.path, v1HostPathVolumeSource.path) &&
        Objects.equals(this.type, v1HostPathVolumeSource.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HostPathVolumeSource {\n");

    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

