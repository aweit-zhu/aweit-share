package com.aweit.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {
	
	@Value("Mook Kim")
	private String name;
	
	@Value("https://www.1ju.org")
	private String url;

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return this.name;
	}

	public String getURL() {
		return this.url;
	}

	public void throwException() {
		throw new IllegalArgumentException();
	}
}
