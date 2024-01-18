package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

@Configuration
public class DefaultSecurityConfig {
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsManager users(DataSource dataSource) {
		UserDetails user = User.builder()
			.username("user")
			.password("$2a$10$iILYAh.LD.1SZRhD67p82e77UQYMetcCs74RUgXbxSTYJl/qVJPFm")
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password("$2a$10$iILYAh.LD.1SZRhD67p82e77UQYMetcCs74RUgXbxSTYJl/qVJPFm")
			.roles("USER", "ADMIN")
			.build();
		//users.createUser(user);
		//users.createUser(admin);
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(
					(authorize) -> authorize
					.requestMatchers("/admin/**").hasAnyRole("ADMIN")
					.requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
					.anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults())
			.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
