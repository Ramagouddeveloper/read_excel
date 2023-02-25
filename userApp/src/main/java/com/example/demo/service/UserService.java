package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	
	
	public User findUser(String name, String password) {
		
		return ud.findUserByUserNameAndPassword(name, password);
	}
	
public User findUser(int id) {
		
		return ud.findById(id).orElse(null);
	}
	
	public User createUser(User user) {
		return ud.save(user);
	}

	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return ud.findUserByUserName(userName);
	}

}
