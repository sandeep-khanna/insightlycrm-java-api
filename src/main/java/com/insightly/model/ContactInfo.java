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
import com.insightly.etl.util.ContactInfoTypeDeserializer;
import com.insightly.etl.util.ContactInfoTypeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ContactInfo
 */
@JacksonXmlRootElement(localName = "ContactInfo")
@XmlRootElement(name = "ContactInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@ToString(includeFieldNames = false,
		of = {"type", "detail"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("CONTACT_INFO_ID")
	@JacksonXmlProperty(localName = "CONTACT_INFO_ID")
	@XmlElement(name = "CONTACT_INFO_ID")
	@Id
	@Column(name = "ID")
	@Builder.Default
	private Long id = null;
	
	@JsonProperty("TYPE")
	@JacksonXmlProperty(localName = "TYPE")
	@JsonDeserialize(using = ContactInfoTypeDeserializer.class)
	@JsonSerialize(using = ContactInfoTypeSerializer.class)
	@XmlElement(name = "TYPE")
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumns({
			@JoinColumn(name = "CONTACT_INFO_TYPE_ID", referencedColumnName = "ID", nullable = false) })
	@Builder.Default
	private ContactInfoType type = null;

	@JsonProperty("DETAIL")
	@JacksonXmlProperty(localName = "DETAIL")
	@XmlElement(name = "DETAIL")
	@Column(name = "DETAIL", nullable = false)
	@NonNull
	@Builder.Default
	private String detail = null;
}