package com.aweit.bean;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.Gson;

public class Emp {

	private int id;

	@NotBlank(message = "請輸入用戶")
	private String name;

	@Min(value = 25000, message = "最小值為25000元")
	private float salary;

	@NotBlank(message = "請輸入職業")
	private String designation;

	public Emp() {
	}

	public Emp(int id, String name, float salary, String designation) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	
}
