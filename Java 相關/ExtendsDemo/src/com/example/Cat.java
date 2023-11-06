package com.example;

public class Cat extends Animal {

	private String name;
		
	public Cat(int legs,String name) {
		super(legs);
		this.name = name;
	}
	
	public Cat(int legs) {
		super(legs);
	}

	@Override
	public void walk() {
		System.out.println("Cat walk()");
	}
	
	@Override
	public void eat() {
		System.out.println("Cat eat()");
	}

	@Override
	public void play() {
		System.out.println("Cat play()");
	}

	@Override
	public String getName() {
		return null;
	}

	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}


}
