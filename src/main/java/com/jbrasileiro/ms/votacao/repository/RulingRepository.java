package com.jbrasileiro.ms.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbrasileiro.ms.votacao.domain.Ruling;

@Repository
public interface RulingRepository
	extends
	JpaRepository<Ruling, Long> {
}
