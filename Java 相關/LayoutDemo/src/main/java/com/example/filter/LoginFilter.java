package com.example.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = {"/*"})
public class LoginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String urlString = request.getRequestURL().toString();
		
		if(urlString.endsWith("login.jsp") || urlString.endsWith("login") || urlString.indexOf("/images")>=0 ) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		boolean isLogin = session.getAttribute("isLogin") == null ? false: (boolean)session.getAttribute("isLogin");
		if(!isLogin) {
			response.sendRedirect("./login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
