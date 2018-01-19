package com.insightly.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.insightly.etl.util.CustomInstantDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Lead
 */
@JacksonXmlRootElement(localName = "Lead")
@XmlRootElement(name = "Lead")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@ToString(includeFieldNames =false,
		of = { "id", "firstName", "lastName", "organizationName", "phone", "email" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LEAD"
//	, indexes = {
//		@Index(name = "idx_KEY_FIELDS", columnList = "FIRST_NAME, LAST_NAME, ORGANIZATION_NAME, PHONE, EMAIL") }
//
// Current JPA specification does not offer a way to specify index prefix lengths.
// The above index specification exceeds the max allowable index length (3120).
//
// Sample query to manually create a table index with prefix lengths specified:  
//alter table lead add unique index idx_KEY_FIELDS (first_name(50), last_name(50), organization_name(100), phone(25), email(50));
)
public class Lead implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("LEAD_ID")
	@JacksonXmlProperty(localName = "LEAD_ID")
	@XmlElement(name = "LEAD_ID")
	@Id
	@Column(name = "ID")
	@Builder.Default
	private Long id = null;

	@JsonProperty("SALUTATION")
	@JacksonXmlProperty(localName = "SALUTATION")
	@XmlElement(name = "SALUTATION")
	@Column(name = "SALUATION")
	@Builder.Default
	private String salutation = null;

	@JsonProperty("TITLE")
	@JacksonXmlProperty(localName = "TITLE")
	@XmlElement(name = "TITLE")
	@Column(name = "TITLE")
	@Builder.Default
	private String title = null;

	@JsonProperty("FIRST_NAME")
	@JacksonXmlProperty(localName = "FIRST_NAME")
	@XmlElement(name = "FIRST_NAME")
	@Column(name = "FIRST_NAME")
	@Builder.Default
	private String firstName = null;

	@JsonProperty("LAST_NAME")
	@JacksonXmlProperty(localName = "LAST_NAME")
	@XmlElement(name = "LAST_NAME")
	@Column(name = "LAST_NAME")
	@Builder.Default
	private String lastName = null;

	@JsonProperty("ORGANIZATION_NAME")
	@JacksonXmlProperty(localName = "ORGANIZATION_NAME")
	@XmlElement(name = "ORGANIZATION_NAME")
	@NonNull
	@Column(name = "ORGANIZATION_NAME")
	@Builder.Default
	private String organizationName = null;

	@JsonProperty("PHONE_NUMBER")
	@JacksonXmlProperty(localName = "PHONE_NUMBER")
	@XmlElement(name = "PHONE_NUMBER")
	@Column(name = "PHONE")
	@Builder.Default
	private String phone = null;

	@JsonProperty("MOBILE_PHONE_NUMBER")
	@JacksonXmlProperty(localName = "MOBILE_PHONE_NUMBER")
	@XmlElement(name = "MOBILE_PHONE_NUMBER")
	@Column(name = "MOBILE_PHONE")
	@Builder.Default
	private String mobilePhone = null;

	@JsonProperty("EMAIL_ADDRESS")
	@JacksonXmlProperty(localName = "EMAIL_ADDRESS")
	@XmlElement(name = "EMAIL_ADDRESS")
	@NonNull
	@Column(name = "EMAIL")
	@Builder.Default
	private String email = null;

	@JsonProperty("WEBSITE_URL")
	@JacksonXmlProperty(localName = "WEBSITE_URL")
	@XmlElement(name = "WEBSITE_URL")
	@Column(name = "WEBSITE_URL")
	@Builder.Default
	private String websiteUrl = null;

	@JsonProperty("OWNER_USER_ID")
	@JacksonXmlProperty(localName = "OWNER_USER_ID")
	@XmlElement(name = "OWNER_USER_ID")
	@Column(name = "OWNER_USER_ID")
	@Builder.Default
	private Integer ownerUserId = null;

	@JsonProperty("DATE_CREATED_UTC")
	@JacksonXmlProperty(localName = "DATE_CREATED_UTC")
	@JsonDeserialize(using = CustomInstantDeserializer.class)
	@XmlElement(name = "DATE_CREATED_UTC")
	@Column(name = "DATE_CREATED_UTC")
	@Builder.Default
	private Instant dateCreatedUTC = null;

	@JsonProperty("DATE_UPDATED_UTC")
	@JacksonXmlProperty(localName = "DATE_UPDATED_UTC")
	@JsonDeserialize(using = CustomInstantDeserializer.class)
	@XmlElement(name = "DATE_UPDATED_UTC")
	@Column(name = "DATE_UPDATED_UTC")
	@Builder.Default
	private Instant dateUpdatedUTC = null;

	@JsonProperty("CONVERTED")
	@JacksonXmlProperty(localName = "CONVERTED")
	@XmlElement(name = "CONVERTED")
	@Column(name = "CONVERTED")
	@Builder.Default
	private Boolean converted = null;

	@JsonProperty("CONVERTED_DATE_UTC")
	@JacksonXmlProperty(localName = "CONVERTED_DATE_UTC")
	@JsonDeserialize(using = CustomInstantDeserializer.class)
	@XmlElement(name = "CONVERTED_DATE_UTC")
	@Column(name = "DATE_CONVERTED_UTC")
	@Builder.Default
	private Instant dateConvertedUTC = null;

	@JsonProperty("CONVERTED_CONTACT_ID")
	@JacksonXmlProperty(localName = "CONVERTED_CONTACT_ID")
	@XmlElement(name = "CONVERTED_CONTACT_ID")
	@Column(name = "CONVERTED_CONTACT_ID")
	@Builder.Default
	private Long convertedContactId = null;

	@JsonProperty("CONVERTED_ORGANIZATION_ID")
	@JacksonXmlProperty(localName = "CONVERTED_ORGANIZATION_ID")
	@XmlElement(name = "CONVERTED_ORGANIZATION_ID")
	@Column(name = "CONVERTED_ORGANIZATION_ID")
	@Builder.Default
	private Long convertedOrganizationId = null;

	@JsonProperty("CONVERTED_OPPORTUNITY_ID")
	@JacksonXmlProperty(localName = "CONVERTED_OPPORTUNITY_ID")
	@XmlElement(name = "CONVERTED_OPPORTUNITY_ID")
	@Column(name = "CONVERTED_OPPORTUNITY_ID")
	@Builder.Default
	private Long convertedOpportunityId = null;

	@JsonProperty("LEAD_RATING")
	@JacksonXmlProperty(localName = "LEAD_RATING")
	@XmlElement(name = "LEAD_RATING")
	@Column(name = "LEAD_RATING")
	@Builder.Default
	private Integer leadRating = null;

	@JsonProperty("LEAD_DESCRIPTION")
	@JacksonXmlProperty(localName = "LEAD_DESCRIPTION")
	@XmlElement(name = "LEAD_DESCRIPTION")
	@Lob
	@Column(name = "DESCRIPTION")
	@Builder.Default
	private String description = null;

	@JsonProperty("CUSTOMFIELDS")
	@JacksonXmlProperty(localName = "CUSTOMFIELDS")
	@XmlElement(name = "CUSTOMFIELDS")
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organisation")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "LEAD_CUSTOM_FIELDS", joinColumns = {
			@JoinColumn(name = "LEAD_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "CUSTOM_FIELD_ID", referencedColumnName = "ID", unique = true) })
	@Builder.Default
	private List<CustomField> customFields = new ArrayList<CustomField>();
	
	public List<CustomField> getCustomFields() {
		
		if(CollectionUtils.isEmpty(customFields)) {
			customFields = new ArrayList<CustomField>();
		}
		return customFields;
	}
	
	@JsonIgnore
	public Optional<CustomField> setCustomField(CustomField newCustomField) {
		// Set a Custom Field only if a 'matching' one doesn't already exist
		Predicate<CustomField> customFieldExistsHavingSameType = cf -> cf.getType().equals(newCustomField.getType());
		Predicate<CustomField> customFieldExistsHavingDifferentValue = cf -> cf.getType().equals(newCustomField.getType())
																			&&
																			!cf.getValue().equalsIgnoreCase(newCustomField.getValue());

		Optional<CustomField> existingCustomField = getCustomFields().stream().filter(customFieldExistsHavingSameType).findFirst();
		Optional<CustomField> existingCustomFieldHavingDifferentValue = getCustomFields().stream().filter(customFieldExistsHavingDifferentValue).findFirst();
		
		if(!existingCustomField.isPresent()) {
			getCustomFields().add(newCustomField);
			return Optional.of(newCustomField);
		} else if(existingCustomFieldHavingDifferentValue.isPresent()) {			
			CustomField updatedCustomField = existingCustomFieldHavingDifferentValue.get();
			updatedCustomField.setValue(newCustomField.getValue());
			return Optional.of(updatedCustomField);
		}
		return Optional.ofNullable(null);
	}
}
