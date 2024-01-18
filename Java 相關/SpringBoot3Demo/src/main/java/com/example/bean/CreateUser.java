package com.example.bean;

import lombok.NoArgsConstructor;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {

	String username;
	
	String password;
	
	List<Role> roles;
}
