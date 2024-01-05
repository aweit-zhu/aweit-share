package com.example.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.LoginUser;

import jakarta.validation.Valid;

/**
 * http://localhost:9090/mvc/login
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String loginPage(@ModelAttribute LoginUser loginuser) {
		return "views/login";
	}
	
	@PostMapping
	public String doLogin(@ModelAttribute @Valid LoginUser loginUser,BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
            return "views/login";
			//return "templates/login";
        }
		
		return "views/login";
		//return "templates/login";
	}
}
