package com.jbrasileiro.ms.votacao.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(
	name = "VOTING",
	uniqueConstraints = {
		@UniqueConstraint(
			columnNames = {
				"ASSOCIATE",
				"ID_SESSION"
			})
	})
public class Voting {

	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY)
	public Long id;
	private String associate;
	private Boolean vote;
	@ManyToOne(
		optional = false)
	@JoinColumn(
		name = "ID_SESSION")
	private Session session;

	public String getAssociate() {
		return associate;
	}

	public void setAssociate(
		String associate) {
		this.associate = associate;
	}

	public Boolean getVote() {
		return vote;
	}

	public void setVote(
		Boolean vote) {
		this.vote = vote;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(
		Session session) {
		this.session = session;
	}

	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Voting) {
			Voting o = (Voting) obj;
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
