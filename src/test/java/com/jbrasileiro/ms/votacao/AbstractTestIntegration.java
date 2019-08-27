package com.jbrasileiro.ms.votacao;

import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.jbrasileiro.ms.votacao.commons.io.ResourceReader;

@ActiveProfiles("test-integration")
@RunWith(SpringRunner.class)
@IntegrationTest
public abstract class AbstractTestIntegration {

	@Autowired
	private Flyway flyway;
	protected static ResourceReader reader;

	@Before
	public void before() {
		flyway.migrate();
	}

	@After
	public void after() {
		flyway.clean();
	}


//	@Rule
//	public GenericContainer<?> container = new GenericContainer<>("rabbitmq:3-management")
//	                                        .withExposedPorts(5672)
//	                                        .waitingFor(Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(30)));

	@Before
	public void setup() {
		reader = new ResourceReader();
	}

	@After
	public void clean() {
//		container.close();
	}

	@AfterClass
	public static void shutdown() {
	}

}
