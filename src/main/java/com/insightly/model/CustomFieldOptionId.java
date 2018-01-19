package com.insightly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomFieldOptionId implements Serializable {
	private static final long serialVersionUID = -7545248978439960550L;
	
	@JsonProperty("OPTION_ID")
	@JacksonXmlProperty(localName = "OPTION_ID")
	@XmlElement(name = "OPTION_ID")
	@Column(name = "OPTION_ID", unique=false, nullable = false)
	@NonNull
	private Integer id = null;
	
	@Column(name = "CUSTOM_FIELD_METADATA_ID")
	@NonNull
	private Long customFieldMetadataID;
}
