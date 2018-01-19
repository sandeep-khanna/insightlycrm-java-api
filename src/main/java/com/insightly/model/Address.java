package com.insightly.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.insightly.etl.util.AddressTypeDeserializer;
import com.insightly.etl.util.AddressTypeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Address
 */
@JacksonXmlRootElement(localName = "Address")
@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@ToString(includeFieldNames = false,
		of = {"id", "type", "street", "city", "state", "country"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("ADDRESS_ID")
	@JacksonXmlProperty(localName = "ADDRESS_ID")
	@XmlElement(name = "ADDRESS_ID")
	@Id
	@Column(name = "ID")
	@Builder.Default
	private Long id = null;
	
	@JsonProperty("ADDRESS_TYPE")
	@JacksonXmlProperty(localName = "ADDRESS_TYPE")
	@JsonDeserialize(using = AddressTypeDeserializer.class)
	@JsonSerialize(using = AddressTypeSerializer.class)
	@XmlElement(name = "ADDRESS_TYPE")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns({
			@JoinColumn(name = "ADDRESS_TYPE_ID", referencedColumnName = "ID", nullable = false) })
	@Builder.Default
	private AddressType type = AddressType.of(AddressTypeID.SHIPPING_ADDRESS);

	@JsonProperty("STREET")
	@JacksonXmlProperty(localName = "STREET")
	@XmlElement(name = "STREET")
	@Column(name = "STREET")
	@Builder.Default
	private String street = null;

	@JsonProperty("CITY")
	@JacksonXmlProperty(localName = "CITY")
	@XmlElement(name = "CITY")
	@Column(name = "CITY")
	@Builder.Default
	private String city = null;

	@JsonProperty("STATE")
	@JacksonXmlProperty(localName = "STATE")
	@XmlElement(name = "STATE")
	@Column(name = "STATE")
	@Builder.Default
	private String state = null;

	@JsonProperty("POSTCODE")
	@JacksonXmlProperty(localName = "POSTCODE")
	@XmlElement(name = "POSTCODE")
	@Column(name = "POSTALCODE")
	@Builder.Default
	private String postalCode = null;

	@JsonProperty("COUNTRY")
	@JacksonXmlProperty(localName = "COUNTRY")
	@XmlElement(name = "COUNTRY")
	@Column(name = "COUNTRY")
	@Builder.Default
	private String country = null;
}