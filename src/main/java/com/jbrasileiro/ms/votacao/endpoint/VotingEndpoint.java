package com.jbrasileiro.ms.votacao.endpoint;

import java.util.Arrays;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbrasileiro.ms.votacao.domain.Ruling;
import com.jbrasileiro.ms.votacao.domain.Session;
import com.jbrasileiro.ms.votacao.domain.Voting;
import com.jbrasileiro.ms.votacao.endpoint.request.VoteRequest;
import com.jbrasileiro.ms.votacao.repository.RulingRepository;
import com.jbrasileiro.ms.votacao.repository.SessionRepository;
import com.jbrasileiro.ms.votacao.repository.VotingRepository;
import com.jbrasileiro.ms.votacao.to.VotingResult;

@RestController
@RequestMapping("/voting")
public class VotingEndpoint {

	private final RulingRepository rulingRepository;
	private final SessionRepository sessionRepository;
	private final VotingRepository votingRepository;

	@Autowired
	public VotingEndpoint(
		RulingRepository rulingRepository,
		SessionRepository sessionRepository,
		VotingRepository votingRepository) {
		super();
		this.rulingRepository = rulingRepository;
		this.sessionRepository = sessionRepository;
		this.votingRepository = votingRepository;
	}

	@RequestMapping(
		value = "/vote",
		method = RequestMethod.POST)
	public Voting vote(
		@Valid @RequestBody VoteRequest request) {
		Long idRulling = request.getRulling();
		Ruling ruling = rulingRepository.findById(idRulling)
			.orElseThrow(() -> new RuntimeException("No rulling found with id " + idRulling));
		Session example = new Session();
		Session session = sessionRepository.findOne(Example.of(example)).orElseThrow(
			() -> new RuntimeException("No session foud for rulling " + ruling.getId()));
		Voting voting = new Voting();
		voting.setAssociate(request.getAssociate());
		voting.setVote(toBoolean(request.getVote()));
		voting.setSession(session);
		return votingRepository.save(voting);
	}

	private Boolean toBoolean(
		String vote) {
		if (Arrays.asList("SIM", "NÃO").contains(vote)) {
			return "SIM".equals(vote);
		} else {
			throw new IllegalArgumentException("vote value not valid.");
		}
	}

	@RequestMapping(
		value = "/result/{idRulling}",
		method = RequestMethod.GET)
	public Collection<VotingResult> result(
		@PathVariable("idRulling") long idRulling) {
		return votingRepository.findResultVotingByRulling(idRulling);
	}
}
