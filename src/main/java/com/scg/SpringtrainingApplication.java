package com.scg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringtrainingApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SpringtrainingApplication.class, args);
	}

}
