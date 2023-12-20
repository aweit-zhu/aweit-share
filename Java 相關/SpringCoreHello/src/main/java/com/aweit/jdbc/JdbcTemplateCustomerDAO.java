package com.aweit.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aweit.exception.AweitException;

@Repository("jdbcTemplateCustomerDAO")
public class JdbcTemplateCustomerDAO implements CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(
			propagation = Propagation.NESTED,
			isolation = Isolation.READ_UNCOMMITTED)
	public void insert(Customer customer) {
		String sql = "INSERT INTO customer (NAME, AGE) VALUES (?, ?)";
		jdbcTemplate.update(sql, customer.getName(), customer.getAge());
	}

	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM customer WHERE CUST_ID = ?";

		RowMapper<Customer> rowMapper = (ResultSet rs, int rowNum) -> {
			return new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3));
		};

		return jdbcTemplate.queryForObject(sql, rowMapper, custId);
	}

	@Override
	public List<Customer> findAllCustomer() {
		String sql = "SELECT * FROM customer";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void batchInsert(List<Customer> customers) {

		String sql = "INSERT INTO customer (NAME, AGE) VALUES (?, ?)";

		BatchPreparedStatementSetter bps = new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);
				ps.setString(1, customer.getName());
				ps.setInt(2, customer.getAge());
			}

			@Override
			public int getBatchSize() {
				return customers.size();
			}

		};

		jdbcTemplate.batchUpdate(sql, bps);
//		int i = 1 / 0;
	}
}
