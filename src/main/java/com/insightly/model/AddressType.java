package com.insightly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * CustomFieldType
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName="of")
@AllArgsConstructor
@Builder
//@ToString(includeFieldNames = false, of = "name")
@Entity
@Table(name = "ADDRESS_TYPE", indexes = { @Index(name = "idx_NAME", columnList = "NAME", unique = true) })
public class AddressType implements Serializable {
	private static final long serialVersionUID = 1L;
	@NonNull
	private AddressTypeID id;
	private String name;
	
	@Id
	@Column(name = "ID")
	@Enumerated
	public AddressTypeID getId() {
		return id;
	}
	
	@Column(name = "NAME", unique=true, nullable = false)
	public String getName() {
		return id.value();
	}
	
	@Override
	public String toString() {
		return getName();
	}
}