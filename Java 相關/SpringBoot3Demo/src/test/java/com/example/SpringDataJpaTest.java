package com.example;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.Employee;
import com.example.dao.EmployeeResposity;
import com.example.dao.Task;
import com.example.dao.TaskResposity;

@SpringBootTest
public class SpringDataJpaTest {

	@Autowired
	EmployeeResposity employeeResposity;
	
	@Autowired
	TaskResposity taskResposity;
	
	@Test
	void save() {
		
		Employee employee = Employee.builder().name("alex").build();
		employeeResposity.save(employee);
		
		Task task1 = Task.builder().employee(employee).title("Task1").build();
		Task task2 = Task.builder().employee(employee).title("Task2").build();
		
		taskResposity.save(task1);
		taskResposity.save(task2);
	}
	
	@Test
	@Transactional
	void select1() {
		
		Optional<Employee> empOptional = employeeResposity.findById(1);
	    if (empOptional.isPresent()) {
	        Employee employee = empOptional.get();
	        System.out.println(employee);
	    } else {
	        System.out.println("無此筆員工");
	    }
	}
	
	@Test
	@Transactional
	void select2() {
		
		Optional<Task> empOptional = taskResposity.findById(1);
		Task task = empOptional.get();
		System.out.println(task.getEmployee());
	}
}
