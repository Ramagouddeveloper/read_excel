package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public User findUserByUserNameAndPassword(String name, String password);

	public User findUserByUserName(String userName);
}

