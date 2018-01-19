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
 * Category
 */
@JacksonXmlRootElement(localName = "Category")
@XmlRootElement(name = "Category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("CATEGORY_ID")
  @JacksonXmlProperty(localName = "CATEGORY_ID")
  @XmlElement(name = "CATEGORY_ID")
  private Long CATEGORY_ID = null;

  @JsonProperty("CATEGORY_NAME")
  @JacksonXmlProperty(localName = "CATEGORY_NAME")
  @XmlElement(name = "CATEGORY_NAME")
  private String CATEGORY_NAME = null;

  @JsonProperty("ACTIVE")
  @JacksonXmlProperty(localName = "ACTIVE")
  @XmlElement(name = "ACTIVE")
  private Boolean ACTIVE = null;

  @JsonProperty("BACKGROUND_COLOR")
  @JacksonXmlProperty(localName = "BACKGROUND_COLOR")
  @XmlElement(name = "BACKGROUND_COLOR")
  private String BACKGROUND_COLOR = null;

  public Category CATEGORY_ID(Long CATEGORY_ID) {
    this.CATEGORY_ID = CATEGORY_ID;
    return this;
  }

   /**
   * Get CATEGORY_ID
   * @return CATEGORY_ID
  **/
  
  public Long getCATEGORYID() {
    return CATEGORY_ID;
  }

  public void setCATEGORYID(Long CATEGORY_ID) {
    this.CATEGORY_ID = CATEGORY_ID;
  }

  public Category CATEGORY_NAME(String CATEGORY_NAME) {
    this.CATEGORY_NAME = CATEGORY_NAME;
    return this;
  }

   /**
   * Get CATEGORY_NAME
   * @return CATEGORY_NAME
  **/
  
  public String getCATEGORYNAME() {
    return CATEGORY_NAME;
  }

  public void setCATEGORYNAME(String CATEGORY_NAME) {
    this.CATEGORY_NAME = CATEGORY_NAME;
  }

  public Category ACTIVE(Boolean ACTIVE) {
    this.ACTIVE = ACTIVE;
    return this;
  }

   /**
   * Get ACTIVE
   * @return ACTIVE
  **/
  
  public Boolean getACTIVE() {
    return ACTIVE;
  }

  public void setACTIVE(Boolean ACTIVE) {
    this.ACTIVE = ACTIVE;
  }

  public Category BACKGROUND_COLOR(String BACKGROUND_COLOR) {
    this.BACKGROUND_COLOR = BACKGROUND_COLOR;
    return this;
  }

   /**
   * Get BACKGROUND_COLOR
   * @return BACKGROUND_COLOR
  **/
  
  public String getBACKGROUNDCOLOR() {
    return BACKGROUND_COLOR;
  }

  public void setBACKGROUNDCOLOR(String BACKGROUND_COLOR) {
    this.BACKGROUND_COLOR = BACKGROUND_COLOR;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.CATEGORY_ID, category.CATEGORY_ID) &&
        Objects.equals(this.CATEGORY_NAME, category.CATEGORY_NAME) &&
        Objects.equals(this.ACTIVE, category.ACTIVE) &&
        Objects.equals(this.BACKGROUND_COLOR, category.BACKGROUND_COLOR);
  }

  @Override
  public int hashCode() {
    return Objects.hash(CATEGORY_ID, CATEGORY_NAME, ACTIVE, BACKGROUND_COLOR);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    CATEGORY_ID: ").append(toIndentedString(CATEGORY_ID)).append("\n");
    sb.append("    CATEGORY_NAME: ").append(toIndentedString(CATEGORY_NAME)).append("\n");
    sb.append("    ACTIVE: ").append(toIndentedString(ACTIVE)).append("\n");
    sb.append("    BACKGROUND_COLOR: ").append(toIndentedString(BACKGROUND_COLOR)).append("\n");
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

