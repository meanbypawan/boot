package com.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestfeignApplication.class, args);
	}

}
