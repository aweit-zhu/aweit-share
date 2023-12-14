package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * http://localhost:8080/ServletToSpring/mvc/hello/spring
 * http://localhost:8080/ServletToSpring/mvc/hello/spring2
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/spring")
	@ResponseBody
	public String spring() {
		logger.info("hello spring");
		return "Hello ! Spring!";
	}
	
	@GetMapping("/spring2")
	public String spring2(Model model) {
		logger.info("hello spring2");
		return "spring";
	}
	
	@GetMapping("/spring3")
	public ModelAndView spring3() {
		logger.info("hello spring3");
		ModelAndView view = new ModelAndView();
		view.setViewName("spring");
		return view;
	}
	
	@GetMapping("/spring4")
	public String spring4(HttpServletRequest request,HttpServletResponse response,java.util.Locale locale) {
		logger.info("hello spring2");
		return "spring";
	}
}
