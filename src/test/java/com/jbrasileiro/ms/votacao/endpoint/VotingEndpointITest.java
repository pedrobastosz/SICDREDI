package com.jbrasileiro.ms.votacao.endpoint;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jbrasileiro.ms.votacao.AbstractTestIntegration;
import com.jbrasileiro.ms.votacao.DateConstant;
import com.jbrasileiro.ms.votacao.service.DateProvider;

public class VotingEndpointITest
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private DateProvider dateProvider;

	@Test
	public void testVoteResult() throws Exception {
		Mockito.when(dateProvider.now()).thenReturn(DateConstant.NOW_DATE);

		mvc.perform(MockMvcRequestBuilders.post("/ruling/save")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"name\":\"rulling-99\"}"))
			.andExpect(MockMvcResultMatchers.status().isOk());

		mvc.perform(MockMvcRequestBuilders.post("/session/open")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"idRulling\":1}"))
			.andExpect(MockMvcResultMatchers.status().isOk());

		mvc.perform(MockMvcRequestBuilders.post("/voting/vote")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"rulling\":1,\"associate\":\"1\",\"vote\":\"SIM\"}"))
		.andExpect(MockMvcResultMatchers.status().isOk());

		mvc.perform(MockMvcRequestBuilders.get("/voting/result/1"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json(
				reader.read(reader.read("IT/VOTING/request-vote-result-expected.json"))
				));
	}
}
