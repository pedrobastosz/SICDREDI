package com.jbrasileiro.ms.votacao.endpoint;

import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jbrasileiro.ms.votacao.AbstractTestIntegration;
import com.jbrasileiro.ms.votacao.DateConstant;
import com.jbrasileiro.ms.votacao.domain.Ruling;
import com.jbrasileiro.ms.votacao.repository.RulingRepository;
import com.jbrasileiro.ms.votacao.service.DateProvider;

@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class SessionEndpointITest
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private Flyway flyway;
	@Autowired
	private DateProvider dateProvider;
	@Autowired
	private RulingRepository rulingRepository;

	@Before
	public void before() {
		Ruling ruling = new Ruling();
		ruling.setName("test-integration rulling");
		rulingRepository.save(ruling);
	}

	@After
	public void after() {
		flyway.clean();
		flyway.migrate();
	}


	@Test
	public void openSessionDurationNegative() throws Exception {
		Mockito.when(dateProvider.now()).thenReturn(DateConstant.NOW_DATE);
		mvc.perform(MockMvcRequestBuilders.post("/session/open")
			.contentType(MediaType.APPLICATION_JSON)
			.content(reader.read("IT/SESSION/request-duration-negative.json")))
			.andExpect(MockMvcResultMatchers.status().is4xxClientError())
			.andExpect(MockMvcResultMatchers.content().string(""));
	}

	@Test
	public void openSessionDurationZero() throws Exception {
		Mockito.when(dateProvider.now()).thenReturn(DateConstant.NOW_DATE);
		mvc.perform(MockMvcRequestBuilders.post("/session/open")
			.contentType(MediaType.APPLICATION_JSON)
			.content(reader.read("IT/SESSION/request-duration-zero.json")))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json(reader.read("IT/SESSION/request-duration-zero-expected.json")));
	}

	@Test
	public void openSessionDurationPositive() throws Exception {
		Mockito.when(dateProvider.now()).thenReturn(DateConstant.NOW_DATE);
		mvc.perform(MockMvcRequestBuilders.post("/session/open")
			.contentType(MediaType.APPLICATION_JSON)
			.content(reader.read("IT/SESSION/request-duration-positive.json")))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json(reader.read("IT/SESSION/request-duration-positive-expected.json")));
	}
}
