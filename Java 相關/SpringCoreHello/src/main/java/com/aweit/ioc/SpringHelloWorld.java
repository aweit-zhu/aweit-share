package com.aweit.ioc;

import org.springframework.stereotype.Component;

@Component(value="spring")
public class SpringHelloWorld implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Spring Hello World");
	}

}
