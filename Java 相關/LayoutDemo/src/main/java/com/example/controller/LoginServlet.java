package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		// 驗證用戶登入資訊：假設 username=user,password=123 (資料庫存：$2a$10$ms1UGigcUkZP0axeEY4JM.3bG9CawnqegKEH2Dlw.fJAv.wLF6Zf.)
		boolean isPasswordMatch = BCrypt.checkpw(password, "$2a$10$ms1UGigcUkZP0axeEY4JM.3bG9CawnqegKEH2Dlw.fJAv.wLF6Zf.");
		if(!"user".equals(username) || !isPasswordMatch) {
			req.setAttribute("error", "帳號或密碼錯誤!");
			RequestDispatcher dp = req.getRequestDispatcher("/login.jsp");
			dp.forward(req, resp);
			return;
		} 
		
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60 * 15); // 單位為秒
		session.setAttribute("isLogin", true);
		session.setAttribute("username", username);
		resp.sendRedirect("./");
	}

	
}
