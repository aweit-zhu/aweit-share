package com.example;

public class A extends C {

	@Override
	void show() {
		System.out.println("執行 A 類別的 show 方法");
	};
	
	void test() {
		
	}
	
	public static void main(String[] args) {
//		A a = new A();
//		a.show();
		
		C aa = new A();
		aa.show();
		///aa.test(); // 編譯時期錯誤 
	}
	
}


abstract class C {
	
	void show() {
		System.out.println("執行 C 類別的 show 方法");
	};
	
}
