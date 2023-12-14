package com.aweit.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aweit.ioc.HelloWorld;
import com.aweit.ioc.SpringHelloWorld;

//@Configuration
public class AppConfig {

	@Bean("helloworld")
	public HelloWorld getHelloWorld() {
		return new SpringHelloWorld();
	}
}
