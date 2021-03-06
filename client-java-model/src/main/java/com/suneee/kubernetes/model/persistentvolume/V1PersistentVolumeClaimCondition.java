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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Objects;

/**
 * PersistentVolumeClaimCondition contails details about state of pvc
 */
@ApiModel(description = "PersistentVolumeClaimCondition contails details about state of pvc")

public class V1PersistentVolumeClaimCondition {
  @SerializedName("lastProbeTime")
  private DateTime lastProbeTime = null;

  @SerializedName("lastTransitionTime")
  private DateTime lastTransitionTime = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("reason")
  private String reason = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("type")
  private String type = null;

  public V1PersistentVolumeClaimCondition lastProbeTime(DateTime lastProbeTime) {
    this.lastProbeTime = lastProbeTime;
    return this;
  }

   /**
   * Last time we probed the condition.
   * @return lastProbeTime
  **/
  @ApiModelProperty(value = "Last time we probed the condition.")
  public DateTime getLastProbeTime() {
    return lastProbeTime;
  }

  public void setLastProbeTime(DateTime lastProbeTime) {
    this.lastProbeTime = lastProbeTime;
  }

  public V1PersistentVolumeClaimCondition lastTransitionTime(DateTime lastTransitionTime) {
    this.lastTransitionTime = lastTransitionTime;
    return this;
  }

   /**
   * Last time the condition transitioned from one status to another.
   * @return lastTransitionTime
  **/
  @ApiModelProperty(value = "Last time the condition transitioned from one status to another.")
  public DateTime getLastTransitionTime() {
    return lastTransitionTime;
  }

  public void setLastTransitionTime(DateTime lastTransitionTime) {
    this.lastTransitionTime = lastTransitionTime;
  }

  public V1PersistentVolumeClaimCondition message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Human-readable message indicating details about last transition.
   * @return message
  **/
  @ApiModelProperty(value = "Human-readable message indicating details about last transition.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public V1PersistentVolumeClaimCondition reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Unique, this should be a short, machine understandable string that gives the reason for condition&#39;s last transition. If it reports \&quot;ResizeStarted\&quot; that means the underlying persistent volume is being resized.
   * @return reason
  **/
  @ApiModelProperty(value = "Unique, this should be a short, machine understandable string that gives the reason for condition's last transition. If it reports \"ResizeStarted\" that means the underlying persistent volume is being resized.")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public V1PersistentVolumeClaimCondition status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public V1PersistentVolumeClaimCondition type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
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
    V1PersistentVolumeClaimCondition v1PersistentVolumeClaimCondition = (V1PersistentVolumeClaimCondition) o;
    return Objects.equals(this.lastProbeTime, v1PersistentVolumeClaimCondition.lastProbeTime) &&
        Objects.equals(this.lastTransitionTime, v1PersistentVolumeClaimCondition.lastTransitionTime) &&
        Objects.equals(this.message, v1PersistentVolumeClaimCondition.message) &&
        Objects.equals(this.reason, v1PersistentVolumeClaimCondition.reason) &&
        Objects.equals(this.status, v1PersistentVolumeClaimCondition.status) &&
        Objects.equals(this.type, v1PersistentVolumeClaimCondition.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastProbeTime, lastTransitionTime, message, reason, status, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1PersistentVolumeClaimCondition {\n");

    sb.append("    lastProbeTime: ").append(toIndentedString(lastProbeTime)).append("\n");
    sb.append("    lastTransitionTime: ").append(toIndentedString(lastTransitionTime)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

