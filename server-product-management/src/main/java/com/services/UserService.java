package com.services;

import java.util.List;

import com.model.User;

public interface UserService {

	User saveUser(User user);

	void deleteUser(Long userId);

	User UpdateUser(User user);

	User findByUserName(String userName);

	List<User> findAllUsers();

	Long numbersOfUsers();

}
