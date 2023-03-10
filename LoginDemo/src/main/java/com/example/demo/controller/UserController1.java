package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController1 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public Object userdetails(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@GetMapping("/get/{id}")
	public Object getDetails(@PathVariable int id)
	{
		return userService.getDetailsById(id);
	} 
	
	@PostMapping("/login")
	public String loginDemo(@RequestBody User user)
	{
		return userService.userLogin(user);
	}
	
	@PostMapping("/update")
	public String pwdUpdate(@RequestBody User user)
	{
		return userService.updatePassword(user);
	}
}
