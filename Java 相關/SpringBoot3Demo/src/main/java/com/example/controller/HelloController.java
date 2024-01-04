package com.example.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JSP：http://localhost:9090/mvc/hello/jsp-page
 * Thymeleaf: http://localhost:9090/mvc/hello/thymeleaf-page
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/jsp-page")
	public String jspPage(Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		model.addAttribute("username","aweit");
		model.addAttribute("texts",Arrays.asList("a","b","c"));
		return "views/jsp-page"; // 回傳 JSP 頁面
	}

	@GetMapping("/thymeleaf-page")
	public String thymeleafPage(Model model) {
		model.addAttribute("username","aweit");
		model.addAttribute("texts",Arrays.asList("a","b","c"));
		return "templates/thymeleaf-page"; // 回傳 Thymeleaf 頁面
	}
}
