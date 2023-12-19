package com.aweit.bean;

import com.google.gson.Gson;

public class Book {

	private Integer id;
	
	private double price;
	
	private String name;

	public Book() {
		super();
	}

	public Book(Integer id, double price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
