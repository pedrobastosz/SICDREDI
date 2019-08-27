package com.jbrasileiro.ms.votacao.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jbrasileiro.ms.votacao.domain.Voting;
import com.jbrasileiro.ms.votacao.to.VotingResult;

@Repository
public interface VotingRepository
	extends
	JpaRepository<Voting, Long> {

	@Query("SELECT"
		+ " vote.session as session"
		+ " , count(vote) as total"
		+ " FROM Voting vote"
		+ " INNER JOIN vote.session session"
		+ " INNER JOIN session.ruling"
		+ " WHERE vote.id = :id_rulling"
		+ " GROUP BY session.ruling"
	)
	Collection<VotingResult> findResultVotingByRulling(@Param("id_rulling") Long id_rulling);
}