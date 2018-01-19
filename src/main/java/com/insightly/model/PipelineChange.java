/*
 * Insightly API v2.2
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v2.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.insightly.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.insightly.model.PipelineStageChange;


import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;

/**
 * PipelineChange
 */
@JacksonXmlRootElement(localName = "PipelineChange")
@XmlRootElement(name = "PipelineChange")
@XmlAccessorType(XmlAccessType.FIELD)
public class PipelineChange implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("PIPELINE_ID")
  @JacksonXmlProperty(localName = "PIPELINE_ID")
  @XmlElement(name = "PIPELINE_ID")
  private Long PIPELINE_ID = null;

  @JsonProperty("PIPELINE_STAGE_CHANGE")
  @JacksonXmlProperty(localName = "PIPELINE_STAGE_CHANGE")
  @XmlElement(name = "PIPELINE_STAGE_CHANGE")
  private PipelineStageChange PIPELINE_STAGE_CHANGE = null;

  public PipelineChange PIPELINE_ID(Long PIPELINE_ID) {
    this.PIPELINE_ID = PIPELINE_ID;
    return this;
  }

   /**
   * Get PIPELINE_ID
   * @return PIPELINE_ID
  **/
  
  public Long getPIPELINEID() {
    return PIPELINE_ID;
  }

  public void setPIPELINEID(Long PIPELINE_ID) {
    this.PIPELINE_ID = PIPELINE_ID;
  }

  public PipelineChange PIPELINE_STAGE_CHANGE(PipelineStageChange PIPELINE_STAGE_CHANGE) {
    this.PIPELINE_STAGE_CHANGE = PIPELINE_STAGE_CHANGE;
    return this;
  }

   /**
   * Get PIPELINE_STAGE_CHANGE
   * @return PIPELINE_STAGE_CHANGE
  **/
  
  public PipelineStageChange getPIPELINESTAGECHANGE() {
    return PIPELINE_STAGE_CHANGE;
  }

  public void setPIPELINESTAGECHANGE(PipelineStageChange PIPELINE_STAGE_CHANGE) {
    this.PIPELINE_STAGE_CHANGE = PIPELINE_STAGE_CHANGE;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PipelineChange apIPipelineChange = (PipelineChange) o;
    return Objects.equals(this.PIPELINE_ID, apIPipelineChange.PIPELINE_ID) &&
        Objects.equals(this.PIPELINE_STAGE_CHANGE, apIPipelineChange.PIPELINE_STAGE_CHANGE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(PIPELINE_ID, PIPELINE_STAGE_CHANGE);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineChange {\n");
    
    sb.append("    PIPELINE_ID: ").append(toIndentedString(PIPELINE_ID)).append("\n");
    sb.append("    PIPELINE_STAGE_CHANGE: ").append(toIndentedString(PIPELINE_STAGE_CHANGE)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

