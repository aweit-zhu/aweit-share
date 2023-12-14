package com.aweit.ioc;

import org.springframework.stereotype.Component;

@Component(value = "struts")
public class StrutsHelloWorld implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Struts Hello World");
	}

}
