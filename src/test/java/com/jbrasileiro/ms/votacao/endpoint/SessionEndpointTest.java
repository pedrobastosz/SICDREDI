package com.jbrasileiro.ms.votacao.endpoint;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jbrasileiro.ms.votacao.domain.Ruling;
import com.jbrasileiro.ms.votacao.domain.Session;
import com.jbrasileiro.ms.votacao.endpoint.request.SessionOpenRequest;
import com.jbrasileiro.ms.votacao.repository.RulingRepository;
import com.jbrasileiro.ms.votacao.repository.SessionRepository;
import com.jbrasileiro.ms.votacao.service.DateProvider;


public class SessionEndpointTest {

	@Mock
	private SessionRepository sessionRepository;
	@Mock
	private RulingRepository rulingRepository;
	@Mock
	private DateProvider dateProvider;
	private SessionEndpoint endpoint;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		endpoint = new SessionEndpoint(sessionRepository, rulingRepository, dateProvider);
	}

	@Test
	public void openSessionDurationNull() {
		SessionOpenRequest request = new SessionOpenRequest();
		request.setIdRulling(1L);
		Session expected = new Session();
		expected.setDuration(60000L);
		expected.setRuling(new Ruling());

		Mockito.when(rulingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Ruling()));
		endpoint.openSession(request);
		Mockito.verify(sessionRepository).save(Mockito.eq(expected));
	}

	@Test
	public void openSessionDurationZero() {
		SessionOpenRequest request = new SessionOpenRequest();
		request.setIdRulling(1L);
		request.setDuration(0L);
		Session expected = new Session();
		expected.setRuling(new Ruling());
		expected.setDuration(60000L);

		Mockito.when(rulingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Ruling()));
		endpoint.openSession(request);
		Mockito.verify(sessionRepository).save(Mockito.eq(expected));
	}
}
