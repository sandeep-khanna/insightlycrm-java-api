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
import com.insightly.model.ObjectPermissions;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;

/**
 * Permissions
 */
@JacksonXmlRootElement(localName = "Permissions")
@XmlRootElement(name = "Permissions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Permissions implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("PERMISSIONS_STATE")
  @JacksonXmlProperty(localName = "PERMISSIONS_STATE")
  @XmlElement(name = "PERMISSIONS_STATE")
  private String PERMISSIONS_STATE = null;

  @JsonProperty("OBJECT_PERMISSIONS")
  @JacksonXmlProperty(localName = "OBJECT_PERMISSIONS")
  @XmlElement(name = "OBJECT_PERMISSIONS")
  private List<ObjectPermissions> OBJECT_PERMISSIONS = null;

  public Permissions PERMISSIONS_STATE(String PERMISSIONS_STATE) {
    this.PERMISSIONS_STATE = PERMISSIONS_STATE;
    return this;
  }

   /**
   * Get PERMISSIONS_STATE
   * @return PERMISSIONS_STATE
  **/
  
  public String getPERMISSIONSSTATE() {
    return PERMISSIONS_STATE;
  }

  public void setPERMISSIONSSTATE(String PERMISSIONS_STATE) {
    this.PERMISSIONS_STATE = PERMISSIONS_STATE;
  }

  public Permissions OBJECT_PERMISSIONS(List<ObjectPermissions> OBJECT_PERMISSIONS) {
    this.OBJECT_PERMISSIONS = OBJECT_PERMISSIONS;
    return this;
  }

  public Permissions addOBJECTPERMISSIONSItem(ObjectPermissions OBJECT_PERMISSIONSItem) {
    if (this.OBJECT_PERMISSIONS == null) {
      this.OBJECT_PERMISSIONS = new ArrayList<ObjectPermissions>();
    }
    this.OBJECT_PERMISSIONS.add(OBJECT_PERMISSIONSItem);
    return this;
  }

   /**
   * Get OBJECT_PERMISSIONS
   * @return OBJECT_PERMISSIONS
  **/
  
  public List<ObjectPermissions> getOBJECTPERMISSIONS() {
    return OBJECT_PERMISSIONS;
  }

  public void setOBJECTPERMISSIONS(List<ObjectPermissions> OBJECT_PERMISSIONS) {
    this.OBJECT_PERMISSIONS = OBJECT_PERMISSIONS;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Permissions apIPermissions = (Permissions) o;
    return Objects.equals(this.PERMISSIONS_STATE, apIPermissions.PERMISSIONS_STATE) &&
        Objects.equals(this.OBJECT_PERMISSIONS, apIPermissions.OBJECT_PERMISSIONS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(PERMISSIONS_STATE, OBJECT_PERMISSIONS);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Permissions {\n");
    
    sb.append("    PERMISSIONS_STATE: ").append(toIndentedString(PERMISSIONS_STATE)).append("\n");
    sb.append("    OBJECT_PERMISSIONS: ").append(toIndentedString(OBJECT_PERMISSIONS)).append("\n");
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

