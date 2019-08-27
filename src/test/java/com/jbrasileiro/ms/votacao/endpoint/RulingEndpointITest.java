package com.jbrasileiro.ms.votacao.endpoint;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jbrasileiro.ms.votacao.AbstractTestIntegration;

public class RulingEndpointITest
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;


	@Test
	public void test() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/ruling/save")
			.contentType(MediaType.APPLICATION_JSON)
			.content(reader.read("IT/RULING/request-default.json")))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json(reader.read("IT/RULING/request-default-expected.json")));
	}
}
