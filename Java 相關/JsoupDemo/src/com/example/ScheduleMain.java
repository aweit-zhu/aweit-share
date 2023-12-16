package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.bean.SemiProductStock;
import com.example.dao.SemiProductStockDao;
import com.example.jsoup.SemiProductStockUtil;

public class ScheduleMain {

	public static void main(String[] args) throws SQLException, IOException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		SemiProductStockUtil semiProductStockUtil = ctx.getBean("semiProductStockUtil", SemiProductStockUtil.class);
		
		List<SemiProductStock> semiProductStocks = semiProductStockUtil.getSemiProductStocks();
		
		SemiProductStockDao semiProductStockDao = ctx.getBean("semiProductStockDaoImpl",SemiProductStockDao.class);
				
		semiProductStockDao.save(semiProductStocks);
	}

}
