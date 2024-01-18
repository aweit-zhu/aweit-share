package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.example.bean.CreateUser;
import com.example.bean.Role;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDetailsManager userDetailsManager;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails createUser(CreateUser createUser) throws Exception {
		
		List<String> roleNames = createUser.getRoles().stream()
		            .map(Role::toString)
		            .collect(Collectors.toList());
		
		UserDetails user = User.builder()
				.username(createUser.getUsername())
				.password(passwordEncoder.encode(createUser.getPassword()))
				.roles(roleNames.toArray(new String[0]))
				.build();
		
		userDetailsManager.createUser(user);

		return user;
	}

}
