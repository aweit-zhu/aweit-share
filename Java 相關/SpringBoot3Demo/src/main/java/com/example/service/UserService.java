package com.example.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.bean.CreateUser;

public interface UserService {

	public UserDetails createUser(CreateUser createUser) throws Exception;
}
