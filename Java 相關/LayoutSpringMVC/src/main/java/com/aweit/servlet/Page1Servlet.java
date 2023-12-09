package com.aweit.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/page1")
public class Page1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/LayoutDemo/page1.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		
		req.setAttribute("email", email);
		req.setAttribute("message", message);
		
		RequestDispatcher rd = req.getRequestDispatcher("./index.jsp");
		rd.forward(req, resp);
		
	}

}
	
	