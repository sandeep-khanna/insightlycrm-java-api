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
 * ActivityAssignment
 */
@JacksonXmlRootElement(localName = "ActivityAssignment")
@XmlRootElement(name = "ActivityAssignment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityAssignment implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("ACTIVITY_ID")
  @JacksonXmlProperty(localName = "ACTIVITY_ID")
  @XmlElement(name = "ACTIVITY_ID")
  private Long ACTIVITY_ID = null;

  @JsonProperty("RESPONSIBLE_USER_ID")
  @JacksonXmlProperty(localName = "RESPONSIBLE_USER_ID")
  @XmlElement(name = "RESPONSIBLE_USER_ID")
  private Integer RESPONSIBLE_USER_ID = null;

  @JsonProperty("ASSIGNED_TEAM_ID")
  @JacksonXmlProperty(localName = "ASSIGNED_TEAM_ID")
  @XmlElement(name = "ASSIGNED_TEAM_ID")
  private Long ASSIGNED_TEAM_ID = null;

  public ActivityAssignment ACTIVITY_ID(Long ACTIVITY_ID) {
    this.ACTIVITY_ID = ACTIVITY_ID;
    return this;
  }

   /**
   * Get ACTIVITY_ID
   * @return ACTIVITY_ID
  **/
  
  public Long getACTIVITYID() {
    return ACTIVITY_ID;
  }

  public void setACTIVITYID(Long ACTIVITY_ID) {
    this.ACTIVITY_ID = ACTIVITY_ID;
  }

  public ActivityAssignment RESPONSIBLE_USER_ID(Integer RESPONSIBLE_USER_ID) {
    this.RESPONSIBLE_USER_ID = RESPONSIBLE_USER_ID;
    return this;
  }

   /**
   * Get RESPONSIBLE_USER_ID
   * @return RESPONSIBLE_USER_ID
  **/
  
  public Integer getRESPONSIBLEUSERID() {
    return RESPONSIBLE_USER_ID;
  }

  public void setRESPONSIBLEUSERID(Integer RESPONSIBLE_USER_ID) {
    this.RESPONSIBLE_USER_ID = RESPONSIBLE_USER_ID;
  }

  public ActivityAssignment ASSIGNED_TEAM_ID(Long ASSIGNED_TEAM_ID) {
    this.ASSIGNED_TEAM_ID = ASSIGNED_TEAM_ID;
    return this;
  }

   /**
   * Get ASSIGNED_TEAM_ID
   * @return ASSIGNED_TEAM_ID
  **/
  
  public Long getASSIGNEDTEAMID() {
    return ASSIGNED_TEAM_ID;
  }

  public void setASSIGNEDTEAMID(Long ASSIGNED_TEAM_ID) {
    this.ASSIGNED_TEAM_ID = ASSIGNED_TEAM_ID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityAssignment apIActivityAssignment = (ActivityAssignment) o;
    return Objects.equals(this.ACTIVITY_ID, apIActivityAssignment.ACTIVITY_ID) &&
        Objects.equals(this.RESPONSIBLE_USER_ID, apIActivityAssignment.RESPONSIBLE_USER_ID) &&
        Objects.equals(this.ASSIGNED_TEAM_ID, apIActivityAssignment.ASSIGNED_TEAM_ID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ACTIVITY_ID, RESPONSIBLE_USER_ID, ASSIGNED_TEAM_ID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityAssignment {\n");
    
    sb.append("    ACTIVITY_ID: ").append(toIndentedString(ACTIVITY_ID)).append("\n");
    sb.append("    RESPONSIBLE_USER_ID: ").append(toIndentedString(RESPONSIBLE_USER_ID)).append("\n");
    sb.append("    ASSIGNED_TEAM_ID: ").append(toIndentedString(ASSIGNED_TEAM_ID)).append("\n");
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

