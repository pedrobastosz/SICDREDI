package com.jbrasileiro.ms.votacao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(
	name = "SESSION")
public class Session {

	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY)
	public Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	@Column(
		columnDefinition = "NUMERIC(10,0)")
	private Long duration;
	@ManyToOne(
		optional = false)
	@JoinColumn(
		name = "ID_RULING")
	private Ruling ruling;

	public Long getId() {
		return id;
	}

	public void setId(
		Long id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(
		Date start) {
		this.start = start;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(
		Long duration) {
		this.duration = duration;
	}

	public Ruling getRuling() {
		return ruling;
	}

	public void setRuling(
		Ruling ruling) {
		this.ruling = ruling;
	}

	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Session) {
			Session o = (Session) obj;
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
