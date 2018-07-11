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


package com.suneee.kubernetes.model.node;

import com.google.gson.annotations.SerializedName;
import com.suneee.kubernetes.model.V1PreferredSchedulingTerm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Node affinity is a group of node affinity scheduling rules.
 */
@ApiModel(description = "Node affinity is a group of node affinity scheduling rules.")

public class V1NodeAffinity {
  @SerializedName("preferredDuringSchedulingIgnoredDuringExecution")
  private List<V1PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution = null;

  @SerializedName("requiredDuringSchedulingIgnoredDuringExecution")
  private V1NodeSelector requiredDuringSchedulingIgnoredDuringExecution = null;

  public V1NodeAffinity preferredDuringSchedulingIgnoredDuringExecution(List<V1PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution) {
    this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
    return this;
  }

  public V1NodeAffinity addPreferredDuringSchedulingIgnoredDuringExecutionItem(V1PreferredSchedulingTerm preferredDuringSchedulingIgnoredDuringExecutionItem) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList<V1PreferredSchedulingTerm>();
    }
    this.preferredDuringSchedulingIgnoredDuringExecution.add(preferredDuringSchedulingIgnoredDuringExecutionItem);
    return this;
  }

   /**
   * The scheduler will prefer to schedule pods to nodes that satisfy the affinity expressions specified by this field, but it may choose a node that violates one or more of the expressions. The node that is most preferred is the one with the greatest sum of weights, i.e. for each node that meets all of the scheduling requirements (resource request, requiredDuringScheduling affinity expressions, etc.), compute a sum by iterating through the elements of this field and adding \&quot;weight\&quot; to the sum if the node matches the corresponding matchExpressions; the node(s) with the highest sum are the most preferred.
   * @return preferredDuringSchedulingIgnoredDuringExecution
  **/
  @ApiModelProperty(value = "The scheduler will prefer to schedule pods to nodes that satisfy the affinity expressions specified by this field, but it may choose a node that violates one or more of the expressions. The node that is most preferred is the one with the greatest sum of weights, i.e. for each node that meets all of the scheduling requirements (resource request, requiredDuringScheduling affinity expressions, etc.), compute a sum by iterating through the elements of this field and adding \"weight\" to the sum if the node matches the corresponding matchExpressions; the node(s) with the highest sum are the most preferred.")
  public List<V1PreferredSchedulingTerm> getPreferredDuringSchedulingIgnoredDuringExecution() {
    return preferredDuringSchedulingIgnoredDuringExecution;
  }

  public void setPreferredDuringSchedulingIgnoredDuringExecution(List<V1PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution) {
    this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
  }

  public V1NodeAffinity requiredDuringSchedulingIgnoredDuringExecution(V1NodeSelector requiredDuringSchedulingIgnoredDuringExecution) {
    this.requiredDuringSchedulingIgnoredDuringExecution = requiredDuringSchedulingIgnoredDuringExecution;
    return this;
  }

   /**
   * If the affinity requirements specified by this field are not met at scheduling time, the pod will not be scheduled onto the node. If the affinity requirements specified by this field cease to be met at some point during pod execution (e.g. due to an update), the system may or may not try to eventually evict the pod from its node.
   * @return requiredDuringSchedulingIgnoredDuringExecution
  **/
  @ApiModelProperty(value = "If the affinity requirements specified by this field are not met at scheduling time, the pod will not be scheduled onto the node. If the affinity requirements specified by this field cease to be met at some point during pod execution (e.g. due to an update), the system may or may not try to eventually evict the pod from its node.")
  public V1NodeSelector getRequiredDuringSchedulingIgnoredDuringExecution() {
    return requiredDuringSchedulingIgnoredDuringExecution;
  }

  public void setRequiredDuringSchedulingIgnoredDuringExecution(V1NodeSelector requiredDuringSchedulingIgnoredDuringExecution) {
    this.requiredDuringSchedulingIgnoredDuringExecution = requiredDuringSchedulingIgnoredDuringExecution;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1NodeAffinity v1NodeAffinity = (V1NodeAffinity) o;
    return Objects.equals(this.preferredDuringSchedulingIgnoredDuringExecution, v1NodeAffinity.preferredDuringSchedulingIgnoredDuringExecution) &&
        Objects.equals(this.requiredDuringSchedulingIgnoredDuringExecution, v1NodeAffinity.requiredDuringSchedulingIgnoredDuringExecution);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preferredDuringSchedulingIgnoredDuringExecution, requiredDuringSchedulingIgnoredDuringExecution);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1NodeAffinity {\n");

    sb.append("    preferredDuringSchedulingIgnoredDuringExecution: ").append(toIndentedString(preferredDuringSchedulingIgnoredDuringExecution)).append("\n");
    sb.append("    requiredDuringSchedulingIgnoredDuringExecution: ").append(toIndentedString(requiredDuringSchedulingIgnoredDuringExecution)).append("\n");
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

