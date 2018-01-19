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
import com.insightly.model.CustomField;
import com.insightly.model.Link;
import com.insightly.model.Tag;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;

/**
 * Opportunity
 */
@JacksonXmlRootElement(localName = "Opportunity")
@XmlRootElement(name = "Opportunity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Opportunity implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("OPPORTUNITY_ID")
  @JacksonXmlProperty(localName = "OPPORTUNITY_ID")
  @XmlElement(name = "OPPORTUNITY_ID")
  private Long OPPORTUNITY_ID = null;

  @JsonProperty("OPPORTUNITY_NAME")
  @JacksonXmlProperty(localName = "OPPORTUNITY_NAME")
  @XmlElement(name = "OPPORTUNITY_NAME")
  private String OPPORTUNITY_NAME = null;

  @JsonProperty("OPPORTUNITY_DETAILS")
  @JacksonXmlProperty(localName = "OPPORTUNITY_DETAILS")
  @XmlElement(name = "OPPORTUNITY_DETAILS")
  private String OPPORTUNITY_DETAILS = null;

  @JsonProperty("PROBABILITY")
  @JacksonXmlProperty(localName = "PROBABILITY")
  @XmlElement(name = "PROBABILITY")
  private Integer PROBABILITY = null;

  @JsonProperty("BID_CURRENCY")
  @JacksonXmlProperty(localName = "BID_CURRENCY")
  @XmlElement(name = "BID_CURRENCY")
  private String BID_CURRENCY = null;

  @JsonProperty("BID_AMOUNT")
  @JacksonXmlProperty(localName = "BID_AMOUNT")
  @XmlElement(name = "BID_AMOUNT")
  private Long BID_AMOUNT = null;

  @JsonProperty("BID_TYPE")
  @JacksonXmlProperty(localName = "BID_TYPE")
  @XmlElement(name = "BID_TYPE")
  private String BID_TYPE = null;

  @JsonProperty("BID_DURATION")
  @JacksonXmlProperty(localName = "BID_DURATION")
  @XmlElement(name = "BID_DURATION")
  private Integer BID_DURATION = null;

  @JsonProperty("OPPORTUNITY_VALUE")
  @JacksonXmlProperty(localName = "OPPORTUNITY_VALUE")
  @XmlElement(name = "OPPORTUNITY_VALUE")
  private Long OPPORTUNITY_VALUE = null;

  @JsonProperty("FORECAST_CLOSE_DATE")
  @JacksonXmlProperty(localName = "FORECAST_CLOSE_DATE")
  @XmlElement(name = "FORECAST_CLOSE_DATE")
  private OffsetDateTime FORECAST_CLOSE_DATE = null;

  @JsonProperty("ACTUAL_CLOSE_DATE")
  @JacksonXmlProperty(localName = "ACTUAL_CLOSE_DATE")
  @XmlElement(name = "ACTUAL_CLOSE_DATE")
  private OffsetDateTime ACTUAL_CLOSE_DATE = null;

  @JsonProperty("CATEGORY_ID")
  @JacksonXmlProperty(localName = "CATEGORY_ID")
  @XmlElement(name = "CATEGORY_ID")
  private Long CATEGORY_ID = null;

  @JsonProperty("PIPELINE_ID")
  @JacksonXmlProperty(localName = "PIPELINE_ID")
  @XmlElement(name = "PIPELINE_ID")
  private Long PIPELINE_ID = null;

  @JsonProperty("STAGE_ID")
  @JacksonXmlProperty(localName = "STAGE_ID")
  @XmlElement(name = "STAGE_ID")
  private Long STAGE_ID = null;

  @JsonProperty("OPPORTUNITY_STATE")
  @JacksonXmlProperty(localName = "OPPORTUNITY_STATE")
  @XmlElement(name = "OPPORTUNITY_STATE")
  private String OPPORTUNITY_STATE = null;

  @JsonProperty("OPPORTUNITY_STATE_REASON_ID")
  @JacksonXmlProperty(localName = "OPPORTUNITY_STATE_REASON_ID")
  @XmlElement(name = "OPPORTUNITY_STATE_REASON_ID")
  private Long OPPORTUNITY_STATE_REASON_ID = null;

  @JsonProperty("IMAGE_URL")
  @JacksonXmlProperty(localName = "IMAGE_URL")
  @XmlElement(name = "IMAGE_URL")
  private String IMAGE_URL = null;

  @JsonProperty("RESPONSIBLE_USER_ID")
  @JacksonXmlProperty(localName = "RESPONSIBLE_USER_ID")
  @XmlElement(name = "RESPONSIBLE_USER_ID")
  private Integer RESPONSIBLE_USER_ID = null;

  @JsonProperty("OWNER_USER_ID")
  @JacksonXmlProperty(localName = "OWNER_USER_ID")
  @XmlElement(name = "OWNER_USER_ID")
  private Integer OWNER_USER_ID = null;

  @JsonProperty("DATE_CREATED_UTC")
  @JacksonXmlProperty(localName = "DATE_CREATED_UTC")
  @XmlElement(name = "DATE_CREATED_UTC")
  private OffsetDateTime DATE_CREATED_UTC = null;

  @JsonProperty("DATE_UPDATED_UTC")
  @JacksonXmlProperty(localName = "DATE_UPDATED_UTC")
  @XmlElement(name = "DATE_UPDATED_UTC")
  private OffsetDateTime DATE_UPDATED_UTC = null;

  @JsonProperty("VISIBLE_TO")
  @JacksonXmlProperty(localName = "VISIBLE_TO")
  @XmlElement(name = "VISIBLE_TO")
  private String VISIBLE_TO = null;

  @JsonProperty("VISIBLE_TEAM_ID")
  @JacksonXmlProperty(localName = "VISIBLE_TEAM_ID")
  @XmlElement(name = "VISIBLE_TEAM_ID")
  private Long VISIBLE_TEAM_ID = null;

  @JsonProperty("VISIBLE_USER_IDS")
  @JacksonXmlProperty(localName = "VISIBLE_USER_IDS")
  @XmlElement(name = "VISIBLE_USER_IDS")
  private String VISIBLE_USER_IDS = null;

  @JsonProperty("CUSTOMFIELDS")
  @JacksonXmlProperty(localName = "CUSTOMFIELDS")
  @XmlElement(name = "CUSTOMFIELDS")
  private List<CustomField> CUSTOMFIELDS = null;

  @JsonProperty("TAGS")
  @JacksonXmlProperty(localName = "TAGS")
  @XmlElement(name = "TAGS")
  private List<Tag> TAGS = null;

  @JsonProperty("LINKS")
  @JacksonXmlProperty(localName = "LINKS")
  @XmlElement(name = "LINKS")
  private List<Link> LINKS = null;

  @JsonProperty("CAN_EDIT")
  @JacksonXmlProperty(localName = "CAN_EDIT")
  @XmlElement(name = "CAN_EDIT")
  private Boolean CAN_EDIT = null;

  @JsonProperty("CAN_DELETE")
  @JacksonXmlProperty(localName = "CAN_DELETE")
  @XmlElement(name = "CAN_DELETE")
  private Boolean CAN_DELETE = null;

  public Opportunity OPPORTUNITY_ID(Long OPPORTUNITY_ID) {
    this.OPPORTUNITY_ID = OPPORTUNITY_ID;
    return this;
  }

   /**
   * Get OPPORTUNITY_ID
   * @return OPPORTUNITY_ID
  **/
  
  public Long getOPPORTUNITYID() {
    return OPPORTUNITY_ID;
  }

  public void setOPPORTUNITYID(Long OPPORTUNITY_ID) {
    this.OPPORTUNITY_ID = OPPORTUNITY_ID;
  }

  public Opportunity OPPORTUNITY_NAME(String OPPORTUNITY_NAME) {
    this.OPPORTUNITY_NAME = OPPORTUNITY_NAME;
    return this;
  }

   /**
   * Get OPPORTUNITY_NAME
   * @return OPPORTUNITY_NAME
  **/
  
  public String getOPPORTUNITYNAME() {
    return OPPORTUNITY_NAME;
  }

  public void setOPPORTUNITYNAME(String OPPORTUNITY_NAME) {
    this.OPPORTUNITY_NAME = OPPORTUNITY_NAME;
  }

  public Opportunity OPPORTUNITY_DETAILS(String OPPORTUNITY_DETAILS) {
    this.OPPORTUNITY_DETAILS = OPPORTUNITY_DETAILS;
    return this;
  }

   /**
   * Get OPPORTUNITY_DETAILS
   * @return OPPORTUNITY_DETAILS
  **/
  
  public String getOPPORTUNITYDETAILS() {
    return OPPORTUNITY_DETAILS;
  }

  public void setOPPORTUNITYDETAILS(String OPPORTUNITY_DETAILS) {
    this.OPPORTUNITY_DETAILS = OPPORTUNITY_DETAILS;
  }

  public Opportunity PROBABILITY(Integer PROBABILITY) {
    this.PROBABILITY = PROBABILITY;
    return this;
  }

   /**
   * Get PROBABILITY
   * @return PROBABILITY
  **/
  
  public Integer getPROBABILITY() {
    return PROBABILITY;
  }

  public void setPROBABILITY(Integer PROBABILITY) {
    this.PROBABILITY = PROBABILITY;
  }

  public Opportunity BID_CURRENCY(String BID_CURRENCY) {
    this.BID_CURRENCY = BID_CURRENCY;
    return this;
  }

   /**
   * Get BID_CURRENCY
   * @return BID_CURRENCY
  **/
  
  public String getBIDCURRENCY() {
    return BID_CURRENCY;
  }

  public void setBIDCURRENCY(String BID_CURRENCY) {
    this.BID_CURRENCY = BID_CURRENCY;
  }

  public Opportunity BID_AMOUNT(Long BID_AMOUNT) {
    this.BID_AMOUNT = BID_AMOUNT;
    return this;
  }

   /**
   * Get BID_AMOUNT
   * @return BID_AMOUNT
  **/
  
  public Long getBIDAMOUNT() {
    return BID_AMOUNT;
  }

  public void setBIDAMOUNT(Long BID_AMOUNT) {
    this.BID_AMOUNT = BID_AMOUNT;
  }

  public Opportunity BID_TYPE(String BID_TYPE) {
    this.BID_TYPE = BID_TYPE;
    return this;
  }

   /**
   * Get BID_TYPE
   * @return BID_TYPE
  **/
  
  public String getBIDTYPE() {
    return BID_TYPE;
  }

  public void setBIDTYPE(String BID_TYPE) {
    this.BID_TYPE = BID_TYPE;
  }

  public Opportunity BID_DURATION(Integer BID_DURATION) {
    this.BID_DURATION = BID_DURATION;
    return this;
  }

   /**
   * Get BID_DURATION
   * @return BID_DURATION
  **/
  
  public Integer getBIDDURATION() {
    return BID_DURATION;
  }

  public void setBIDDURATION(Integer BID_DURATION) {
    this.BID_DURATION = BID_DURATION;
  }

  public Opportunity OPPORTUNITY_VALUE(Long OPPORTUNITY_VALUE) {
    this.OPPORTUNITY_VALUE = OPPORTUNITY_VALUE;
    return this;
  }

   /**
   * Get OPPORTUNITY_VALUE
   * @return OPPORTUNITY_VALUE
  **/
  
  public Long getOPPORTUNITYVALUE() {
    return OPPORTUNITY_VALUE;
  }

  public void setOPPORTUNITYVALUE(Long OPPORTUNITY_VALUE) {
    this.OPPORTUNITY_VALUE = OPPORTUNITY_VALUE;
  }

  public Opportunity FORECAST_CLOSE_DATE(OffsetDateTime FORECAST_CLOSE_DATE) {
    this.FORECAST_CLOSE_DATE = FORECAST_CLOSE_DATE;
    return this;
  }

   /**
   * Get FORECAST_CLOSE_DATE
   * @return FORECAST_CLOSE_DATE
  **/
  
  public OffsetDateTime getFORECASTCLOSEDATE() {
    return FORECAST_CLOSE_DATE;
  }

  public void setFORECASTCLOSEDATE(OffsetDateTime FORECAST_CLOSE_DATE) {
    this.FORECAST_CLOSE_DATE = FORECAST_CLOSE_DATE;
  }

  public Opportunity ACTUAL_CLOSE_DATE(OffsetDateTime ACTUAL_CLOSE_DATE) {
    this.ACTUAL_CLOSE_DATE = ACTUAL_CLOSE_DATE;
    return this;
  }

   /**
   * Get ACTUAL_CLOSE_DATE
   * @return ACTUAL_CLOSE_DATE
  **/
  
  public OffsetDateTime getACTUALCLOSEDATE() {
    return ACTUAL_CLOSE_DATE;
  }

  public void setACTUALCLOSEDATE(OffsetDateTime ACTUAL_CLOSE_DATE) {
    this.ACTUAL_CLOSE_DATE = ACTUAL_CLOSE_DATE;
  }

  public Opportunity CATEGORY_ID(Long CATEGORY_ID) {
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

  public Opportunity PIPELINE_ID(Long PIPELINE_ID) {
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

  public Opportunity STAGE_ID(Long STAGE_ID) {
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

  public Opportunity OPPORTUNITY_STATE(String OPPORTUNITY_STATE) {
    this.OPPORTUNITY_STATE = OPPORTUNITY_STATE;
    return this;
  }

   /**
   * Get OPPORTUNITY_STATE
   * @return OPPORTUNITY_STATE
  **/
  
  public String getOPPORTUNITYSTATE() {
    return OPPORTUNITY_STATE;
  }

  public void setOPPORTUNITYSTATE(String OPPORTUNITY_STATE) {
    this.OPPORTUNITY_STATE = OPPORTUNITY_STATE;
  }

  public Opportunity OPPORTUNITY_STATE_REASON_ID(Long OPPORTUNITY_STATE_REASON_ID) {
    this.OPPORTUNITY_STATE_REASON_ID = OPPORTUNITY_STATE_REASON_ID;
    return this;
  }

   /**
   * Get OPPORTUNITY_STATE_REASON_ID
   * @return OPPORTUNITY_STATE_REASON_ID
  **/
  
  public Long getOPPORTUNITYSTATEREASONID() {
    return OPPORTUNITY_STATE_REASON_ID;
  }

  public void setOPPORTUNITYSTATEREASONID(Long OPPORTUNITY_STATE_REASON_ID) {
    this.OPPORTUNITY_STATE_REASON_ID = OPPORTUNITY_STATE_REASON_ID;
  }

  public Opportunity IMAGE_URL(String IMAGE_URL) {
    this.IMAGE_URL = IMAGE_URL;
    return this;
  }

   /**
   * Get IMAGE_URL
   * @return IMAGE_URL
  **/
  
  public String getIMAGEURL() {
    return IMAGE_URL;
  }

  public void setIMAGEURL(String IMAGE_URL) {
    this.IMAGE_URL = IMAGE_URL;
  }

  public Opportunity RESPONSIBLE_USER_ID(Integer RESPONSIBLE_USER_ID) {
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

  public Opportunity OWNER_USER_ID(Integer OWNER_USER_ID) {
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

  public Opportunity DATE_CREATED_UTC(OffsetDateTime DATE_CREATED_UTC) {
    this.DATE_CREATED_UTC = DATE_CREATED_UTC;
    return this;
  }

   /**
   * Get DATE_CREATED_UTC
   * @return DATE_CREATED_UTC
  **/
  
  public OffsetDateTime getDATECREATEDUTC() {
    return DATE_CREATED_UTC;
  }

  public void setDATECREATEDUTC(OffsetDateTime DATE_CREATED_UTC) {
    this.DATE_CREATED_UTC = DATE_CREATED_UTC;
  }

  public Opportunity DATE_UPDATED_UTC(OffsetDateTime DATE_UPDATED_UTC) {
    this.DATE_UPDATED_UTC = DATE_UPDATED_UTC;
    return this;
  }

   /**
   * Get DATE_UPDATED_UTC
   * @return DATE_UPDATED_UTC
  **/
  
  public OffsetDateTime getDATEUPDATEDUTC() {
    return DATE_UPDATED_UTC;
  }

  public void setDATEUPDATEDUTC(OffsetDateTime DATE_UPDATED_UTC) {
    this.DATE_UPDATED_UTC = DATE_UPDATED_UTC;
  }

  public Opportunity VISIBLE_TO(String VISIBLE_TO) {
    this.VISIBLE_TO = VISIBLE_TO;
    return this;
  }

   /**
   * Get VISIBLE_TO
   * @return VISIBLE_TO
  **/
  
  public String getVISIBLETO() {
    return VISIBLE_TO;
  }

  public void setVISIBLETO(String VISIBLE_TO) {
    this.VISIBLE_TO = VISIBLE_TO;
  }

  public Opportunity VISIBLE_TEAM_ID(Long VISIBLE_TEAM_ID) {
    this.VISIBLE_TEAM_ID = VISIBLE_TEAM_ID;
    return this;
  }

   /**
   * Get VISIBLE_TEAM_ID
   * @return VISIBLE_TEAM_ID
  **/
  
  public Long getVISIBLETEAMID() {
    return VISIBLE_TEAM_ID;
  }

  public void setVISIBLETEAMID(Long VISIBLE_TEAM_ID) {
    this.VISIBLE_TEAM_ID = VISIBLE_TEAM_ID;
  }

  public Opportunity VISIBLE_USER_IDS(String VISIBLE_USER_IDS) {
    this.VISIBLE_USER_IDS = VISIBLE_USER_IDS;
    return this;
  }

   /**
   * Get VISIBLE_USER_IDS
   * @return VISIBLE_USER_IDS
  **/
  
  public String getVISIBLEUSERIDS() {
    return VISIBLE_USER_IDS;
  }

  public void setVISIBLEUSERIDS(String VISIBLE_USER_IDS) {
    this.VISIBLE_USER_IDS = VISIBLE_USER_IDS;
  }

  public Opportunity CUSTOMFIELDS(List<CustomField> CUSTOMFIELDS) {
    this.CUSTOMFIELDS = CUSTOMFIELDS;
    return this;
  }

  public Opportunity addCUSTOMFIELDSItem(CustomField CUSTOMFIELDSItem) {
    if (this.CUSTOMFIELDS == null) {
      this.CUSTOMFIELDS = new ArrayList<CustomField>();
    }
    this.CUSTOMFIELDS.add(CUSTOMFIELDSItem);
    return this;
  }

   /**
   * Get CUSTOMFIELDS
   * @return CUSTOMFIELDS
  **/
  
  public List<CustomField> getCUSTOMFIELDS() {
    return CUSTOMFIELDS;
  }

  public void setCUSTOMFIELDS(List<CustomField> CUSTOMFIELDS) {
    this.CUSTOMFIELDS = CUSTOMFIELDS;
  }

  public Opportunity TAGS(List<Tag> TAGS) {
    this.TAGS = TAGS;
    return this;
  }

  public Opportunity addTAGSItem(Tag TAGSItem) {
    if (this.TAGS == null) {
      this.TAGS = new ArrayList<Tag>();
    }
    this.TAGS.add(TAGSItem);
    return this;
  }

   /**
   * Get TAGS
   * @return TAGS
  **/
  
  public List<Tag> getTAGS() {
    return TAGS;
  }

  public void setTAGS(List<Tag> TAGS) {
    this.TAGS = TAGS;
  }

  public Opportunity LINKS(List<Link> LINKS) {
    this.LINKS = LINKS;
    return this;
  }

  public Opportunity addLINKSItem(Link LINKSItem) {
    if (this.LINKS == null) {
      this.LINKS = new ArrayList<Link>();
    }
    this.LINKS.add(LINKSItem);
    return this;
  }

   /**
   * Get LINKS
   * @return LINKS
  **/
  
  public List<Link> getLINKS() {
    return LINKS;
  }

  public void setLINKS(List<Link> LINKS) {
    this.LINKS = LINKS;
  }

  public Opportunity CAN_EDIT(Boolean CAN_EDIT) {
    this.CAN_EDIT = CAN_EDIT;
    return this;
  }

   /**
   * Get CAN_EDIT
   * @return CAN_EDIT
  **/
  
  public Boolean getCANEDIT() {
    return CAN_EDIT;
  }

  public void setCANEDIT(Boolean CAN_EDIT) {
    this.CAN_EDIT = CAN_EDIT;
  }

  public Opportunity CAN_DELETE(Boolean CAN_DELETE) {
    this.CAN_DELETE = CAN_DELETE;
    return this;
  }

   /**
   * Get CAN_DELETE
   * @return CAN_DELETE
  **/
  
  public Boolean getCANDELETE() {
    return CAN_DELETE;
  }

  public void setCANDELETE(Boolean CAN_DELETE) {
    this.CAN_DELETE = CAN_DELETE;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Opportunity opportunity = (Opportunity) o;
    return Objects.equals(this.OPPORTUNITY_ID, opportunity.OPPORTUNITY_ID) &&
        Objects.equals(this.OPPORTUNITY_NAME, opportunity.OPPORTUNITY_NAME) &&
        Objects.equals(this.OPPORTUNITY_DETAILS, opportunity.OPPORTUNITY_DETAILS) &&
        Objects.equals(this.PROBABILITY, opportunity.PROBABILITY) &&
        Objects.equals(this.BID_CURRENCY, opportunity.BID_CURRENCY) &&
        Objects.equals(this.BID_AMOUNT, opportunity.BID_AMOUNT) &&
        Objects.equals(this.BID_TYPE, opportunity.BID_TYPE) &&
        Objects.equals(this.BID_DURATION, opportunity.BID_DURATION) &&
        Objects.equals(this.OPPORTUNITY_VALUE, opportunity.OPPORTUNITY_VALUE) &&
        Objects.equals(this.FORECAST_CLOSE_DATE, opportunity.FORECAST_CLOSE_DATE) &&
        Objects.equals(this.ACTUAL_CLOSE_DATE, opportunity.ACTUAL_CLOSE_DATE) &&
        Objects.equals(this.CATEGORY_ID, opportunity.CATEGORY_ID) &&
        Objects.equals(this.PIPELINE_ID, opportunity.PIPELINE_ID) &&
        Objects.equals(this.STAGE_ID, opportunity.STAGE_ID) &&
        Objects.equals(this.OPPORTUNITY_STATE, opportunity.OPPORTUNITY_STATE) &&
        Objects.equals(this.OPPORTUNITY_STATE_REASON_ID, opportunity.OPPORTUNITY_STATE_REASON_ID) &&
        Objects.equals(this.IMAGE_URL, opportunity.IMAGE_URL) &&
        Objects.equals(this.RESPONSIBLE_USER_ID, opportunity.RESPONSIBLE_USER_ID) &&
        Objects.equals(this.OWNER_USER_ID, opportunity.OWNER_USER_ID) &&
        Objects.equals(this.DATE_CREATED_UTC, opportunity.DATE_CREATED_UTC) &&
        Objects.equals(this.DATE_UPDATED_UTC, opportunity.DATE_UPDATED_UTC) &&
        Objects.equals(this.VISIBLE_TO, opportunity.VISIBLE_TO) &&
        Objects.equals(this.VISIBLE_TEAM_ID, opportunity.VISIBLE_TEAM_ID) &&
        Objects.equals(this.VISIBLE_USER_IDS, opportunity.VISIBLE_USER_IDS) &&
        Objects.equals(this.CUSTOMFIELDS, opportunity.CUSTOMFIELDS) &&
        Objects.equals(this.TAGS, opportunity.TAGS) &&
        Objects.equals(this.LINKS, opportunity.LINKS) &&
        Objects.equals(this.CAN_EDIT, opportunity.CAN_EDIT) &&
        Objects.equals(this.CAN_DELETE, opportunity.CAN_DELETE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(OPPORTUNITY_ID, OPPORTUNITY_NAME, OPPORTUNITY_DETAILS, PROBABILITY, BID_CURRENCY, BID_AMOUNT, BID_TYPE, BID_DURATION, OPPORTUNITY_VALUE, FORECAST_CLOSE_DATE, ACTUAL_CLOSE_DATE, CATEGORY_ID, PIPELINE_ID, STAGE_ID, OPPORTUNITY_STATE, OPPORTUNITY_STATE_REASON_ID, IMAGE_URL, RESPONSIBLE_USER_ID, OWNER_USER_ID, DATE_CREATED_UTC, DATE_UPDATED_UTC, VISIBLE_TO, VISIBLE_TEAM_ID, VISIBLE_USER_IDS, CUSTOMFIELDS, TAGS, LINKS, CAN_EDIT, CAN_DELETE);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Opportunity {\n");
    
    sb.append("    OPPORTUNITY_ID: ").append(toIndentedString(OPPORTUNITY_ID)).append("\n");
    sb.append("    OPPORTUNITY_NAME: ").append(toIndentedString(OPPORTUNITY_NAME)).append("\n");
    sb.append("    OPPORTUNITY_DETAILS: ").append(toIndentedString(OPPORTUNITY_DETAILS)).append("\n");
    sb.append("    PROBABILITY: ").append(toIndentedString(PROBABILITY)).append("\n");
    sb.append("    BID_CURRENCY: ").append(toIndentedString(BID_CURRENCY)).append("\n");
    sb.append("    BID_AMOUNT: ").append(toIndentedString(BID_AMOUNT)).append("\n");
    sb.append("    BID_TYPE: ").append(toIndentedString(BID_TYPE)).append("\n");
    sb.append("    BID_DURATION: ").append(toIndentedString(BID_DURATION)).append("\n");
    sb.append("    OPPORTUNITY_VALUE: ").append(toIndentedString(OPPORTUNITY_VALUE)).append("\n");
    sb.append("    FORECAST_CLOSE_DATE: ").append(toIndentedString(FORECAST_CLOSE_DATE)).append("\n");
    sb.append("    ACTUAL_CLOSE_DATE: ").append(toIndentedString(ACTUAL_CLOSE_DATE)).append("\n");
    sb.append("    CATEGORY_ID: ").append(toIndentedString(CATEGORY_ID)).append("\n");
    sb.append("    PIPELINE_ID: ").append(toIndentedString(PIPELINE_ID)).append("\n");
    sb.append("    STAGE_ID: ").append(toIndentedString(STAGE_ID)).append("\n");
    sb.append("    OPPORTUNITY_STATE: ").append(toIndentedString(OPPORTUNITY_STATE)).append("\n");
    sb.append("    OPPORTUNITY_STATE_REASON_ID: ").append(toIndentedString(OPPORTUNITY_STATE_REASON_ID)).append("\n");
    sb.append("    IMAGE_URL: ").append(toIndentedString(IMAGE_URL)).append("\n");
    sb.append("    RESPONSIBLE_USER_ID: ").append(toIndentedString(RESPONSIBLE_USER_ID)).append("\n");
    sb.append("    OWNER_USER_ID: ").append(toIndentedString(OWNER_USER_ID)).append("\n");
    sb.append("    DATE_CREATED_UTC: ").append(toIndentedString(DATE_CREATED_UTC)).append("\n");
    sb.append("    DATE_UPDATED_UTC: ").append(toIndentedString(DATE_UPDATED_UTC)).append("\n");
    sb.append("    VISIBLE_TO: ").append(toIndentedString(VISIBLE_TO)).append("\n");
    sb.append("    VISIBLE_TEAM_ID: ").append(toIndentedString(VISIBLE_TEAM_ID)).append("\n");
    sb.append("    VISIBLE_USER_IDS: ").append(toIndentedString(VISIBLE_USER_IDS)).append("\n");
    sb.append("    CUSTOMFIELDS: ").append(toIndentedString(CUSTOMFIELDS)).append("\n");
    sb.append("    TAGS: ").append(toIndentedString(TAGS)).append("\n");
    sb.append("    LINKS: ").append(toIndentedString(LINKS)).append("\n");
    sb.append("    CAN_EDIT: ").append(toIndentedString(CAN_EDIT)).append("\n");
    sb.append("    CAN_DELETE: ").append(toIndentedString(CAN_DELETE)).append("\n");
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

