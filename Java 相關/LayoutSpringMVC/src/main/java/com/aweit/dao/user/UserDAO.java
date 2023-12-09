package com.aweit.dao.user;

import java.util.List;

public interface UserDAO {

	void save(User user);
		
	User findUserById(Integer userId);
	
	List<User> findAllUsers();
	
}
