package com.aweit.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

//		CustomerDAO customerDAO = (CustomerDAO) ctx.getBean("jdbcCustomerDAO");
		
		CustomerDAO customerDAO = (CustomerDAO) ctx.getBean("jdbcTemplateCustomerDAO");
		
		Customer customer1 = new Customer("阿偉特1", 31);
		Customer customer2 = new Customer("阿偉特2", 32);
		Customer customer3 = new Customer("阿偉特3", 33);
		
		List<Customer> customers = List.of(customer1,customer2,customer3);
		customerDAO.batchInsert(customers);

//		Customer customer1 = customerDAO.findByCustomerId(2);
//		System.out.println(customer1);

		System.out.println(customerDAO.findAllCustomer());
	}

}
