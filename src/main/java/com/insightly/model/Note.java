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
import com.insightly.model.NoteLink;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;

/**
 * Note
 */
@JacksonXmlRootElement(localName = "Note")
@XmlRootElement(name = "Note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("NOTE_ID")
  @JacksonXmlProperty(localName = "NOTE_ID")
  @XmlElement(name = "NOTE_ID")
  private Long NOTE_ID = null;

  @JsonProperty("TITLE")
  @JacksonXmlProperty(localName = "TITLE")
  @XmlElement(name = "TITLE")
  private String TITLE = null;

  @JsonProperty("BODY")
  @JacksonXmlProperty(localName = "BODY")
  @XmlElement(name = "BODY")
  private String BODY = null;

  @JsonProperty("LINK_SUBJECT_ID")
  @JacksonXmlProperty(localName = "LINK_SUBJECT_ID")
  @XmlElement(name = "LINK_SUBJECT_ID")
  private Long LINK_SUBJECT_ID = null;

  @JsonProperty("LINK_SUBJECT_TYPE")
  @JacksonXmlProperty(localName = "LINK_SUBJECT_TYPE")
  @XmlElement(name = "LINK_SUBJECT_TYPE")
  private String LINK_SUBJECT_TYPE = null;

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

  @JsonProperty("NOTELINKS")
  @JacksonXmlProperty(localName = "NOTELINKS")
  @XmlElement(name = "NOTELINKS")
  private List<NoteLink> NOTELINKS = null;

  @JsonProperty("CAN_EDIT")
  @JacksonXmlProperty(localName = "CAN_EDIT")
  @XmlElement(name = "CAN_EDIT")
  private Boolean CAN_EDIT = null;

  @JsonProperty("CAN_DELETE")
  @JacksonXmlProperty(localName = "CAN_DELETE")
  @XmlElement(name = "CAN_DELETE")
  private Boolean CAN_DELETE = null;

  public Note NOTE_ID(Long NOTE_ID) {
    this.NOTE_ID = NOTE_ID;
    return this;
  }

   /**
   * Get NOTE_ID
   * @return NOTE_ID
  **/
  
  public Long getNOTEID() {
    return NOTE_ID;
  }

  public void setNOTEID(Long NOTE_ID) {
    this.NOTE_ID = NOTE_ID;
  }

  public Note TITLE(String TITLE) {
    this.TITLE = TITLE;
    return this;
  }

   /**
   * Get TITLE
   * @return TITLE
  **/
  
  public String getTITLE() {
    return TITLE;
  }

  public void setTITLE(String TITLE) {
    this.TITLE = TITLE;
  }

  public Note BODY(String BODY) {
    this.BODY = BODY;
    return this;
  }

   /**
   * Get BODY
   * @return BODY
  **/
  
  public String getBODY() {
    return BODY;
  }

  public void setBODY(String BODY) {
    this.BODY = BODY;
  }

  public Note LINK_SUBJECT_ID(Long LINK_SUBJECT_ID) {
    this.LINK_SUBJECT_ID = LINK_SUBJECT_ID;
    return this;
  }

   /**
   * Get LINK_SUBJECT_ID
   * @return LINK_SUBJECT_ID
  **/
  
  public Long getLINKSUBJECTID() {
    return LINK_SUBJECT_ID;
  }

  public void setLINKSUBJECTID(Long LINK_SUBJECT_ID) {
    this.LINK_SUBJECT_ID = LINK_SUBJECT_ID;
  }

  public Note LINK_SUBJECT_TYPE(String LINK_SUBJECT_TYPE) {
    this.LINK_SUBJECT_TYPE = LINK_SUBJECT_TYPE;
    return this;
  }

   /**
   * Get LINK_SUBJECT_TYPE
   * @return LINK_SUBJECT_TYPE
  **/
  
  public String getLINKSUBJECTTYPE() {
    return LINK_SUBJECT_TYPE;
  }

  public void setLINKSUBJECTTYPE(String LINK_SUBJECT_TYPE) {
    this.LINK_SUBJECT_TYPE = LINK_SUBJECT_TYPE;
  }

  public Note OWNER_USER_ID(Integer OWNER_USER_ID) {
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

  public Note DATE_CREATED_UTC(OffsetDateTime DATE_CREATED_UTC) {
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

  public Note DATE_UPDATED_UTC(OffsetDateTime DATE_UPDATED_UTC) {
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

  public Note VISIBLE_TO(String VISIBLE_TO) {
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

  public Note VISIBLE_TEAM_ID(Long VISIBLE_TEAM_ID) {
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

  public Note VISIBLE_USER_IDS(String VISIBLE_USER_IDS) {
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

  public Note NOTELINKS(List<NoteLink> NOTELINKS) {
    this.NOTELINKS = NOTELINKS;
    return this;
  }

  public Note addNOTELINKSItem(NoteLink NOTELINKSItem) {
    if (this.NOTELINKS == null) {
      this.NOTELINKS = new ArrayList<NoteLink>();
    }
    this.NOTELINKS.add(NOTELINKSItem);
    return this;
  }

   /**
   * Get NOTELINKS
   * @return NOTELINKS
  **/
  
  public List<NoteLink> getNOTELINKS() {
    return NOTELINKS;
  }

  public void setNOTELINKS(List<NoteLink> NOTELINKS) {
    this.NOTELINKS = NOTELINKS;
  }

  public Note CAN_EDIT(Boolean CAN_EDIT) {
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

  public Note CAN_DELETE(Boolean CAN_DELETE) {
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
    Note note = (Note) o;
    return Objects.equals(this.NOTE_ID, note.NOTE_ID) &&
        Objects.equals(this.TITLE, note.TITLE) &&
        Objects.equals(this.BODY, note.BODY) &&
        Objects.equals(this.LINK_SUBJECT_ID, note.LINK_SUBJECT_ID) &&
        Objects.equals(this.LINK_SUBJECT_TYPE, note.LINK_SUBJECT_TYPE) &&
        Objects.equals(this.OWNER_USER_ID, note.OWNER_USER_ID) &&
        Objects.equals(this.DATE_CREATED_UTC, note.DATE_CREATED_UTC) &&
        Objects.equals(this.DATE_UPDATED_UTC, note.DATE_UPDATED_UTC) &&
        Objects.equals(this.VISIBLE_TO, note.VISIBLE_TO) &&
        Objects.equals(this.VISIBLE_TEAM_ID, note.VISIBLE_TEAM_ID) &&
        Objects.equals(this.VISIBLE_USER_IDS, note.VISIBLE_USER_IDS) &&
        Objects.equals(this.NOTELINKS, note.NOTELINKS) &&
        Objects.equals(this.CAN_EDIT, note.CAN_EDIT) &&
        Objects.equals(this.CAN_DELETE, note.CAN_DELETE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(NOTE_ID, TITLE, BODY, LINK_SUBJECT_ID, LINK_SUBJECT_TYPE, OWNER_USER_ID, DATE_CREATED_UTC, DATE_UPDATED_UTC, VISIBLE_TO, VISIBLE_TEAM_ID, VISIBLE_USER_IDS, NOTELINKS, CAN_EDIT, CAN_DELETE);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Note {\n");
    
    sb.append("    NOTE_ID: ").append(toIndentedString(NOTE_ID)).append("\n");
    sb.append("    TITLE: ").append(toIndentedString(TITLE)).append("\n");
    sb.append("    BODY: ").append(toIndentedString(BODY)).append("\n");
    sb.append("    LINK_SUBJECT_ID: ").append(toIndentedString(LINK_SUBJECT_ID)).append("\n");
    sb.append("    LINK_SUBJECT_TYPE: ").append(toIndentedString(LINK_SUBJECT_TYPE)).append("\n");
    sb.append("    OWNER_USER_ID: ").append(toIndentedString(OWNER_USER_ID)).append("\n");
    sb.append("    DATE_CREATED_UTC: ").append(toIndentedString(DATE_CREATED_UTC)).append("\n");
    sb.append("    DATE_UPDATED_UTC: ").append(toIndentedString(DATE_UPDATED_UTC)).append("\n");
    sb.append("    VISIBLE_TO: ").append(toIndentedString(VISIBLE_TO)).append("\n");
    sb.append("    VISIBLE_TEAM_ID: ").append(toIndentedString(VISIBLE_TEAM_ID)).append("\n");
    sb.append("    VISIBLE_USER_IDS: ").append(toIndentedString(VISIBLE_USER_IDS)).append("\n");
    sb.append("    NOTELINKS: ").append(toIndentedString(NOTELINKS)).append("\n");
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

