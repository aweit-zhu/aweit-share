package com.aweit.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "prototype")
public class HelloWorldService {

	@Autowired
	@Qualifier(value = "spring")
	private HelloWorld helloWorld;

	private HelloWorld strutsWorld;
	
	// DI by constructor
	HelloWorldService(@Qualifier(value = "struts") HelloWorld strutsWorld) {
		this.strutsWorld = strutsWorld;
	}
	
	public void sayHello() {
		helloWorld.sayHello();
	}

	public HelloWorld getStrutsWorld() {
		return strutsWorld;
	}
	
	
}
