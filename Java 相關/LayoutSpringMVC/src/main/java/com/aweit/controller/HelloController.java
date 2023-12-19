package com.aweit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aweit.bean.Book;
import com.aweit.bean.Emp;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping(value = "/print")
	public String printHello(Model model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
	
	@GetMapping(value = "/one")
	@ResponseBody
	public String one(String str) {
		System.out.println(str);
		return "hello";
	}

	@GetMapping(value = "/two")
	@ResponseBody
	public String one(Emp emp,Emp emp2,Book book,Model model) {
		System.out.println(emp);
		return "hello";
	}
}