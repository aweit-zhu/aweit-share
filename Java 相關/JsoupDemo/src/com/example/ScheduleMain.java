package com.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.bean.SemiProductStock;
import com.example.dao.SemiProductStockDao;
import com.example.jsoup.SemiProductStockUtil;

public class ScheduleMain {

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
//		SemiProductStockUtil semiProductStockUtil = ctx.getBean("semiProductStockUtil", SemiProductStockUtil.class);
//		
//		SemiProductStockDao semiProductStockDao = ctx.getBean("semiProductStockDaoImpl",SemiProductStockDao.class);
//		
//		List<SemiProductStock> semiProductStocks = semiProductStockUtil.getSemiProductStocks();
//		
//		semiProductStockDao.save(semiProductStocks);
		
		DataSource dSource = ctx.getBean("dataSource", DataSource.class);
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		
		for(int i=0; i <=10; i++) {
			jdbcTemplate.execute("select * from USER");
		}
		
	}

}
