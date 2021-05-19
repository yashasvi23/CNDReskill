package com.infosys.infytel.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class InfytelZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfytelZuulApplication.class, args);
	}
}
