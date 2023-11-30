package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/product")
public class ProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("img", "./images/prod.jpg");
		req.setAttribute("price", 50);
		req.setAttribute("info", "漢堡");
		
		req.getRequestDispatcher("/WEB-INF/shop/prodInfo.jsp").forward(req, resp);
	}

	
}
