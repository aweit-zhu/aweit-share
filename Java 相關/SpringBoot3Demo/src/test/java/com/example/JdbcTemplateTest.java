package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@SpringBootTest
public class JdbcTemplateTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	@Order(1)
	//@Transactional
	void save() {
		String name = "Aweit";
		String sql = "insert into employee(name) values (?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((Connection con) -> {
			PreparedStatement ps = con.prepareStatement(sql, new String[] { "id" });
			ps.setString(1, name);
			return ps;
		}, keyHolder);
		
		Number employeeId = keyHolder.getKey();
		
		String title = "完成專案";
		String sql2 = "insert into task(title,employee_id) values (?,?)";
		jdbcTemplate.update(sql2, title,employeeId);
		
	}
}
