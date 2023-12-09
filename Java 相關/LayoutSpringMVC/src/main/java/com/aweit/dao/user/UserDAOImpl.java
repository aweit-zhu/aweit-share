package com.aweit.dao.user;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(User user) {
		String sql = "INSERT INTO USER (NAME, PASSWORD) VALUES (?, ?)";
		jdbcTemplate.update(sql, user.getUserName(), user.getPassword());
	}

	@Override
	public User findUserById(Integer userId) {
		String sql = "SELECT * FROM USER WHERE ID = ?";

		RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> {
			return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
		};

		return jdbcTemplate.queryForObject(sql, rowMapper, userId);
	}

	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM USER";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper(User.class));
	}

}
