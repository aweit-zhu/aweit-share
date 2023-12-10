package com.aweit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aweit.dao.user.User;
import com.aweit.dao.user.UserDAOImpl;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	UserDAOImpl userDaoImpl;
	
	@PostMapping
	public void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userDaoImpl.findUserByName(username);
		if (user == null || ! BCrypt.checkpw(password,user.getPassword())) {
			req.setAttribute("error", "帳號或密碼輸入錯誤!");
			RequestDispatcher dp = req.getRequestDispatcher("/login.jsp");
			dp.forward(req, resp);
			return;
		}
		
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60 * 15); // 15分鐘：如果在指定的一段時間內，沒有任何的請求進來，session會失效。
		session.setAttribute("isLogin", true);
		session.setAttribute("username", username);
		resp.sendRedirect(req.getContextPath());
	}
}
