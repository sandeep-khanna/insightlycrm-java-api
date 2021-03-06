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
 * Follow
 */
@JacksonXmlRootElement(localName = "Follow")
@XmlRootElement(name = "Follow")
@XmlAccessorType(XmlAccessType.FIELD)
public class Follow implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("FOLLOWING")
  @JacksonXmlProperty(localName = "FOLLOWING")
  @XmlElement(name = "FOLLOWING")
  private Boolean FOLLOWING = null;

  public Follow FOLLOWING(Boolean FOLLOWING) {
    this.FOLLOWING = FOLLOWING;
    return this;
  }

   /**
   * Get FOLLOWING
   * @return FOLLOWING
  **/
  
  public Boolean getFOLLOWING() {
    return FOLLOWING;
  }

  public void setFOLLOWING(Boolean FOLLOWING) {
    this.FOLLOWING = FOLLOWING;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Follow follow = (Follow) o;
    return Objects.equals(this.FOLLOWING, follow.FOLLOWING);
  }

  @Override
  public int hashCode() {
    return Objects.hash(FOLLOWING);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Follow {\n");
    
    sb.append("    FOLLOWING: ").append(toIndentedString(FOLLOWING)).append("\n");
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

