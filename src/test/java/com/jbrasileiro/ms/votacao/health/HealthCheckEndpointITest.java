package com.jbrasileiro.ms.votacao.health;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.jbrasileiro.ms.votacao.AbstractTestIntegration;

public class HealthCheckEndpointITest
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;
	@Value("${value}")
	private String value;

	@Test
	public void test()
		throws Exception {
		Assert.assertEquals("integration-test", value);
		mvc.perform(
			MockMvcRequestBuilders.get("/actuator/health").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json("{\"status\":\"UP\"}"));
	}
}
