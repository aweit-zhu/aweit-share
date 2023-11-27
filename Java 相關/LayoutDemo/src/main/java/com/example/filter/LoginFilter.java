package com.example.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter( value = {"/*"})
public class LoginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		String url = req.getRequestURL().toString();

		if(url.indexOf("/login.jsp") >=0) {
			chain.doFilter(req, res);
			return;
		}
		
		HttpSession session = req.getSession();
		boolean isLogin = (boolean)session.getAttribute("islogin");
		if(!isLogin) {
			res.sendRedirect("./login.jsp");
			return;
		}
		chain.doFilter(req, res);
	}
}
