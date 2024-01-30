package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.CreateUser;
import com.example.service.UserService;
import com.google.gson.Gson;

/**
 * http://localhost:9090/user
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	@ResponseBody
	public String user() {
		return "user";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDetails createUser(@RequestBody CreateUser createUser) throws Exception {
		return userService.createUser(createUser);
	}
	
	@PostMapping(value ="/test")
	@ResponseBody
	public String test(@RequestBody Map<String,String> body) throws Exception {
		return new Gson().toJson(123);
	}
}
