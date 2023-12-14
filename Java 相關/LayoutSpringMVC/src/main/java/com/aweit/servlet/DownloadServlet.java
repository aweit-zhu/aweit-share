package com.aweit.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

		try (OutputStream output = resp.getOutputStream()){
			URL resource = getClass().getClassLoader().getResource(filename);
			Path sorucrePath = Paths.get(resource.toURI());
			Files.copy(sorucrePath, output);
		} catch (URISyntaxException e) {
			e.printStackTrace();
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


// 傳統方式
//try (InputStream input = getClass().getClassLoader().getResourceAsStream(filename);
//OutputStream output = resp.getOutputStream()) {
//byte[] buffer = new byte[4096];
//int bytesRead;
//while ((bytesRead = input.read(buffer)) != -1) {
//   output.write(buffer, 0, bytesRead);
//}
//} catch (Exception e) {
//throw e;
//}
