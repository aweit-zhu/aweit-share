package com.aweit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "jdbcCustomerDAO")
public class JdbcCustomerDAO implements CustomerDAO {

	@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;

	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO customer (NAME, AGE) VALUES (?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, customer.getName());
			ps.setInt(2, customer.getAge());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM customer WHERE CUST_ID = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"));
			}
			return customer;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> customers = new ArrayList<>();
		String sql = "SELECT * FROM customer";
		try (Connection conn = dataSource.getConnection(); Statement ps = conn.createStatement();) {
			Customer customer = null;
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				customers.add(new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age")));
			}
			return customers;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void batchInsert(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}

}
