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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LoadBalancerStatus represents the status of a load-balancer.
 */
@ApiModel(description = "LoadBalancerStatus represents the status of a load-balancer.")

public class V1LoadBalancerStatus {
  @SerializedName("ingress")
  private List<V1LoadBalancerIngress> ingress = null;

  public V1LoadBalancerStatus ingress(List<V1LoadBalancerIngress> ingress) {
    this.ingress = ingress;
    return this;
  }

  public V1LoadBalancerStatus addIngressItem(V1LoadBalancerIngress ingressItem) {
    if (this.ingress == null) {
      this.ingress = new ArrayList<V1LoadBalancerIngress>();
    }
    this.ingress.add(ingressItem);
    return this;
  }

   /**
   * Ingress is a list containing ingress points for the load-balancer. Traffic intended for the service should be sent to these ingress points.
   * @return ingress
  **/
  @ApiModelProperty(value = "Ingress is a list containing ingress points for the load-balancer. Traffic intended for the service should be sent to these ingress points.")
  public List<V1LoadBalancerIngress> getIngress() {
    return ingress;
  }

  public void setIngress(List<V1LoadBalancerIngress> ingress) {
    this.ingress = ingress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1LoadBalancerStatus v1LoadBalancerStatus = (V1LoadBalancerStatus) o;
    return Objects.equals(this.ingress, v1LoadBalancerStatus.ingress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ingress);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1LoadBalancerStatus {\n");

    sb.append("    ingress: ").append(toIndentedString(ingress)).append("\n");
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

