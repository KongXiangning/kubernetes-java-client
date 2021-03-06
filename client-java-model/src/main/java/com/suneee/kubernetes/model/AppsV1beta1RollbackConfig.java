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
 * DEPRECATED.
 */
@ApiModel(description = "DEPRECATED.")

public class AppsV1beta1RollbackConfig {
  @SerializedName("revision")
  private Long revision = null;

  public AppsV1beta1RollbackConfig revision(Long revision) {
    this.revision = revision;
    return this;
  }

   /**
   * The revision to rollback to. If set to 0, rollback to the last revision.
   * @return revision
  **/
  @ApiModelProperty(value = "The revision to rollback to. If set to 0, rollback to the last revision.")
  public Long getRevision() {
    return revision;
  }

  public void setRevision(Long revision) {
    this.revision = revision;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppsV1beta1RollbackConfig appsV1beta1RollbackConfig = (AppsV1beta1RollbackConfig) o;
    return Objects.equals(this.revision, appsV1beta1RollbackConfig.revision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(revision);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppsV1beta1RollbackConfig {\n");

    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
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

