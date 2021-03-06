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
import com.insightly.model.ActivitySetAssignment;


import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;

/**
 * PipelineStageChange
 */
@JacksonXmlRootElement(localName = "PipelineStageChange")
@XmlRootElement(name = "PipelineStageChange")
@XmlAccessorType(XmlAccessType.FIELD)
public class PipelineStageChange implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("STAGE_ID")
  @JacksonXmlProperty(localName = "STAGE_ID")
  @XmlElement(name = "STAGE_ID")
  private Long STAGE_ID = null;

  @JsonProperty("ACTIVITYSET_ASSIGNMENT")
  @JacksonXmlProperty(localName = "ACTIVITYSET_ASSIGNMENT")
  @XmlElement(name = "ACTIVITYSET_ASSIGNMENT")
  private ActivitySetAssignment ACTIVITYSET_ASSIGNMENT = null;

  public PipelineStageChange STAGE_ID(Long STAGE_ID) {
    this.STAGE_ID = STAGE_ID;
    return this;
  }

   /**
   * Get STAGE_ID
   * @return STAGE_ID
  **/
  
  public Long getSTAGEID() {
    return STAGE_ID;
  }

  public void setSTAGEID(Long STAGE_ID) {
    this.STAGE_ID = STAGE_ID;
  }

  public PipelineStageChange ACTIVITYSET_ASSIGNMENT(ActivitySetAssignment ACTIVITYSET_ASSIGNMENT) {
    this.ACTIVITYSET_ASSIGNMENT = ACTIVITYSET_ASSIGNMENT;
    return this;
  }

   /**
   * Get ACTIVITYSET_ASSIGNMENT
   * @return ACTIVITYSET_ASSIGNMENT
  **/
  
  public ActivitySetAssignment getACTIVITYSETASSIGNMENT() {
    return ACTIVITYSET_ASSIGNMENT;
  }

  public void setACTIVITYSETASSIGNMENT(ActivitySetAssignment ACTIVITYSET_ASSIGNMENT) {
    this.ACTIVITYSET_ASSIGNMENT = ACTIVITYSET_ASSIGNMENT;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PipelineStageChange apIPipelineStageChange = (PipelineStageChange) o;
    return Objects.equals(this.STAGE_ID, apIPipelineStageChange.STAGE_ID) &&
        Objects.equals(this.ACTIVITYSET_ASSIGNMENT, apIPipelineStageChange.ACTIVITYSET_ASSIGNMENT);
  }

  @Override
  public int hashCode() {
    return Objects.hash(STAGE_ID, ACTIVITYSET_ASSIGNMENT);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineStageChange {\n");
    
    sb.append("    STAGE_ID: ").append(toIndentedString(STAGE_ID)).append("\n");
    sb.append("    ACTIVITYSET_ASSIGNMENT: ").append(toIndentedString(ACTIVITYSET_ASSIGNMENT)).append("\n");
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

