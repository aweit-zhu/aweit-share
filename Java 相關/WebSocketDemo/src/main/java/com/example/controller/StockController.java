package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.handler.ServerWebSocketHandler;

@Controller
@RequestMapping("/stock")
public class StockController {

	
	@Autowired()
	ServerWebSocketHandler serverWebSocketHandler;
	
	@GetMapping()
	@ResponseBody
	public String update() throws IOException {
		serverWebSocketHandler.sendPeriodicMessages();
		return "OK";
	}
}
