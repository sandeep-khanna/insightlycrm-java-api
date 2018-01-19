package com.insightly.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import com.insightly.etl.util.CustomFieldMetadataDeserializer;
import com.insightly.etl.util.CustomFieldMetadataSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * CustomField
 */
@JacksonXmlRootElement(localName = "CustomField")
@XmlRootElement(name = "CustomField")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@EqualsAndHashCode(exclude = "id")
@ToString(includeFieldNames = false,
		of = {"type", "value"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOM_FIELD")
public class CustomField implements Serializable {
	private static final long serialVersionUID = 1L;	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@JsonProperty("CUSTOM_FIELD_ID")
	@JacksonXmlProperty(localName = "CUSTOM_FIELD_ID")
	@JsonDeserialize(using = CustomFieldMetadataDeserializer.class)
	@JsonSerialize(using = CustomFieldMetadataSerializer.class)
	@XmlElement(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "METADATA_ID", referencedColumnName = "ID") })
	@Builder.Default
	private CustomFieldMetadata type = null;

	@JsonProperty("FIELD_VALUE")
	@JacksonXmlProperty(localName = "FIELD_VALUE")
	@XmlElement(name = "FIELD_VALUE")
	@Column(name = "VALUE", nullable = false)
	@Builder.Default
	private String value = null;
}