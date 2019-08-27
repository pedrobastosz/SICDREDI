package com.jbrasileiro.ms.votacao.endpoint;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbrasileiro.ms.votacao.domain.Ruling;
import com.jbrasileiro.ms.votacao.domain.Session;
import com.jbrasileiro.ms.votacao.endpoint.request.SessionOpenRequest;
import com.jbrasileiro.ms.votacao.repository.RulingRepository;
import com.jbrasileiro.ms.votacao.repository.SessionRepository;
import com.jbrasileiro.ms.votacao.service.DateProvider;

@RestController
@RequestMapping("/session")
public class SessionEndpoint {

	private final SessionRepository sessionRepository;
	private final RulingRepository rulingRepository;
	private final DateProvider dateProvider;


	@Autowired
	public SessionEndpoint(
		SessionRepository sessionRepository,
		RulingRepository rulingRepository,
		DateProvider dateProvider) {
		super();
		this.sessionRepository = sessionRepository;
		this.rulingRepository = rulingRepository;
		this.dateProvider = dateProvider;
	}

	@RequestMapping(
		value = "/",
		method = RequestMethod.GET)
	public Collection<Session> searchAll() {
		return sessionRepository.findAll();
	}

	@RequestMapping(
		value = "/open",
		method = RequestMethod.POST)
	public Session openSession(
		@Valid @RequestBody SessionOpenRequest request) {
		Long idRulling = request.getIdRulling();
		Ruling ruling = rulingRepository.findById(idRulling).orElseThrow(() -> new RuntimeException("No rulling found with id " + idRulling));
		Session session = new Session();
		session.setRuling(ruling);
		session.setStart(dateProvider.now());
		Long duration = request.getDuration();
		if (Objects.isNull(duration) || 0 == duration.longValue()) {
			session.setDuration(TimeUnit.MINUTES.toMillis(1));
		} else {
			session.setDuration(duration);
		}
		return sessionRepository.save(session);
	}
}
