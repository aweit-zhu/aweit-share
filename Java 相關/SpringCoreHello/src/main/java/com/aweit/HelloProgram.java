package com.aweit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aweit.aop.CustomerService;
import com.aweit.aop.CustomerServiceImpl;
import com.aweit.aspectJ.LoggingAspect;
import com.aweit.dynproxy.DynProxy;


public class HelloProgram {

	private static final Logger logger = LoggerFactory.getLogger(HelloProgram.class);
	
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		CustomerService customerService = (CustomerService) ctx.getBean("customerServiceImpl");
		
		customerService.getName();
		
		logger.info("123");

	}

}


//DynProxy proxy = (DynProxy)ctx.getBean("customer");

//CustomerService cust = (CustomerService) proxy.getProxy();

//cust.getName();