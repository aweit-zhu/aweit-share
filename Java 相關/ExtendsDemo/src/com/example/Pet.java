package com.example;

public interface Pet {

	String getName();
	
	void setName(String name);
	
	void play();
	
	default void show() {
		System.out.println("show");
	}
	
	static void display() {
		System.out.println("display");
	}
	
}


