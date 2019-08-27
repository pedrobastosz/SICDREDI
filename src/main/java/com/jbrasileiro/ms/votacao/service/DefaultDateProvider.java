package com.jbrasileiro.ms.votacao.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public final class DefaultDateProvider
	implements
	DateProvider {

	@Override
	public Date now() {
		return new Date();
	}
}
