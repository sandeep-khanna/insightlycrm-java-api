package com.insightly.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Organisation
 */
@JacksonXmlRootElement(localName = "Organisation")
@XmlRootElement(name = "Organisation")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@ToString(includeFieldNames =false,
			of = {"id", "name"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORGANISATION", indexes = { @Index(name = "idx_organisation_NAME", columnList = "NAME", unique = true) })
public class Organisation implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@JsonProperty("ORGANISATION_ID")
	@JacksonXmlProperty(localName = "ORGANISATION_ID")
	@XmlElement(name = "ORGANISATION_ID")
	@Id
	@Column(name = "ID")
	@Builder.Default
	private Long id = null;

	@JsonProperty("ORGANISATION_NAME")
	@JacksonXmlProperty(localName = "ORGANISATION_NAME")
	@XmlElement(name = "ORGANISATION_NAME")
	@NonNull
	@Column(name = "NAME")
	@Builder.Default
	private String name = null;

	@JsonProperty("BACKGROUND")
	@JacksonXmlProperty(localName = "BACKGROUND")
	@XmlElement(name = "BACKGROUND")
	@Lob
	@Column(name = "DESCRIPTION")
	@Builder.Default
	private String description = null;

	@JsonProperty("CUSTOMFIELDS")
	@JacksonXmlProperty(localName = "CUSTOMFIELDS")
	@XmlElement(name = "CUSTOMFIELDS")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ORGANISATION_CUSTOM_FIELDS", 
				joinColumns = {@JoinColumn(name = "ORGANISATION_ID", referencedColumnName = "ID") }, 
				inverseJoinColumns = {@JoinColumn(name = "CUSTOM_FIELD_ID", referencedColumnName = "ID", unique = true) })
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
	
	@JsonProperty("ADDRESSES")
	@JacksonXmlProperty(localName = "ADDRESSES")
	@XmlElement(name = "ADDRESSES")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ORGANISATION_ADDRESSES", 
				joinColumns = {@JoinColumn(name = "ORGANISATION_ID", referencedColumnName = "ID") }, 
				inverseJoinColumns = {@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID", unique = true) })
	@Builder.Default
	private List<Address> addresses = new ArrayList<Address>();
	
	public List<Address> getAddresses() {
		
		if(CollectionUtils.isEmpty(addresses)) {
			addresses = new ArrayList<Address>();
		}
		return addresses;
	}
	
	@JsonIgnore
	public Optional<Address> setAddress(Address newAddress) {
		// Set a Custom Field only if a 'matching' one doesn't already exist
		Predicate<Address> addressExistsHavingSameType = a -> a.getType().equals(newAddress.getType());
		Predicate<Address> addressExistsHavingDifferentValue = a -> a.getType().equals(newAddress.getType())
																			&&
																			!(StringUtils.equalsIgnoreCase(a.getStreet(), newAddress.getStreet())
																					&& 
																					StringUtils.equalsIgnoreCase(a.getCity(), newAddress.getCity())
																					&& 
																					StringUtils.equalsIgnoreCase(a.getState(), newAddress.getState())
																					&& 
																					StringUtils.equalsIgnoreCase(a.getPostalCode(), newAddress.getPostalCode())
																					&& 
																					StringUtils.equalsIgnoreCase(a.getCountry(), newAddress.getCountry()));

		Optional<Address> existingAddress = getAddresses().stream().filter(addressExistsHavingSameType).findFirst();
		Optional<Address> existingAddressHavingDifferentValue = getAddresses().stream().filter(addressExistsHavingDifferentValue).findFirst();
		
		if(!existingAddress.isPresent()) {
			getAddresses().add(newAddress);
			return Optional.of(newAddress);
		} else if(existingAddressHavingDifferentValue.isPresent()) {			
			Address updatedAddress = existingAddressHavingDifferentValue.get();
			updatedAddress.setStreet(newAddress.getStreet());
			updatedAddress.setCity(newAddress.getCity());
			updatedAddress.setState(newAddress.getState());
			updatedAddress.setPostalCode(newAddress.getPostalCode());
			updatedAddress.setCountry(newAddress.getCountry());
			return Optional.of(updatedAddress);
		}
		return Optional.ofNullable(null);
	}
	
	@JsonIgnore
	public Optional<Address> getBillingAddress() {

		if(CollectionUtils.isEmpty(addresses)) {
			return Optional.empty();
		}
		return addresses.stream()
						.filter(address -> AddressTypeID.BILLING_ADDRESS.equals(address.getType().getId()))
						.findFirst();
	}
	
	@JsonIgnore
	public Optional<Address> setBillingAddress(String street, String city, String state, String postalCode, String country) {
		Address address = null;
		Predicate<Address> billingAddressNotTheSame = a -> {
			return !(StringUtils.equalsIgnoreCase(street, a.getStreet())
					&& 
					StringUtils.equalsIgnoreCase(city, a.getCity())
					&& 
					StringUtils.equalsIgnoreCase(state, a.getState())
					&& 
					StringUtils.equalsIgnoreCase(postalCode, a.getPostalCode())
					&& 
					StringUtils.equalsIgnoreCase(country, a.getCountry()));
		};
		
		if(getBillingAddress().filter(billingAddressNotTheSame).isPresent()) {
			address = getBillingAddress().get();
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setPostalCode(postalCode);
			address.setCountry(country);
		} else if(!getBillingAddress().isPresent()) {
			address = Address.builder()
								.type(AddressType.of(AddressTypeID.BILLING_ADDRESS))
								.street(street)
								.city(city)
								.state(state)
								.postalCode(postalCode)
								.country(country)
								.build();
			getAddresses().add(address);
		}
		return Optional.ofNullable(address);
	}
	
	@JsonIgnore
	public Optional<Address> getShippingAddress() {
		
		if(CollectionUtils.isEmpty(addresses)) {
			return Optional.empty();
		}
		return addresses.stream()
						.filter(address -> AddressTypeID.SHIPPING_ADDRESS.equals(address.getType().getId()))
						.findFirst();
	}
	
	@JsonIgnore
	public Optional<Address> setShippingAddress(String street, String city, String state, String postalCode, String country) {
		Address address = null;
		Predicate<Address> shippingAddressNotTheSame = a -> {
			return !(StringUtils.equalsIgnoreCase(street, a.getStreet())
					&& 
					StringUtils.equalsIgnoreCase(city, a.getCity())
					&& 
					StringUtils.equalsIgnoreCase(state, a.getState())
					&& 
					StringUtils.equalsIgnoreCase(postalCode, a.getPostalCode())
					&& 
					StringUtils.equalsIgnoreCase(country, a.getCountry()));
		};
		
		if(getShippingAddress().filter(shippingAddressNotTheSame).isPresent()) {
			address = getShippingAddress().get();
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setPostalCode(postalCode);
			address.setCountry(country);
		} else if(!getShippingAddress().isPresent()) {
			address = Address.builder()
								.type(AddressType.of(AddressTypeID.SHIPPING_ADDRESS))
								.street(street)
								.city(city)
								.state(state)
								.postalCode(postalCode)
								.country(country)
								.build();
			getAddresses().add(address);
		}
		return Optional.ofNullable(address);
	}

	@JsonProperty("CONTACTINFOS")
	@JacksonXmlProperty(localName = "CONTACTINFOS")
	@XmlElement(name = "CONTACTINFOS")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ORGANISATION_CONTACT_INFOS", 
				joinColumns = {@JoinColumn(name = "ORGANISATION_ID", referencedColumnName = "ID") }, 
				inverseJoinColumns = {@JoinColumn(name = "CONTACT_INFO_ID", referencedColumnName = "ID", unique = true) })
	@Builder.Default
	private List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();

	public List<ContactInfo> getContactInfos() {
		
		if(CollectionUtils.isEmpty(contactInfos)) {
			contactInfos = new ArrayList<ContactInfo>();
		}
		return contactInfos;
	}
	
	@JsonIgnore
	public Optional<ContactInfo> setContactInfo(ContactInfo newContactInfo) {
		// Set a ContactInfo only if a 'matching' one doesn't already exist
		Predicate<ContactInfo> contactInfoExistsHavingSameType = ci -> ci.getType().equals(newContactInfo.getType());
		Predicate<ContactInfo> contactInfoExistsHavingDifferentValue = ci -> ci.getType().equals(newContactInfo.getType())
																			&&
																			!ci.getDetail().equalsIgnoreCase(newContactInfo.getDetail());
		Predicate<ContactInfo> emailDomainDoesNotExist = ci -> ContactInfoTypeID.EMAILDOMAIN == newContactInfo.getType().getId()
																&&
																!ci.getDetail().equalsIgnoreCase(newContactInfo.getDetail());

		Optional<ContactInfo> existingContactInfo = getContactInfos().stream().filter(contactInfoExistsHavingSameType).findFirst();
		Optional<ContactInfo> existingContactInfoHavingDifferentValue = getContactInfos().stream().filter(contactInfoExistsHavingDifferentValue).findFirst();
		boolean isEmailDomain = getContactInfos().stream().allMatch(emailDomainDoesNotExist);
		
		if(!existingContactInfo.isPresent()
				|| isEmailDomain) {
			getContactInfos().add(newContactInfo);
			return Optional.of(newContactInfo);
		} else if(existingContactInfoHavingDifferentValue.isPresent()) {			
			ContactInfo updatedContactInfo = existingContactInfoHavingDifferentValue.get();
			updatedContactInfo.setDetail(newContactInfo.getDetail());
			return Optional.of(updatedContactInfo);
		}
		return Optional.ofNullable(null);
	}
	
	@JsonIgnore
	public Optional<ContactInfo> getPhone() {
		return getContactInfos().stream()
								.filter(contactInfo -> ContactInfoTypeID.PHONE.equals(contactInfo.getType().getId()))
								.findFirst();
	}
	
	@JsonIgnore
	public Optional<ContactInfo> setPhone(String phone) {
		ContactInfo contactInfo = null;
		Predicate<ContactInfo> phoneNotTheSame = ci -> !ci.getDetail().equalsIgnoreCase(phone);
		
		if(getPhone().filter(phoneNotTheSame).isPresent()) {
			contactInfo = getPhone().get();
			contactInfo.setDetail(phone);
		} else if(!getPhone().isPresent()) {
			contactInfo = ContactInfo.builder()
										.type(ContactInfoType.of(ContactInfoTypeID.PHONE))
										.detail(phone)
										.build();
			getContactInfos().add(contactInfo);
		}
		return Optional.ofNullable(contactInfo);
	}
	
	@JsonIgnore
	public Optional<ContactInfo> getWebsite() {
		return getContactInfos().stream()
								.filter(contactInfo -> ContactInfoTypeID.WEBSITE.equals(contactInfo.getType().getId()))
								.findFirst();
	}
	
	@JsonIgnore
	public Optional<ContactInfo> setWebsite(String websiteUrl) {
		ContactInfo contactInfo = null;
		Predicate<ContactInfo> websiteUrlNotTheSame = ci -> !ci.getDetail().equalsIgnoreCase(websiteUrl);
		
		if(getWebsite().filter(websiteUrlNotTheSame).isPresent()) {
			contactInfo = getWebsite().get();
			contactInfo.setDetail(websiteUrl);
		} else if(!getWebsite().isPresent()) {
			contactInfo = ContactInfo.builder()
										.type(ContactInfoType.of(ContactInfoTypeID.WEBSITE))
										.detail(websiteUrl)
										.build();
			getContactInfos().add(contactInfo);
		}
		return Optional.ofNullable(contactInfo);
	}
	
	@JsonIgnore
	public List<ContactInfo> getEmailDomains() {
		return getContactInfos().stream()
								.filter(contactInfo -> ContactInfoTypeID.EMAILDOMAIN.equals(contactInfo.getType().getId()))
								.collect(Collectors.toList());
	}
	
	@JsonIgnore
	public Optional<ContactInfo> setEmailDomain(String emailDomain) {
		ContactInfo contactInfo = null;
		Predicate<ContactInfo> emailDomainDoesNotExist = ci -> !ci.getDetail().equalsIgnoreCase(emailDomain);
		
		if(getEmailDomains().stream().allMatch(emailDomainDoesNotExist)) {
			contactInfo = ContactInfo.builder()
										.type(ContactInfoType.of(ContactInfoTypeID.EMAILDOMAIN))
										.detail(emailDomain)
										.build();
			getContactInfos().add(contactInfo);
		}
		return Optional.ofNullable(contactInfo);
	}
}