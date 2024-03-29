package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	@Override
	public User UpdateUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName).orElse(null);		
	}
	@Override
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	@Override
	public Long numbersOfUsers() {
		return userRepository.count();
	}
}
