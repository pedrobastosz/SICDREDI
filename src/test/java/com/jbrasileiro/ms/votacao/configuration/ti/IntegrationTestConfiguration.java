package com.jbrasileiro.ms.votacao.configuration.ti;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jbrasileiro.ms.votacao.service.DateProvider;

@Profile("test-integration")
@Configuration
public class IntegrationTestConfiguration {

	@Bean
	public DateProvider dateProvider() {
		DateProvider result = Mockito.mock(DateProvider.class);
		return result;
	}
}
