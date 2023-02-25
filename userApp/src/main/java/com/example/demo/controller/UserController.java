package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/app")
//@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping("/getuser/{name}/{password}")
	public  ResponseEntity<User> getUser(@PathVariable ("name") String name, @PathVariable ("password") String password) {
		User user = us.findUserByUserName(name);
		if(user !=null) {
		if(user.getPassword().equals(password)) {
			return new ResponseEntity<User>(user, HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<User>(user, HttpStatus.METHOD_NOT_ALLOWED);
		}
		}
		
		return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);		
	}
	
	@GetMapping("/getuser/{id}")
	public User getUser(@PathVariable("id") int id) {
		return us.findUser(id);
	}
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@Valid  @RequestBody User user) {
		User resultUser = us.findUserByUserName(user.getUserName());
		System.out.println(resultUser);
		if(resultUser != null ) {
			return new ResponseEntity<User>(user, HttpStatus.CONFLICT);
		}
		if(resultUser == null) {
		User newUser = us.createUser(user);
		 return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		}
		
		System.out.println("Out of null"+resultUser);
		 return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/message")
	public String message() {
		return "Hi.....";
	}
}
