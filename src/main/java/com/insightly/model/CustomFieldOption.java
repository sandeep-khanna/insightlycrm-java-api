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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * CustomFieldOption
 */
@JacksonXmlRootElement(localName = "CustomFieldOption")
@XmlRootElement(name = "CustomFieldOption")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@ToString(includeFieldNames =false,
	of = { "id", "value", "defaultValue" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOM_FIELD_OPTION")
public class CustomFieldOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonUnwrapped
	@EmbeddedId	
	private CustomFieldOptionId id;

	@JsonProperty("OPTION_VALUE")
	@JacksonXmlProperty(localName = "OPTION_VALUE")
	@XmlElement(name = "OPTION_VALUE")
	@Column(name = "OPTION_VALUE", unique=false, nullable = false)
	@NonNull
	private String value = StringUtils.EMPTY;

	@JsonProperty("OPTION_DEFAULT")
	@JacksonXmlProperty(localName = "OPTION_DEFAULT")
	@XmlElement(name = "OPTION_DEFAULT")
	@Column(name = "OPTION_DEFAULT", unique=false, nullable = false)
	@NonNull
	private Boolean defaultValue = null;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CUSTOM_FIELD_METADATA_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
	})
	private CustomFieldMetadata customFieldMetadata;
	
	@PrePersist
	private void maintainParentBackreference() {
		id.setCustomFieldMetadataID(customFieldMetadata.getId());
	}
}