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
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import com.example.bean.SemiProductStock;
import com.example.dao.SemiProductStockDao;
import com.example.jsoup.SemiProductStockUtil;

public class ScheduleMain {

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		SemiProductStockUtil semiProductStockUtil = ctx.getBean("semiProductStockUtil", SemiProductStockUtil.class);
		
		SemiProductStockDao semiProductStockDao = ctx.getBean("semiProductStockDaoImpl",SemiProductStockDao.class);
		
		List<SemiProductStock> semiProductStocks = semiProductStockUtil.getSemiProductStocks();
		
		semiProductStockDao.save(semiProductStocks);
		
		// 通知股票服務，目的為：讓股票服務知道有更新股票資訊，請他廣播給所有 WebSocket的用戶。
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/WebSocketDemo/mvc/stock";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		System.out.println(response);
	}

}
