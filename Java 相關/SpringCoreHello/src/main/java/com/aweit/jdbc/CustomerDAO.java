package com.aweit.jdbc;

import java.util.List;

public interface CustomerDAO {

	void insert(Customer customer);

	Customer findByCustomerId(int custId);
	
	List<Customer> findAllCustomer();
	
	void batchInsert(List<Customer> customers);
}
