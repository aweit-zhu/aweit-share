package com.example;

public class A extends C {

	@Override
	void show() {
		System.out.println("���� A ���O�� show ��k");
	};
	
	void test() {
		
	}
	
	public static void main(String[] args) {
//		A a = new A();
//		a.show();
		
		C aa = new A();
		aa.show();
		///aa.test(); // �sĶ�ɴ����~ 
	}
	
}


abstract class C {
	
	void show() {
		System.out.println("���� C ���O�� show ��k");
	};
	
}
