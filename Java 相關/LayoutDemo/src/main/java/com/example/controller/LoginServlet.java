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
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean isPasswordMatch = BCrypt.checkpw(password,
				"$2a$10$ms1UGigcUkZP0axeEY4JM.3bG9CawnqegKEH2Dlw.fJAv.wLF6Zf.");
		if (!"user".equals(username) || !isPasswordMatch) {
			req.setAttribute("error", "帳號或密碼輸入錯誤!");
			RequestDispatcher dp = req.getRequestDispatcher("/login.jsp");
			dp.forward(req, resp);
			return;
		}

		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60 * 15); // 15分鐘：如果在指定的一段時間內，沒有任何的請求進來，session會失效。
		session.setAttribute("isLogin", true);
		session.setAttribute("username", username);
		resp.sendRedirect("./");
	}

}
