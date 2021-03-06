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
import com.suneee.kubernetes.model.volume.V1VolumeProjection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a projected volume source
 */
@ApiModel(description = "Represents a projected volume source")

public class V1ProjectedVolumeSource {
  @SerializedName("defaultMode")
  private Integer defaultMode = null;

  @SerializedName("sources")
  private List<V1VolumeProjection> sources = new ArrayList<V1VolumeProjection>();

  public V1ProjectedVolumeSource defaultMode(Integer defaultMode) {
    this.defaultMode = defaultMode;
    return this;
  }

   /**
   * Mode bits to use on created files by default. Must be a value between 0 and 0777. Directories within the path are not affected by this setting. This might be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits set.
   * @return defaultMode
  **/
  @ApiModelProperty(value = "Mode bits to use on created files by default. Must be a value between 0 and 0777. Directories within the path are not affected by this setting. This might be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits set.")
  public Integer getDefaultMode() {
    return defaultMode;
  }

  public void setDefaultMode(Integer defaultMode) {
    this.defaultMode = defaultMode;
  }

  public V1ProjectedVolumeSource sources(List<V1VolumeProjection> sources) {
    this.sources = sources;
    return this;
  }

  public V1ProjectedVolumeSource addSourcesItem(V1VolumeProjection sourcesItem) {
    this.sources.add(sourcesItem);
    return this;
  }

   /**
   * list of volume projections
   * @return sources
  **/
  @ApiModelProperty(required = true, value = "list of volume projections")
  public List<V1VolumeProjection> getSources() {
    return sources;
  }

  public void setSources(List<V1VolumeProjection> sources) {
    this.sources = sources;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ProjectedVolumeSource v1ProjectedVolumeSource = (V1ProjectedVolumeSource) o;
    return Objects.equals(this.defaultMode, v1ProjectedVolumeSource.defaultMode) &&
        Objects.equals(this.sources, v1ProjectedVolumeSource.sources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultMode, sources);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ProjectedVolumeSource {\n");

    sb.append("    defaultMode: ").append(toIndentedString(defaultMode)).append("\n");
    sb.append("    sources: ").append(toIndentedString(sources)).append("\n");
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

