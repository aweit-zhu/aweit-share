package com.example.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://localhost:8080/ServletToSpring/helloServlet
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet{

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("hello, servlet");
		//resp.getWriter().println("Hello ! Servlet!");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/servlet.jsp");
		rd.forward(req, resp);
	}
}
