package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.redis.Student;
import com.example.redis.StudentRepository;

@SpringBootTest
public class RedisTest {

	@Autowired
	StudentRepository studentRepository;

	//@Test
	void save() {
		Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
		studentRepository.save(student);
		
		Student student2 = new Student("Eng2015002", "Aweit Zhu", Student.Gender.MALE, 3);
		studentRepository.save(student2);
	}
	
	@Test
	void update() {
		Student retrievedStudent = 
				  studentRepository.findById("Eng2015001").get();
		retrievedStudent.setName("Richard Watson");
		studentRepository.save(retrievedStudent);
		System.out.println(retrievedStudent);
	}
}
