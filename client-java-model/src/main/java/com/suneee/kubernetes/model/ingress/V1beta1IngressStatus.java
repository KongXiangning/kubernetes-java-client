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


package com.suneee.kubernetes.model.ingress;

import com.google.gson.annotations.SerializedName;
import com.suneee.kubernetes.model.V1LoadBalancerStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * IngressStatus describe the current state of the Ingress.
 */
@ApiModel(description = "IngressStatus describe the current state of the Ingress.")

public class V1beta1IngressStatus {
  @SerializedName("loadBalancer")
  private V1LoadBalancerStatus loadBalancer = null;

  public V1beta1IngressStatus loadBalancer(V1LoadBalancerStatus loadBalancer) {
    this.loadBalancer = loadBalancer;
    return this;
  }

   /**
   * LoadBalancer contains the current status of the load-balancer.
   * @return loadBalancer
  **/
  @ApiModelProperty(value = "LoadBalancer contains the current status of the load-balancer.")
  public V1LoadBalancerStatus getLoadBalancer() {
    return loadBalancer;
  }

  public void setLoadBalancer(V1LoadBalancerStatus loadBalancer) {
    this.loadBalancer = loadBalancer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1beta1IngressStatus v1beta1IngressStatus = (V1beta1IngressStatus) o;
    return Objects.equals(this.loadBalancer, v1beta1IngressStatus.loadBalancer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loadBalancer);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1beta1IngressStatus {\n");

    sb.append("    loadBalancer: ").append(toIndentedString(loadBalancer)).append("\n");
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

