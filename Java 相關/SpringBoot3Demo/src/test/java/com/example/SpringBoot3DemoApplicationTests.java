package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class SpringBoot3DemoApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	void contextLoads() throws SQLException {
		
		boolean result = jdbcTemplate.getDataSource().getConnection().isValid(1000);
		
		assertThat(result).isEqualTo(true);
	}

}
