package com.example.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value = "/page2")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100) // 100 MB
public class Page2Servlet extends HttpServlet {

	private static final String UPLOAD_DIR = "uploads";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/page2.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usernameString = req.getParameter("username");
		String type = req.getParameter("type");
		String startDatString = req.getParameter("start_date");
		String endDateString = req.getParameter("end_date");
		String memoString = req.getParameter("memo");

		System.out.println("usernameString:" + usernameString);
		System.out.println("type:" + type);
		System.out.println("start_date:" + startDatString);
		System.out.println("end_date:" + endDateString);
		System.out.println("memo:" + memoString);

		String applicationPath = req.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

		String fileName = null;
		// Get all the parts from request and write it to the file on server
		for (Part part : req.getParts()) {
			fileName = getFileName(part);
			if (!"".equals(fileName))
				part.write(uploadFilePath + File.separator + fileName);
		}

		req.getRequestDispatcher("/WEB-INF/view/page2_result.jsp").forward(req, resp);
	}

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

}
