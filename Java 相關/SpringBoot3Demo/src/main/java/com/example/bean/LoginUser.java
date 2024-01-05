package com.example.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

	@NotBlank(message = "{NotBlank.username}")
	private String username;
	
	@NotBlank(message = "{NotBlank.password}")
	@Size(max = 12, min = 6, message = "{Size.password}")
	private String password;
	
}
