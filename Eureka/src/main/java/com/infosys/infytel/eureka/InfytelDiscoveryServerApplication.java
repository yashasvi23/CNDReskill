package com.infosys.infytel.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InfytelDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfytelDiscoveryServerApplication.class, args);
	}
}
