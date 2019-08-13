package com.springmvc.springmvcrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringMvcRestClientApplication {
	static final String URL_EMPLOYEES = "http://localhost:8081/employee/all";

	static final String URL_EMPLOYEES_JSON = "http://localhost:8081/employee.json";

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcRestClientApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);

		System.out.println(result);

	}

}
