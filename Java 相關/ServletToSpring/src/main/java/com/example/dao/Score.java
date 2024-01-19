package com.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

	Integer studentId;
	
	String studentName;
	
	Integer chinese;
	
	Integer english;
	
	Integer math;
	
	Integer science;
	
	Integer social;
}
