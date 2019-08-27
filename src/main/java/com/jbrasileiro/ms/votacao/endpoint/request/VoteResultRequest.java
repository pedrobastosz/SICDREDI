package com.jbrasileiro.ms.votacao.endpoint.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class VoteResultRequest
	implements
	Serializable {

	@NotNull
	private Long rulling;
	private Long session;

	public Long getRulling() {
		return rulling;
	}

	public void setRulling(
		Long rulling) {
		this.rulling = rulling;
	}

	public Long getSession() {
		return session;
	}

	public void setSession(
		Long session) {
		this.session = session;
	}
}
