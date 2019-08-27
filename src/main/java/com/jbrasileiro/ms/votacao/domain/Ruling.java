package com.jbrasileiro.ms.votacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(
	name = "RULING",
	uniqueConstraints = {
		@UniqueConstraint(
			columnNames = {
				"NAME"
			})
	})
public class Ruling {

	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(
		unique = true)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(
		Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(
		String name) {
		this.name = name;
	}

	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Ruling) {
			Ruling o = (Ruling) obj;
			return EqualsBuilder.reflectionEquals(this, o, true);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
