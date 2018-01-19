package com.insightly.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;



/**
 * ActivitySet
 */
@JacksonXmlRootElement(localName = "ActivitySet")
@XmlRootElement(name = "ActivitySet")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivitySet implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("ACTIVITYSET_ID")
  @JacksonXmlProperty(localName = "ACTIVITYSET_ID")
  @XmlElement(name = "ACTIVITYSET_ID")
  private Long ACTIVITYSET_ID = null;

  @JsonProperty("NAME")
  @JacksonXmlProperty(localName = "NAME")
  @XmlElement(name = "NAME")
  private String NAME = null;

  @JsonProperty("FOR_CONTACTS")
  @JacksonXmlProperty(localName = "FOR_CONTACTS")
  @XmlElement(name = "FOR_CONTACTS")
  private Boolean FOR_CONTACTS = null;

  @JsonProperty("FOR_ORGANISATIONS")
  @JacksonXmlProperty(localName = "FOR_ORGANISATIONS")
  @XmlElement(name = "FOR_ORGANISATIONS")
  private Boolean FOR_ORGANISATIONS = null;

  @JsonProperty("FOR_OPPORTUNITIES")
  @JacksonXmlProperty(localName = "FOR_OPPORTUNITIES")
  @XmlElement(name = "FOR_OPPORTUNITIES")
  private Boolean FOR_OPPORTUNITIES = null;

  @JsonProperty("FOR_PROJECTS")
  @JacksonXmlProperty(localName = "FOR_PROJECTS")
  @XmlElement(name = "FOR_PROJECTS")
  private Boolean FOR_PROJECTS = null;

  @JsonProperty("FOR_LEADS")
  @JacksonXmlProperty(localName = "FOR_LEADS")
  @XmlElement(name = "FOR_LEADS")
  private Boolean FOR_LEADS = null;

  @JsonProperty("OWNER_USER_ID")
  @JacksonXmlProperty(localName = "OWNER_USER_ID")
  @XmlElement(name = "OWNER_USER_ID")
  private Integer OWNER_USER_ID = null;

  @JsonProperty("ACTIVITIES")
  @JacksonXmlProperty(localName = "ACTIVITIES")
  @XmlElement(name = "ACTIVITIES")
  private List<Activity> ACTIVITIES = null;

  public ActivitySet ACTIVITYSET_ID(Long ACTIVITYSET_ID) {
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

  public ActivitySet NAME(String NAME) {
    this.NAME = NAME;
    return this;
  }

   /**
   * Get NAME
   * @return NAME
  **/
  
  public String getNAME() {
    return NAME;
  }

  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  public ActivitySet FOR_CONTACTS(Boolean FOR_CONTACTS) {
    this.FOR_CONTACTS = FOR_CONTACTS;
    return this;
  }

   /**
   * Get FOR_CONTACTS
   * @return FOR_CONTACTS
  **/
  
  public Boolean getFORCONTACTS() {
    return FOR_CONTACTS;
  }

  public void setFORCONTACTS(Boolean FOR_CONTACTS) {
    this.FOR_CONTACTS = FOR_CONTACTS;
  }

  public ActivitySet FOR_ORGANISATIONS(Boolean FOR_ORGANISATIONS) {
    this.FOR_ORGANISATIONS = FOR_ORGANISATIONS;
    return this;
  }

   /**
   * Get FOR_ORGANISATIONS
   * @return FOR_ORGANISATIONS
  **/
  
  public Boolean getFORORGANISATIONS() {
    return FOR_ORGANISATIONS;
  }

  public void setFORORGANISATIONS(Boolean FOR_ORGANISATIONS) {
    this.FOR_ORGANISATIONS = FOR_ORGANISATIONS;
  }

  public ActivitySet FOR_OPPORTUNITIES(Boolean FOR_OPPORTUNITIES) {
    this.FOR_OPPORTUNITIES = FOR_OPPORTUNITIES;
    return this;
  }

   /**
   * Get FOR_OPPORTUNITIES
   * @return FOR_OPPORTUNITIES
  **/
  
  public Boolean getFOROPPORTUNITIES() {
    return FOR_OPPORTUNITIES;
  }

  public void setFOROPPORTUNITIES(Boolean FOR_OPPORTUNITIES) {
    this.FOR_OPPORTUNITIES = FOR_OPPORTUNITIES;
  }

  public ActivitySet FOR_PROJECTS(Boolean FOR_PROJECTS) {
    this.FOR_PROJECTS = FOR_PROJECTS;
    return this;
  }

   /**
   * Get FOR_PROJECTS
   * @return FOR_PROJECTS
  **/
  
  public Boolean getFORPROJECTS() {
    return FOR_PROJECTS;
  }

  public void setFORPROJECTS(Boolean FOR_PROJECTS) {
    this.FOR_PROJECTS = FOR_PROJECTS;
  }

  public ActivitySet FOR_LEADS(Boolean FOR_LEADS) {
    this.FOR_LEADS = FOR_LEADS;
    return this;
  }

   /**
   * Get FOR_LEADS
   * @return FOR_LEADS
  **/
  
  public Boolean getFORLEADS() {
    return FOR_LEADS;
  }

  public void setFORLEADS(Boolean FOR_LEADS) {
    this.FOR_LEADS = FOR_LEADS;
  }

  public ActivitySet OWNER_USER_ID(Integer OWNER_USER_ID) {
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

  public ActivitySet ACTIVITIES(List<Activity> ACTIVITIES) {
    this.ACTIVITIES = ACTIVITIES;
    return this;
  }

  public ActivitySet addACTIVITIESItem(Activity ACTIVITIESItem) {
    if (this.ACTIVITIES == null) {
      this.ACTIVITIES = new ArrayList<Activity>();
    }
    this.ACTIVITIES.add(ACTIVITIESItem);
    return this;
  }

   /**
   * Get ACTIVITIES
   * @return ACTIVITIES
  **/
  
  public List<Activity> getACTIVITIES() {
    return ACTIVITIES;
  }

  public void setACTIVITIES(List<Activity> ACTIVITIES) {
    this.ACTIVITIES = ACTIVITIES;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivitySet activitySet = (ActivitySet) o;
    return Objects.equals(this.ACTIVITYSET_ID, activitySet.ACTIVITYSET_ID) &&
        Objects.equals(this.NAME, activitySet.NAME) &&
        Objects.equals(this.FOR_CONTACTS, activitySet.FOR_CONTACTS) &&
        Objects.equals(this.FOR_ORGANISATIONS, activitySet.FOR_ORGANISATIONS) &&
        Objects.equals(this.FOR_OPPORTUNITIES, activitySet.FOR_OPPORTUNITIES) &&
        Objects.equals(this.FOR_PROJECTS, activitySet.FOR_PROJECTS) &&
        Objects.equals(this.FOR_LEADS, activitySet.FOR_LEADS) &&
        Objects.equals(this.OWNER_USER_ID, activitySet.OWNER_USER_ID) &&
        Objects.equals(this.ACTIVITIES, activitySet.ACTIVITIES);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ACTIVITYSET_ID, NAME, FOR_CONTACTS, FOR_ORGANISATIONS, FOR_OPPORTUNITIES, FOR_PROJECTS, FOR_LEADS, OWNER_USER_ID, ACTIVITIES);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivitySet {\n");
    
    sb.append("    ACTIVITYSET_ID: ").append(toIndentedString(ACTIVITYSET_ID)).append("\n");
    sb.append("    NAME: ").append(toIndentedString(NAME)).append("\n");
    sb.append("    FOR_CONTACTS: ").append(toIndentedString(FOR_CONTACTS)).append("\n");
    sb.append("    FOR_ORGANISATIONS: ").append(toIndentedString(FOR_ORGANISATIONS)).append("\n");
    sb.append("    FOR_OPPORTUNITIES: ").append(toIndentedString(FOR_OPPORTUNITIES)).append("\n");
    sb.append("    FOR_PROJECTS: ").append(toIndentedString(FOR_PROJECTS)).append("\n");
    sb.append("    FOR_LEADS: ").append(toIndentedString(FOR_LEADS)).append("\n");
    sb.append("    OWNER_USER_ID: ").append(toIndentedString(OWNER_USER_ID)).append("\n");
    sb.append("    ACTIVITIES: ").append(toIndentedString(ACTIVITIES)).append("\n");
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

