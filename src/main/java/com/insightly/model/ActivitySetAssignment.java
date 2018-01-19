package com.insightly.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
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
 * ActivitySetAssignment
 */
@JacksonXmlRootElement(localName = "ActivitySetAssignment")
@XmlRootElement(name = "ActivitySetAssignment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivitySetAssignment implements Serializable {

	private static final long serialVersionUID = 1L;

  @JsonProperty("ACTIVITYSET_ID")
  @JacksonXmlProperty(localName = "ACTIVITYSET_ID")
  @XmlElement(name = "ACTIVITYSET_ID")
  private Long ACTIVITYSET_ID = null;

  @JsonProperty("START_DATE")
  @JacksonXmlProperty(localName = "START_DATE")
  @XmlElement(name = "START_DATE")
  private OffsetDateTime START_DATE = null;

  @JsonProperty("END_DATE")
  @JacksonXmlProperty(localName = "END_DATE")
  @XmlElement(name = "END_DATE")
  private OffsetDateTime END_DATE = null;

  @JsonProperty("ACTIVITY_ASSIGNMENTS")
  @JacksonXmlProperty(localName = "ACTIVITY_ASSIGNMENTS")
  @XmlElement(name = "ACTIVITY_ASSIGNMENTS")
  private List<ActivityAssignment> ACTIVITY_ASSIGNMENTS = null;

  public ActivitySetAssignment ACTIVITYSET_ID(Long ACTIVITYSET_ID) {
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

  public ActivitySetAssignment START_DATE(OffsetDateTime START_DATE) {
    this.START_DATE = START_DATE;
    return this;
  }

   /**
   * Get START_DATE
   * @return START_DATE
  **/
  
  public OffsetDateTime getSTARTDATE() {
    return START_DATE;
  }

  public void setSTARTDATE(OffsetDateTime START_DATE) {
    this.START_DATE = START_DATE;
  }

  public ActivitySetAssignment END_DATE(OffsetDateTime END_DATE) {
    this.END_DATE = END_DATE;
    return this;
  }

   /**
   * Get END_DATE
   * @return END_DATE
  **/
  
  public OffsetDateTime getENDDATE() {
    return END_DATE;
  }

  public void setENDDATE(OffsetDateTime END_DATE) {
    this.END_DATE = END_DATE;
  }

  public ActivitySetAssignment ACTIVITY_ASSIGNMENTS(List<ActivityAssignment> ACTIVITY_ASSIGNMENTS) {
    this.ACTIVITY_ASSIGNMENTS = ACTIVITY_ASSIGNMENTS;
    return this;
  }

  public ActivitySetAssignment addACTIVITYASSIGNMENTSItem(ActivityAssignment ACTIVITY_ASSIGNMENTSItem) {
    if (this.ACTIVITY_ASSIGNMENTS == null) {
      this.ACTIVITY_ASSIGNMENTS = new ArrayList<ActivityAssignment>();
    }
    this.ACTIVITY_ASSIGNMENTS.add(ACTIVITY_ASSIGNMENTSItem);
    return this;
  }

   /**
   * Get ACTIVITY_ASSIGNMENTS
   * @return ACTIVITY_ASSIGNMENTS
  **/
  
  public List<ActivityAssignment> getACTIVITYASSIGNMENTS() {
    return ACTIVITY_ASSIGNMENTS;
  }

  public void setACTIVITYASSIGNMENTS(List<ActivityAssignment> ACTIVITY_ASSIGNMENTS) {
    this.ACTIVITY_ASSIGNMENTS = ACTIVITY_ASSIGNMENTS;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivitySetAssignment apIActivitySetAssignment = (ActivitySetAssignment) o;
    return Objects.equals(this.ACTIVITYSET_ID, apIActivitySetAssignment.ACTIVITYSET_ID) &&
        Objects.equals(this.START_DATE, apIActivitySetAssignment.START_DATE) &&
        Objects.equals(this.END_DATE, apIActivitySetAssignment.END_DATE) &&
        Objects.equals(this.ACTIVITY_ASSIGNMENTS, apIActivitySetAssignment.ACTIVITY_ASSIGNMENTS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ACTIVITYSET_ID, START_DATE, END_DATE, ACTIVITY_ASSIGNMENTS);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivitySetAssignment {\n");
    
    sb.append("    ACTIVITYSET_ID: ").append(toIndentedString(ACTIVITYSET_ID)).append("\n");
    sb.append("    START_DATE: ").append(toIndentedString(START_DATE)).append("\n");
    sb.append("    END_DATE: ").append(toIndentedString(END_DATE)).append("\n");
    sb.append("    ACTIVITY_ASSIGNMENTS: ").append(toIndentedString(ACTIVITY_ASSIGNMENTS)).append("\n");
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