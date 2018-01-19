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


import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;

/**
 * PipelineStage
 */
@JacksonXmlRootElement(localName = "PipelineStage")
@XmlRootElement(name = "PipelineStage")
@XmlAccessorType(XmlAccessType.FIELD)
public class PipelineStage implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("STAGE_ID")
  @JacksonXmlProperty(localName = "STAGE_ID")
  @XmlElement(name = "STAGE_ID")
  private Long STAGE_ID = null;

  @JsonProperty("PIPELINE_ID")
  @JacksonXmlProperty(localName = "PIPELINE_ID")
  @XmlElement(name = "PIPELINE_ID")
  private Long PIPELINE_ID = null;

  @JsonProperty("STAGE_NAME")
  @JacksonXmlProperty(localName = "STAGE_NAME")
  @XmlElement(name = "STAGE_NAME")
  private String STAGE_NAME = null;

  @JsonProperty("STAGE_ORDER")
  @JacksonXmlProperty(localName = "STAGE_ORDER")
  @XmlElement(name = "STAGE_ORDER")
  private Integer STAGE_ORDER = null;

  @JsonProperty("ACTIVITYSET_ID")
  @JacksonXmlProperty(localName = "ACTIVITYSET_ID")
  @XmlElement(name = "ACTIVITYSET_ID")
  private Long ACTIVITYSET_ID = null;

  @JsonProperty("OWNER_USER_ID")
  @JacksonXmlProperty(localName = "OWNER_USER_ID")
  @XmlElement(name = "OWNER_USER_ID")
  private Integer OWNER_USER_ID = null;

  public PipelineStage STAGE_ID(Long STAGE_ID) {
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

  public PipelineStage PIPELINE_ID(Long PIPELINE_ID) {
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

  public PipelineStage STAGE_NAME(String STAGE_NAME) {
    this.STAGE_NAME = STAGE_NAME;
    return this;
  }

   /**
   * Get STAGE_NAME
   * @return STAGE_NAME
  **/
  
  public String getSTAGENAME() {
    return STAGE_NAME;
  }

  public void setSTAGENAME(String STAGE_NAME) {
    this.STAGE_NAME = STAGE_NAME;
  }

  public PipelineStage STAGE_ORDER(Integer STAGE_ORDER) {
    this.STAGE_ORDER = STAGE_ORDER;
    return this;
  }

   /**
   * Get STAGE_ORDER
   * @return STAGE_ORDER
  **/
  
  public Integer getSTAGEORDER() {
    return STAGE_ORDER;
  }

  public void setSTAGEORDER(Integer STAGE_ORDER) {
    this.STAGE_ORDER = STAGE_ORDER;
  }

  public PipelineStage ACTIVITYSET_ID(Long ACTIVITYSET_ID) {
    this.ACTIVITYSET_ID = ACTIVITYSET_ID;
    return this;
  }

   /**
   * Get ACTIVITYSET_ID
   * @return ACTIVITYSET_ID
  **/
  
  public Long getACTIVITYSETID() {
    return ACTIVITYSET_ID;
  }

  public void setACTIVITYSETID(Long ACTIVITYSET_ID) {
    this.ACTIVITYSET_ID = ACTIVITYSET_ID;
  }

  public PipelineStage OWNER_USER_ID(Integer OWNER_USER_ID) {
    this.OWNER_USER_ID = OWNER_USER_ID;
    return this;
  }

   /**
   * Get OWNER_USER_ID
   * @return OWNER_USER_ID
  **/
  
  public Integer getOWNERUSERID() {
    return OWNER_USER_ID;
  }

  public void setOWNERUSERID(Integer OWNER_USER_ID) {
    this.OWNER_USER_ID = OWNER_USER_ID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PipelineStage pipelineStage = (PipelineStage) o;
    return Objects.equals(this.STAGE_ID, pipelineStage.STAGE_ID) &&
        Objects.equals(this.PIPELINE_ID, pipelineStage.PIPELINE_ID) &&
        Objects.equals(this.STAGE_NAME, pipelineStage.STAGE_NAME) &&
        Objects.equals(this.STAGE_ORDER, pipelineStage.STAGE_ORDER) &&
        Objects.equals(this.ACTIVITYSET_ID, pipelineStage.ACTIVITYSET_ID) &&
        Objects.equals(this.OWNER_USER_ID, pipelineStage.OWNER_USER_ID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(STAGE_ID, PIPELINE_ID, STAGE_NAME, STAGE_ORDER, ACTIVITYSET_ID, OWNER_USER_ID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineStage {\n");
    
    sb.append("    STAGE_ID: ").append(toIndentedString(STAGE_ID)).append("\n");
    sb.append("    PIPELINE_ID: ").append(toIndentedString(PIPELINE_ID)).append("\n");
    sb.append("    STAGE_NAME: ").append(toIndentedString(STAGE_NAME)).append("\n");
    sb.append("    STAGE_ORDER: ").append(toIndentedString(STAGE_ORDER)).append("\n");
    sb.append("    ACTIVITYSET_ID: ").append(toIndentedString(ACTIVITYSET_ID)).append("\n");
    sb.append("    OWNER_USER_ID: ").append(toIndentedString(OWNER_USER_ID)).append("\n");
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
