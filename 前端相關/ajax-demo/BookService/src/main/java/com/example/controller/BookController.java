package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Book;
import com.example.model.FormDataWithFile;

import io.micrometer.common.util.StringUtils;

@CrossOrigin(value = "*", allowedHeaders = {"Token","Content-Type"})
@RestController
@RequestMapping("/api")
public class BookController {

	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value = "/token", method = RequestMethod.GET)
	public String getToken() throws ParseException {
		return token;
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public Book getBook() throws ParseException {
		return Book.builder().id(1L).name("Java 17 教學手冊").price(500).publishDate(sdf.parse("2023-10-21")).build();
	}

	@RequestMapping(value = "/secured/book", method = RequestMethod.POST)
	public ResponseEntity<?> createBook(@RequestHeader("Token") String token, @RequestBody Book request) {
		
		if (StringUtils.isBlank(token))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token is missing in Http Headers!");

		if (!token.equals(this.token))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token is invalid!!");
		
		Book book = Book.builder().id(2L).name(request.getName()).price(request.getPrice()).publishDate(new Date())
				.build();
		return ResponseEntity.ok(book);
	}

	@RequestMapping(value = "/secured/book", method = RequestMethod.GET)
	public ResponseEntity<?> getBook(@RequestHeader("Token") String token) throws ParseException {

		if (StringUtils.isBlank(token))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token is missing in Http Headers!");

		if (!token.equals(this.token))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token is invalid!!");
		
		Book book = Book.builder().id(1L).name("Java 17 教學手冊").price(500).publishDate(sdf.parse("2023-10-21")).build();

		return ResponseEntity.ok(book);
	}

//	@PostMapping("/upload")
//	public String submit(FormDataWithFile formDataWithFile) throws IOException {
//		
//		MultipartFile file = formDataWithFile.getFile();
//		
//		InputStream is = file.getInputStream();
//		
//		File targetFile = new File("src/main/resources/" + file.getOriginalFilename());
//
//	    java.nio.file.Files.copy(is, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//	    IOUtils.closeQuietly(is);
//		
//	    return "ok";
//	}
}
