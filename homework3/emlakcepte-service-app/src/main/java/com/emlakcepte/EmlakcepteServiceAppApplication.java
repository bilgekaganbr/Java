package com.emlakcepte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class EmlakcepteServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakcepteServiceAppApplication.class, args);
	}
	
	//Bean that generate restTemplate object
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
