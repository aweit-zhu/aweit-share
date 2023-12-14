package com.aweit.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

	@Bean(value="english")
	public EnglishClass englishClass() {
		return new EnglishClass();
	}
}

