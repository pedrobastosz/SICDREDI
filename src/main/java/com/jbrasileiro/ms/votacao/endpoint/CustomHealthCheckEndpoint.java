package com.jbrasileiro.ms.votacao.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomHealthCheckEndpoint {

	@GetMapping("health/custom/check")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("up");
	}

}
