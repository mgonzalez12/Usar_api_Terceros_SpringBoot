package com.marcos.ApiDeTerceros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiDeTercerosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDeTercerosApplication.class, args);
	}

}
