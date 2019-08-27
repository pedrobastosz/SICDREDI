package com.jbrasileiro.ms.votacao.endpoint;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbrasileiro.ms.votacao.domain.Ruling;
import com.jbrasileiro.ms.votacao.repository.RulingRepository;

@RestController
@RequestMapping("/ruling")
public class RulingEndpoint {

	private RulingRepository repository;

	@Autowired
	public RulingEndpoint(
		RulingRepository repository) {
		super();
		this.repository = repository;
	}

	@RequestMapping(
		value = "/",
		method = RequestMethod.GET)
	public Collection<Ruling> getAll() {
		return repository.findAll();
	}

	@RequestMapping(
		value = "/save",
		method = RequestMethod.POST)
	public Ruling saveRulling(
		@Valid @RequestBody Ruling pauta) {
		repository.save(pauta);
		return pauta;
	}
}
