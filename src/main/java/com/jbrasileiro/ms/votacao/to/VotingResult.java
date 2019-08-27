package com.jbrasileiro.ms.votacao.to;

import com.jbrasileiro.ms.votacao.domain.Session;

public interface VotingResult {

	Session getSession();

	Long getTotal();

}
