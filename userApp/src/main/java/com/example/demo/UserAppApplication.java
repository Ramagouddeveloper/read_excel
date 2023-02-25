package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;

@SpringBootApplication
public class UserAppApplication implements CommandLineRunner{

	@Autowired
	private UserController uc;
	
	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User();
		
		user.setUserName("Ramu");
		user.setPassword("123");
		
		uc.createUser(user);
		
	}
	
	@Bean
	public WebMvcConfigurer corsConfigure() {
		
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registery) {
				registery.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}

}
