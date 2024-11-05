package com.ust.AthleteGatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AthleteGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthleteGatewayServiceApplication.class, args);
	}

}
