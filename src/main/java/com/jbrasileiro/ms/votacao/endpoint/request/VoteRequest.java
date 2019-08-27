package com.jbrasileiro.ms.votacao.endpoint.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VoteRequest
	implements
	Serializable {

	@NotNull
	private Long rulling;
	@NotEmpty
	private String associate;
	@NotEmpty
	private String vote;

	public Long getRulling() {
		return rulling;
	}

	public void setRulling(
		Long rulling) {
		this.rulling = rulling;
	}

	public String getAssociate() {
		return associate;
	}

	public void setAssociate(
		String associate) {
		this.associate = associate;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(
		String vote) {
		this.vote = vote;
	}
}
