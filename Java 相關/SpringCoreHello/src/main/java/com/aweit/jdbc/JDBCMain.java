package com.aweit.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aweit.exception.AweitException;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

//執行時要加入: JVM 啟動參數
//--add-opens java.base/java.lang=ALL-UNNAMED
//允許 Java 9 以上版本使用反射(java.lang.reflect)內部 API

@Component("jDBCMain")
public class JDBCMain {

	public static void main(String[] args) throws AweitException{

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		CustomerDAO customerDAO = ctx.getBean("jdbcTemplateCustomerDAO",CustomerDAO.class);
		
		JDBCMain jDBCMain = ctx.getBean("jDBCMain",JDBCMain.class);
		
		jDBCMain.execute(customerDAO);
	}
	
	@Transactional(propagation = Propagation.REQUIRED
			, rollbackFor = {AweitException.class}
			,isolation = Isolation.READ_UNCOMMITTED)
	public void execute(CustomerDAO customerDAO) throws AweitException {
		Customer customer1 = new Customer("阿偉特1", 31);
		
		try {
			customerDAO.insert(customer1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			customerDAO.batchInsert(List.of(new Customer("阿偉特2", 32)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("123");
	}

}
