package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/download")
public class DownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String filename = req.getParameter("filename");
		resp.setContentType("APPLICATION/OCTET-STREAM");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filenameEncode(filename) + "\"");

		try (InputStream input = getClass().getClassLoader().getResourceAsStream(filename);
			 OutputStream output = resp.getOutputStream()) {
			byte[] buffer = new byte[4096];
		    int bytesRead;
		    while ((bytesRead = input.read(buffer)) != -1) {
		        output.write(buffer, 0, bytesRead);
		    }
		} catch (Exception e) {
			throw e;
		}
	}

	public static String filenameEncode(String name) {
	    try {
	        return java.net.URLEncoder.encode(name, "UTF-8").replace("+", "%20");
	    } catch (java.io.UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return name;
	    }
	}
}
