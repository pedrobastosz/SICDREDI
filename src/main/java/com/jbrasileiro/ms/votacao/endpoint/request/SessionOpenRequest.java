package com.jbrasileiro.ms.votacao.endpoint.request;

import java.io.Serializable;

import javax.validation.constraints.Min;

import io.micrometer.core.lang.NonNull;

public class SessionOpenRequest
	implements
	Serializable {

	@NonNull
	private Long idRulling;
	private Long duration;

	public Long getIdRulling() {
		return idRulling;
	}

	public void setIdRulling(
		Long idRulling) {
		this.idRulling = idRulling;
	}

	@Min(
		value = 0)
	public Long getDuration() {
		return duration;
	}

	public void setDuration(
		Long duration) {
		this.duration = duration;
	}
}
