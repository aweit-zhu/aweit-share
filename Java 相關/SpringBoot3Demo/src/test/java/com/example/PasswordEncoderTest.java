package com.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	public static void main(String[] args) {
		String password = new BCryptPasswordEncoder().encode("123");
		System.out.println(password);
	}
}
