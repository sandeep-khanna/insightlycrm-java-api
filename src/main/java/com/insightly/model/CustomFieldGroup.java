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
 * CustomFieldGroup
 */
@JacksonXmlRootElement(localName = "CustomFieldGroup")
@XmlRootElement(name = "CustomFieldGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomFieldGroup implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("GROUP_ID")
  @JacksonXmlProperty(localName = "GROUP_ID")
  @XmlElement(name = "GROUP_ID")
  private Long GROUP_ID = null;

  @JsonProperty("GROUP_NAME")
  @JacksonXmlProperty(localName = "GROUP_NAME")
  @XmlElement(name = "GROUP_NAME")
  private String GROUP_NAME = null;

  @JsonProperty("GROUP_FOR")
  @JacksonXmlProperty(localName = "GROUP_FOR")
  @XmlElement(name = "GROUP_FOR")
  private String GROUP_FOR = null;

  @JsonProperty("GROUP_ORDER")
  @JacksonXmlProperty(localName = "GROUP_ORDER")
  @XmlElement(name = "GROUP_ORDER")
  private Integer GROUP_ORDER = null;

  public CustomFieldGroup GROUP_ID(Long GROUP_ID) {
    this.GROUP_ID = GROUP_ID;
    return this;
  }

   /**
   * Get GROUP_ID
   * @return GROUP_ID
  **/
  
  public Long getGROUPID() {
    return GROUP_ID;
  }

  public void setGROUPID(Long GROUP_ID) {
    this.GROUP_ID = GROUP_ID;
  }

  public CustomFieldGroup GROUP_NAME(String GROUP_NAME) {
    this.GROUP_NAME = GROUP_NAME;
    return this;
  }

   /**
   * Get GROUP_NAME
   * @return GROUP_NAME
  **/
  
  public String getGROUPNAME() {
    return GROUP_NAME;
  }

  public void setGROUPNAME(String GROUP_NAME) {
    this.GROUP_NAME = GROUP_NAME;
  }

  public CustomFieldGroup GROUP_FOR(String GROUP_FOR) {
    this.GROUP_FOR = GROUP_FOR;
    return this;
  }

   /**
   * Get GROUP_FOR
   * @return GROUP_FOR
  **/
  
  public String getGROUPFOR() {
    return GROUP_FOR;
  }

  public void setGROUPFOR(String GROUP_FOR) {
    this.GROUP_FOR = GROUP_FOR;
  }

  public CustomFieldGroup GROUP_ORDER(Integer GROUP_ORDER) {
    this.GROUP_ORDER = GROUP_ORDER;
    return this;
  }

   /**
   * Get GROUP_ORDER
   * @return GROUP_ORDER
  **/
  
  public Integer getGROUPORDER() {
    return GROUP_ORDER;
  }

  public void setGROUPORDER(Integer GROUP_ORDER) {
    this.GROUP_ORDER = GROUP_ORDER;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldGroup customFieldGroup = (CustomFieldGroup) o;
    return Objects.equals(this.GROUP_ID, customFieldGroup.GROUP_ID) &&
        Objects.equals(this.GROUP_NAME, customFieldGroup.GROUP_NAME) &&
        Objects.equals(this.GROUP_FOR, customFieldGroup.GROUP_FOR) &&
        Objects.equals(this.GROUP_ORDER, customFieldGroup.GROUP_ORDER);
  }

  @Override
  public int hashCode() {
    return Objects.hash(GROUP_ID, GROUP_NAME, GROUP_FOR, GROUP_ORDER);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldGroup {\n");
    
    sb.append("    GROUP_ID: ").append(toIndentedString(GROUP_ID)).append("\n");
    sb.append("    GROUP_NAME: ").append(toIndentedString(GROUP_NAME)).append("\n");
    sb.append("    GROUP_FOR: ").append(toIndentedString(GROUP_FOR)).append("\n");
    sb.append("    GROUP_ORDER: ").append(toIndentedString(GROUP_ORDER)).append("\n");
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

