package com.example.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDataWithFile {
	
	private String name;
	
    private String email;
    
    private MultipartFile file;
}
