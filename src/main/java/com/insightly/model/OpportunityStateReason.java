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
 * OpportunityStateReason
 */
@JacksonXmlRootElement(localName = "OpportunityStateReason")
@XmlRootElement(name = "OpportunityStateReason")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpportunityStateReason implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("STATE_REASON_ID")
  @JacksonXmlProperty(localName = "STATE_REASON_ID")
  @XmlElement(name = "STATE_REASON_ID")
  private Long STATE_REASON_ID = null;

  @JsonProperty("STATE_REASON")
  @JacksonXmlProperty(localName = "STATE_REASON")
  @XmlElement(name = "STATE_REASON")
  private String STATE_REASON = null;

  @JsonProperty("FOR_OPPORTUNITY_STATE")
  @JacksonXmlProperty(localName = "FOR_OPPORTUNITY_STATE")
  @XmlElement(name = "FOR_OPPORTUNITY_STATE")
  private String FOR_OPPORTUNITY_STATE = null;

  public OpportunityStateReason STATE_REASON_ID(Long STATE_REASON_ID) {
    this.STATE_REASON_ID = STATE_REASON_ID;
    return this;
  }

   /**
   * Get STATE_REASON_ID
   * @return STATE_REASON_ID
  **/
  
  public Long getSTATEREASONID() {
    return STATE_REASON_ID;
  }

  public void setSTATEREASONID(Long STATE_REASON_ID) {
    this.STATE_REASON_ID = STATE_REASON_ID;
  }

  public OpportunityStateReason STATE_REASON(String STATE_REASON) {
    this.STATE_REASON = STATE_REASON;
    return this;
  }

   /**
   * Get STATE_REASON
   * @return STATE_REASON
  **/
  
  public String getSTATEREASON() {
    return STATE_REASON;
  }

  public void setSTATEREASON(String STATE_REASON) {
    this.STATE_REASON = STATE_REASON;
  }

  public OpportunityStateReason FOR_OPPORTUNITY_STATE(String FOR_OPPORTUNITY_STATE) {
    this.FOR_OPPORTUNITY_STATE = FOR_OPPORTUNITY_STATE;
    return this;
  }

   /**
   * Get FOR_OPPORTUNITY_STATE
   * @return FOR_OPPORTUNITY_STATE
  **/
  
  public String getFOROPPORTUNITYSTATE() {
    return FOR_OPPORTUNITY_STATE;
  }

  public void setFOROPPORTUNITYSTATE(String FOR_OPPORTUNITY_STATE) {
    this.FOR_OPPORTUNITY_STATE = FOR_OPPORTUNITY_STATE;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpportunityStateReason opportunityStateReason = (OpportunityStateReason) o;
    return Objects.equals(this.STATE_REASON_ID, opportunityStateReason.STATE_REASON_ID) &&
        Objects.equals(this.STATE_REASON, opportunityStateReason.STATE_REASON) &&
        Objects.equals(this.FOR_OPPORTUNITY_STATE, opportunityStateReason.FOR_OPPORTUNITY_STATE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(STATE_REASON_ID, STATE_REASON, FOR_OPPORTUNITY_STATE);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpportunityStateReason {\n");
    
    sb.append("    STATE_REASON_ID: ").append(toIndentedString(STATE_REASON_ID)).append("\n");
    sb.append("    STATE_REASON: ").append(toIndentedString(STATE_REASON)).append("\n");
    sb.append("    FOR_OPPORTUNITY_STATE: ").append(toIndentedString(FOR_OPPORTUNITY_STATE)).append("\n");
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

