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
 * Instance
 */
@JacksonXmlRootElement(localName = "Instance")
@XmlRootElement(name = "Instance")
@XmlAccessorType(XmlAccessType.FIELD)
public class Instance implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("INSTANCE_NAME")
  @JacksonXmlProperty(localName = "INSTANCE_NAME")
  @XmlElement(name = "INSTANCE_NAME")
  private String INSTANCE_NAME = null;

  @JsonProperty("INSTANCE_SUBDOMAIN")
  @JacksonXmlProperty(localName = "INSTANCE_SUBDOMAIN")
  @XmlElement(name = "INSTANCE_SUBDOMAIN")
  private String INSTANCE_SUBDOMAIN = null;

  @JsonProperty("PLAN_NAME")
  @JacksonXmlProperty(localName = "PLAN_NAME")
  @XmlElement(name = "PLAN_NAME")
  private String PLAN_NAME = null;

  public Instance INSTANCE_NAME(String INSTANCE_NAME) {
    this.INSTANCE_NAME = INSTANCE_NAME;
    return this;
  }

   /**
   * Get INSTANCE_NAME
   * @return INSTANCE_NAME
  **/
  
  public String getINSTANCENAME() {
    return INSTANCE_NAME;
  }

  public void setINSTANCENAME(String INSTANCE_NAME) {
    this.INSTANCE_NAME = INSTANCE_NAME;
  }

  public Instance INSTANCE_SUBDOMAIN(String INSTANCE_SUBDOMAIN) {
    this.INSTANCE_SUBDOMAIN = INSTANCE_SUBDOMAIN;
    return this;
  }

   /**
   * Get INSTANCE_SUBDOMAIN
   * @return INSTANCE_SUBDOMAIN
  **/
  
  public String getINSTANCESUBDOMAIN() {
    return INSTANCE_SUBDOMAIN;
  }

  public void setINSTANCESUBDOMAIN(String INSTANCE_SUBDOMAIN) {
    this.INSTANCE_SUBDOMAIN = INSTANCE_SUBDOMAIN;
  }

  public Instance PLAN_NAME(String PLAN_NAME) {
    this.PLAN_NAME = PLAN_NAME;
    return this;
  }

   /**
   * Get PLAN_NAME
   * @return PLAN_NAME
  **/
  
  public String getPLANNAME() {
    return PLAN_NAME;
  }

  public void setPLANNAME(String PLAN_NAME) {
    this.PLAN_NAME = PLAN_NAME;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Instance apIInstance = (Instance) o;
    return Objects.equals(this.INSTANCE_NAME, apIInstance.INSTANCE_NAME) &&
        Objects.equals(this.INSTANCE_SUBDOMAIN, apIInstance.INSTANCE_SUBDOMAIN) &&
        Objects.equals(this.PLAN_NAME, apIInstance.PLAN_NAME);
  }

  @Override
  public int hashCode() {
    return Objects.hash(INSTANCE_NAME, INSTANCE_SUBDOMAIN, PLAN_NAME);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Instance {\n");
    
    sb.append("    INSTANCE_NAME: ").append(toIndentedString(INSTANCE_NAME)).append("\n");
    sb.append("    INSTANCE_SUBDOMAIN: ").append(toIndentedString(INSTANCE_SUBDOMAIN)).append("\n");
    sb.append("    PLAN_NAME: ").append(toIndentedString(PLAN_NAME)).append("\n");
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

