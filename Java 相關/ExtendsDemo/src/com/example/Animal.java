package com.example;

public abstract class Animal implements Pet {
	
	private static int num = 1;
	
	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	public abstract void walk();
	
	public void eat() {
		System.out.println("Animal eat().");
	}
	
	public static String queryWho(Animal animal) {
		return "�o�Ӱʪ����ǦW��XXX�W��";
	}


}


