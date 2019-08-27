package com.jbrasileiro.ms.votacao.health;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.jbrasileiro.ms.votacao.AbstractTestIntegration;

public class CustomHealthCheckEndpointITest
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/health/custom/check")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("up"));
	}

}
