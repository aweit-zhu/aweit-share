package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

public class Test {

	public static void main(String[] args) {
		A b = (A)(B.builder().name("123").build());
		System.out.println(b);
	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class A {
	String name;
}

@Data
@NoArgsConstructor
@SuperBuilder
class B extends A {

}
