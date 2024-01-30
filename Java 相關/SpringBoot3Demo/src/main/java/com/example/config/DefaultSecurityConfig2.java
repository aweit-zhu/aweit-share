package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

//@Configuration
public class DefaultSecurityConfig2 {
	
	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
			.username("user")
			.password("123")
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password("123")
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	DigestAuthenticationEntryPoint digestEntryPoint() {
		DigestAuthenticationEntryPoint result = new DigestAuthenticationEntryPoint();
		result.setRealmName("My App Realm");
		result.setKey("3028472b-da34-4501-bfd8-a355c42bdf92");
		return result;
	}

	DigestAuthenticationFilter digestAuthenticationFilter() {
		DigestAuthenticationFilter result = new DigestAuthenticationFilter();
		result.setUserDetailsService(userDetailsService());
		result.setAuthenticationEntryPoint(digestEntryPoint());
		return result;
	}
	
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http
			.exceptionHandling(e -> e.authenticationEntryPoint(digestEntryPoint()))
			.addFilterBefore(digestAuthenticationFilter(),DigestAuthenticationFilter.class)
			.authorizeRequests(
					(authorize) -> authorize
					.requestMatchers("/admin/**").hasAnyRole("ADMIN")
					.requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
					.anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
