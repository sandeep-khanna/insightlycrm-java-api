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
import com.insightly.model.Address;
import com.insightly.model.ContactDate;
import com.insightly.model.ContactInfo;
import com.insightly.model.ContactLink;
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
 * Contact
 */
@JacksonXmlRootElement(localName = "Contact")
@XmlRootElement(name = "Contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("CONTACT_ID")
  @JacksonXmlProperty(localName = "CONTACT_ID")
  @XmlElement(name = "CONTACT_ID")
  private Long CONTACT_ID = null;

  @JsonProperty("SALUTATION")
  @JacksonXmlProperty(localName = "SALUTATION")
  @XmlElement(name = "SALUTATION")
  private String SALUTATION = null;

  @JsonProperty("FIRST_NAME")
  @JacksonXmlProperty(localName = "FIRST_NAME")
  @XmlElement(name = "FIRST_NAME")
  private String FIRST_NAME = null;

  @JsonProperty("LAST_NAME")
  @JacksonXmlProperty(localName = "LAST_NAME")
  @XmlElement(name = "LAST_NAME")
  private String LAST_NAME = null;

  @JsonProperty("BACKGROUND")
  @JacksonXmlProperty(localName = "BACKGROUND")
  @XmlElement(name = "BACKGROUND")
  private String BACKGROUND = null;

  @JsonProperty("IMAGE_URL")
  @JacksonXmlProperty(localName = "IMAGE_URL")
  @XmlElement(name = "IMAGE_URL")
  private String IMAGE_URL = null;

  @JsonProperty("DEFAULT_LINKED_ORGANISATION")
  @JacksonXmlProperty(localName = "DEFAULT_LINKED_ORGANISATION")
  @XmlElement(name = "DEFAULT_LINKED_ORGANISATION")
  private Long DEFAULT_LINKED_ORGANISATION = null;

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

  @JsonProperty("ADDRESSES")
  @JacksonXmlProperty(localName = "ADDRESSES")
  @XmlElement(name = "ADDRESSES")
  private List<Address> ADDRESSES = null;

  @JsonProperty("CONTACTINFOS")
  @JacksonXmlProperty(localName = "CONTACTINFOS")
  @XmlElement(name = "CONTACTINFOS")
  private List<ContactInfo> CONTACTINFOS = null;

  @JsonProperty("DATES")
  @JacksonXmlProperty(localName = "DATES")
  @XmlElement(name = "DATES")
  private List<ContactDate> DATES = null;

  @JsonProperty("TAGS")
  @JacksonXmlProperty(localName = "TAGS")
  @XmlElement(name = "TAGS")
  private List<Tag> TAGS = null;

  @JsonProperty("LINKS")
  @JacksonXmlProperty(localName = "LINKS")
  @XmlElement(name = "LINKS")
  private List<Link> LINKS = null;

  @JsonProperty("CONTACTLINKS")
  @JacksonXmlProperty(localName = "CONTACTLINKS")
  @XmlElement(name = "CONTACTLINKS")
  private List<ContactLink> CONTACTLINKS = null;

  @JsonProperty("CAN_EDIT")
  @JacksonXmlProperty(localName = "CAN_EDIT")
  @XmlElement(name = "CAN_EDIT")
  private Boolean CAN_EDIT = null;

  @JsonProperty("CAN_DELETE")
  @JacksonXmlProperty(localName = "CAN_DELETE")
  @XmlElement(name = "CAN_DELETE")
  private Boolean CAN_DELETE = null;

  @JsonProperty("SOCIAL_LINKEDIN")
  @JacksonXmlProperty(localName = "SOCIAL_LINKEDIN")
  @XmlElement(name = "SOCIAL_LINKEDIN")
  private String SOCIAL_LINKEDIN = null;

  @JsonProperty("SOCIAL_FACEBOOK")
  @JacksonXmlProperty(localName = "SOCIAL_FACEBOOK")
  @XmlElement(name = "SOCIAL_FACEBOOK")
  private String SOCIAL_FACEBOOK = null;

  @JsonProperty("SOCIAL_TWITTER")
  @JacksonXmlProperty(localName = "SOCIAL_TWITTER")
  @XmlElement(name = "SOCIAL_TWITTER")
  private String SOCIAL_TWITTER = null;

  @JsonProperty("ASSISTANT_NAME")
  @JacksonXmlProperty(localName = "ASSISTANT_NAME")
  @XmlElement(name = "ASSISTANT_NAME")
  private String ASSISTANT_NAME = null;

  public Contact CONTACT_ID(Long CONTACT_ID) {
    this.CONTACT_ID = CONTACT_ID;
    return this;
  }

   /**
   * Get CONTACT_ID
   * @return CONTACT_ID
  **/
  
  public Long getCONTACTID() {
    return CONTACT_ID;
  }

  public void setCONTACTID(Long CONTACT_ID) {
    this.CONTACT_ID = CONTACT_ID;
  }

  public Contact SALUTATION(String SALUTATION) {
    this.SALUTATION = SALUTATION;
    return this;
  }

   /**
   * Get SALUTATION
   * @return SALUTATION
  **/
  
  public String getSALUTATION() {
    return SALUTATION;
  }

  public void setSALUTATION(String SALUTATION) {
    this.SALUTATION = SALUTATION;
  }

  public Contact FIRST_NAME(String FIRST_NAME) {
    this.FIRST_NAME = FIRST_NAME;
    return this;
  }

   /**
   * Get FIRST_NAME
   * @return FIRST_NAME
  **/
  
  public String getFIRSTNAME() {
    return FIRST_NAME;
  }

  public void setFIRSTNAME(String FIRST_NAME) {
    this.FIRST_NAME = FIRST_NAME;
  }

  public Contact LAST_NAME(String LAST_NAME) {
    this.LAST_NAME = LAST_NAME;
    return this;
  }

   /**
   * Get LAST_NAME
   * @return LAST_NAME
  **/
  
  public String getLASTNAME() {
    return LAST_NAME;
  }

  public void setLASTNAME(String LAST_NAME) {
    this.LAST_NAME = LAST_NAME;
  }

  public Contact BACKGROUND(String BACKGROUND) {
    this.BACKGROUND = BACKGROUND;
    return this;
  }

   /**
   * Get BACKGROUND
   * @return BACKGROUND
  **/
  
  public String getBACKGROUND() {
    return BACKGROUND;
  }

  public void setBACKGROUND(String BACKGROUND) {
    this.BACKGROUND = BACKGROUND;
  }

  public Contact IMAGE_URL(String IMAGE_URL) {
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

  public Contact DEFAULT_LINKED_ORGANISATION(Long DEFAULT_LINKED_ORGANISATION) {
    this.DEFAULT_LINKED_ORGANISATION = DEFAULT_LINKED_ORGANISATION;
    return this;
  }

   /**
   * Get DEFAULT_LINKED_ORGANISATION
   * @return DEFAULT_LINKED_ORGANISATION
  **/
  
  public Long getDEFAULTLINKEDORGANISATION() {
    return DEFAULT_LINKED_ORGANISATION;
  }

  public void setDEFAULTLINKEDORGANISATION(Long DEFAULT_LINKED_ORGANISATION) {
    this.DEFAULT_LINKED_ORGANISATION = DEFAULT_LINKED_ORGANISATION;
  }

  public Contact OWNER_USER_ID(Integer OWNER_USER_ID) {
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

  public Contact DATE_CREATED_UTC(OffsetDateTime DATE_CREATED_UTC) {
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

  public Contact DATE_UPDATED_UTC(OffsetDateTime DATE_UPDATED_UTC) {
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

  public Contact VISIBLE_TO(String VISIBLE_TO) {
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

  public Contact VISIBLE_TEAM_ID(Long VISIBLE_TEAM_ID) {
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

  public Contact VISIBLE_USER_IDS(String VISIBLE_USER_IDS) {
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

  public Contact CUSTOMFIELDS(List<CustomField> CUSTOMFIELDS) {
    this.CUSTOMFIELDS = CUSTOMFIELDS;
    return this;
  }

  public Contact addCUSTOMFIELDSItem(CustomField CUSTOMFIELDSItem) {
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

  public Contact ADDRESSES(List<Address> ADDRESSES) {
    this.ADDRESSES = ADDRESSES;
    return this;
  }

  public Contact addADDRESSESItem(Address ADDRESSESItem) {
    if (this.ADDRESSES == null) {
      this.ADDRESSES = new ArrayList<Address>();
    }
    this.ADDRESSES.add(ADDRESSESItem);
    return this;
  }

   /**
   * Get ADDRESSES
   * @return ADDRESSES
  **/
  
  public List<Address> getADDRESSES() {
    return ADDRESSES;
  }

  public void setADDRESSES(List<Address> ADDRESSES) {
    this.ADDRESSES = ADDRESSES;
  }

  public Contact CONTACTINFOS(List<ContactInfo> CONTACTINFOS) {
    this.CONTACTINFOS = CONTACTINFOS;
    return this;
  }

  public Contact addCONTACTINFOSItem(ContactInfo CONTACTINFOSItem) {
    if (this.CONTACTINFOS == null) {
      this.CONTACTINFOS = new ArrayList<ContactInfo>();
    }
    this.CONTACTINFOS.add(CONTACTINFOSItem);
    return this;
  }

   /**
   * Get CONTACTINFOS
   * @return CONTACTINFOS
  **/
  
  public List<ContactInfo> getCONTACTINFOS() {
    return CONTACTINFOS;
  }

  public void setCONTACTINFOS(List<ContactInfo> CONTACTINFOS) {
    this.CONTACTINFOS = CONTACTINFOS;
  }

  public Contact DATES(List<ContactDate> DATES) {
    this.DATES = DATES;
    return this;
  }

  public Contact addDATESItem(ContactDate DATESItem) {
    if (this.DATES == null) {
      this.DATES = new ArrayList<ContactDate>();
    }
    this.DATES.add(DATESItem);
    return this;
  }

   /**
   * Get DATES
   * @return DATES
  **/
  
  public List<ContactDate> getDATES() {
    return DATES;
  }

  public void setDATES(List<ContactDate> DATES) {
    this.DATES = DATES;
  }

  public Contact TAGS(List<Tag> TAGS) {
    this.TAGS = TAGS;
    return this;
  }

  public Contact addTAGSItem(Tag TAGSItem) {
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

  public Contact LINKS(List<Link> LINKS) {
    this.LINKS = LINKS;
    return this;
  }

  public Contact addLINKSItem(Link LINKSItem) {
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

  public Contact CONTACTLINKS(List<ContactLink> CONTACTLINKS) {
    this.CONTACTLINKS = CONTACTLINKS;
    return this;
  }

  public Contact addCONTACTLINKSItem(ContactLink CONTACTLINKSItem) {
    if (this.CONTACTLINKS == null) {
      this.CONTACTLINKS = new ArrayList<ContactLink>();
    }
    this.CONTACTLINKS.add(CONTACTLINKSItem);
    return this;
  }

   /**
   * Get CONTACTLINKS
   * @return CONTACTLINKS
  **/
  
  public List<ContactLink> getCONTACTLINKS() {
    return CONTACTLINKS;
  }

  public void setCONTACTLINKS(List<ContactLink> CONTACTLINKS) {
    this.CONTACTLINKS = CONTACTLINKS;
  }

  public Contact CAN_EDIT(Boolean CAN_EDIT) {
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

  public Contact CAN_DELETE(Boolean CAN_DELETE) {
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

  public Contact SOCIAL_LINKEDIN(String SOCIAL_LINKEDIN) {
    this.SOCIAL_LINKEDIN = SOCIAL_LINKEDIN;
    return this;
  }

   /**
   * Get SOCIAL_LINKEDIN
   * @return SOCIAL_LINKEDIN
  **/
  
  public String getSOCIALLINKEDIN() {
    return SOCIAL_LINKEDIN;
  }

  public void setSOCIALLINKEDIN(String SOCIAL_LINKEDIN) {
    this.SOCIAL_LINKEDIN = SOCIAL_LINKEDIN;
  }

  public Contact SOCIAL_FACEBOOK(String SOCIAL_FACEBOOK) {
    this.SOCIAL_FACEBOOK = SOCIAL_FACEBOOK;
    return this;
  }

   /**
   * Get SOCIAL_FACEBOOK
   * @return SOCIAL_FACEBOOK
  **/
  
  public String getSOCIALFACEBOOK() {
    return SOCIAL_FACEBOOK;
  }

  public void setSOCIALFACEBOOK(String SOCIAL_FACEBOOK) {
    this.SOCIAL_FACEBOOK = SOCIAL_FACEBOOK;
  }

  public Contact SOCIAL_TWITTER(String SOCIAL_TWITTER) {
    this.SOCIAL_TWITTER = SOCIAL_TWITTER;
    return this;
  }

   /**
   * Get SOCIAL_TWITTER
   * @return SOCIAL_TWITTER
  **/
  
  public String getSOCIALTWITTER() {
    return SOCIAL_TWITTER;
  }

  public void setSOCIALTWITTER(String SOCIAL_TWITTER) {
    this.SOCIAL_TWITTER = SOCIAL_TWITTER;
  }

  public Contact ASSISTANT_NAME(String ASSISTANT_NAME) {
    this.ASSISTANT_NAME = ASSISTANT_NAME;
    return this;
  }

   /**
   * Get ASSISTANT_NAME
   * @return ASSISTANT_NAME
  **/
  
  public String getASSISTANTNAME() {
    return ASSISTANT_NAME;
  }

  public void setASSISTANTNAME(String ASSISTANT_NAME) {
    this.ASSISTANT_NAME = ASSISTANT_NAME;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.CONTACT_ID, contact.CONTACT_ID) &&
        Objects.equals(this.SALUTATION, contact.SALUTATION) &&
        Objects.equals(this.FIRST_NAME, contact.FIRST_NAME) &&
        Objects.equals(this.LAST_NAME, contact.LAST_NAME) &&
        Objects.equals(this.BACKGROUND, contact.BACKGROUND) &&
        Objects.equals(this.IMAGE_URL, contact.IMAGE_URL) &&
        Objects.equals(this.DEFAULT_LINKED_ORGANISATION, contact.DEFAULT_LINKED_ORGANISATION) &&
        Objects.equals(this.OWNER_USER_ID, contact.OWNER_USER_ID) &&
        Objects.equals(this.DATE_CREATED_UTC, contact.DATE_CREATED_UTC) &&
        Objects.equals(this.DATE_UPDATED_UTC, contact.DATE_UPDATED_UTC) &&
        Objects.equals(this.VISIBLE_TO, contact.VISIBLE_TO) &&
        Objects.equals(this.VISIBLE_TEAM_ID, contact.VISIBLE_TEAM_ID) &&
        Objects.equals(this.VISIBLE_USER_IDS, contact.VISIBLE_USER_IDS) &&
        Objects.equals(this.CUSTOMFIELDS, contact.CUSTOMFIELDS) &&
        Objects.equals(this.ADDRESSES, contact.ADDRESSES) &&
        Objects.equals(this.CONTACTINFOS, contact.CONTACTINFOS) &&
        Objects.equals(this.DATES, contact.DATES) &&
        Objects.equals(this.TAGS, contact.TAGS) &&
        Objects.equals(this.LINKS, contact.LINKS) &&
        Objects.equals(this.CONTACTLINKS, contact.CONTACTLINKS) &&
        Objects.equals(this.CAN_EDIT, contact.CAN_EDIT) &&
        Objects.equals(this.CAN_DELETE, contact.CAN_DELETE) &&
        Objects.equals(this.SOCIAL_LINKEDIN, contact.SOCIAL_LINKEDIN) &&
        Objects.equals(this.SOCIAL_FACEBOOK, contact.SOCIAL_FACEBOOK) &&
        Objects.equals(this.SOCIAL_TWITTER, contact.SOCIAL_TWITTER) &&
        Objects.equals(this.ASSISTANT_NAME, contact.ASSISTANT_NAME);
  }

  @Override
  public int hashCode() {
    return Objects.hash(CONTACT_ID, SALUTATION, FIRST_NAME, LAST_NAME, BACKGROUND, IMAGE_URL, DEFAULT_LINKED_ORGANISATION, OWNER_USER_ID, DATE_CREATED_UTC, DATE_UPDATED_UTC, VISIBLE_TO, VISIBLE_TEAM_ID, VISIBLE_USER_IDS, CUSTOMFIELDS, ADDRESSES, CONTACTINFOS, DATES, TAGS, LINKS, CONTACTLINKS, CAN_EDIT, CAN_DELETE, SOCIAL_LINKEDIN, SOCIAL_FACEBOOK, SOCIAL_TWITTER, ASSISTANT_NAME);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    
    sb.append("    CONTACT_ID: ").append(toIndentedString(CONTACT_ID)).append("\n");
    sb.append("    SALUTATION: ").append(toIndentedString(SALUTATION)).append("\n");
    sb.append("    FIRST_NAME: ").append(toIndentedString(FIRST_NAME)).append("\n");
    sb.append("    LAST_NAME: ").append(toIndentedString(LAST_NAME)).append("\n");
    sb.append("    BACKGROUND: ").append(toIndentedString(BACKGROUND)).append("\n");
    sb.append("    IMAGE_URL: ").append(toIndentedString(IMAGE_URL)).append("\n");
    sb.append("    DEFAULT_LINKED_ORGANISATION: ").append(toIndentedString(DEFAULT_LINKED_ORGANISATION)).append("\n");
    sb.append("    OWNER_USER_ID: ").append(toIndentedString(OWNER_USER_ID)).append("\n");
    sb.append("    DATE_CREATED_UTC: ").append(toIndentedString(DATE_CREATED_UTC)).append("\n");
    sb.append("    DATE_UPDATED_UTC: ").append(toIndentedString(DATE_UPDATED_UTC)).append("\n");
    sb.append("    VISIBLE_TO: ").append(toIndentedString(VISIBLE_TO)).append("\n");
    sb.append("    VISIBLE_TEAM_ID: ").append(toIndentedString(VISIBLE_TEAM_ID)).append("\n");
    sb.append("    VISIBLE_USER_IDS: ").append(toIndentedString(VISIBLE_USER_IDS)).append("\n");
    sb.append("    CUSTOMFIELDS: ").append(toIndentedString(CUSTOMFIELDS)).append("\n");
    sb.append("    ADDRESSES: ").append(toIndentedString(ADDRESSES)).append("\n");
    sb.append("    CONTACTINFOS: ").append(toIndentedString(CONTACTINFOS)).append("\n");
    sb.append("    DATES: ").append(toIndentedString(DATES)).append("\n");
    sb.append("    TAGS: ").append(toIndentedString(TAGS)).append("\n");
    sb.append("    LINKS: ").append(toIndentedString(LINKS)).append("\n");
    sb.append("    CONTACTLINKS: ").append(toIndentedString(CONTACTLINKS)).append("\n");
    sb.append("    CAN_EDIT: ").append(toIndentedString(CAN_EDIT)).append("\n");
    sb.append("    CAN_DELETE: ").append(toIndentedString(CAN_DELETE)).append("\n");
    sb.append("    SOCIAL_LINKEDIN: ").append(toIndentedString(SOCIAL_LINKEDIN)).append("\n");
    sb.append("    SOCIAL_FACEBOOK: ").append(toIndentedString(SOCIAL_FACEBOOK)).append("\n");
    sb.append("    SOCIAL_TWITTER: ").append(toIndentedString(SOCIAL_TWITTER)).append("\n");
    sb.append("    ASSISTANT_NAME: ").append(toIndentedString(ASSISTANT_NAME)).append("\n");
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
