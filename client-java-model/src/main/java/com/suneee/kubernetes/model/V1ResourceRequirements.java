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
import com.suneee.kubernetes.custom.Quantity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ResourceRequirements describes the compute resource requirements.
 */
@ApiModel(description = "ResourceRequirements describes the compute resource requirements.")

public class V1ResourceRequirements {
  @SerializedName("limits")
  private Map<String, Quantity> limits = null;

  @SerializedName("requests")
  private Map<String, Quantity> requests = null;

  public V1ResourceRequirements limits(Map<String, Quantity> limits) {
    this.limits = limits;
    return this;
  }

  public V1ResourceRequirements putLimitsItem(String key, Quantity limitsItem) {
    if (this.limits == null) {
      this.limits = new HashMap<String, Quantity>();
    }
    this.limits.put(key, limitsItem);
    return this;
  }

   /**
   * Limits describes the maximum amount of compute resources allowed. More info: https://kubernetes.io/docs/concepts/configuration/manage-compute-resources-container/
   * @return limits
  **/
  @ApiModelProperty(value = "Limits describes the maximum amount of compute resources allowed. More info: https://kubernetes.io/docs/concepts/configuration/manage-compute-resources-container/")
  public Map<String, Quantity> getLimits() {
    return limits;
  }

  public void setLimits(Map<String, Quantity> limits) {
    this.limits = limits;
  }

  public V1ResourceRequirements requests(Map<String, Quantity> requests) {
    this.requests = requests;
    return this;
  }

  public V1ResourceRequirements putRequestsItem(String key, Quantity requestsItem) {
    if (this.requests == null) {
      this.requests = new HashMap<String, Quantity>();
    }
    this.requests.put(key, requestsItem);
    return this;
  }

   /**
   * Requests describes the minimum amount of compute resources required. If Requests is omitted for a container, it defaults to Limits if that is explicitly specified, otherwise to an implementation-defined value. More info: https://kubernetes.io/docs/concepts/configuration/manage-compute-resources-container/
   * @return requests
  **/
  @ApiModelProperty(value = "Requests describes the minimum amount of compute resources required. If Requests is omitted for a container, it defaults to Limits if that is explicitly specified, otherwise to an implementation-defined value. More info: https://kubernetes.io/docs/concepts/configuration/manage-compute-resources-container/")
  public Map<String, Quantity> getRequests() {
    return requests;
  }

  public void setRequests(Map<String, Quantity> requests) {
    this.requests = requests;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ResourceRequirements v1ResourceRequirements = (V1ResourceRequirements) o;
    return Objects.equals(this.limits, v1ResourceRequirements.limits) &&
        Objects.equals(this.requests, v1ResourceRequirements.requests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(limits, requests);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ResourceRequirements {\n");

    sb.append("    limits: ").append(toIndentedString(limits)).append("\n");
    sb.append("    requests: ").append(toIndentedString(requests)).append("\n");
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

