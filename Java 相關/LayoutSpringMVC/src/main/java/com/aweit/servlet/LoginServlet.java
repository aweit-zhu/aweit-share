package com.aweit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aweit.dao.user.User;
import com.aweit.dao.user.UserDAOImpl;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		UserDAOImpl userDaoImpl = (UserDAOImpl)context.getBean("userDaoImpl");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = userDaoImpl.findUserByName(username);
		
		if (user == null || BCrypt.checkpw(password,user.getPassword())) {
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
