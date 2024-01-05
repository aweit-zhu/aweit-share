package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBoot3DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3DemoApplication.class, args);
	}

}
