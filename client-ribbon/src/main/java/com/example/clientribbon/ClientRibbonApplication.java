package com.example.clientribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableDiscoveryClient
@RibbonClient(name="content", configuration = RibbonConfiguration.class)
@SpringBootApplication
public class ClientRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRibbonApplication.class, args);
	}

}
