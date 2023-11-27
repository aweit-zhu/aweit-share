package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value = "/upload")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50,       // 50 MB
		maxRequestSize = 1024 * 1024 * 100)   // 100 MB
public class UploadFileServlet extends HttpServlet{

	private static final Path upPath = Paths.get("C:\\uploads");
	
	static {
		try {
			Files.createDirectories(upPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");

		for(Part part: req.getParts()) {
			String fileName = part.getSubmittedFileName();
			if(fileName !=null) {
				part.write(upPath.resolve(username + fileName).toAbsolutePath().toString());
			}
		}
		
		req.getRequestDispatcher("/WEB-INF/view/page2_result.jsp").forward(req, resp);
	}

}
