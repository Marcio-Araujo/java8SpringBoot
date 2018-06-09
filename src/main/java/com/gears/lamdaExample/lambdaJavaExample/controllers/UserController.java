package com.gears.lamdaExample.lambdaJavaExample.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gears.lamdaExample.lambdaJavaExample.domain.User;
import com.gears.lamdaExample.lambdaJavaExample.service.UserService;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
		return service.findByName(userName);
	}
	
	@PostMapping
	public User postUser(@RequestBody User user) {
		return service.save(user);
	}
	
	@RequestMapping("/all")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@RequestMapping("/userBySortedByName")
	public List<User> findAllSorteByName(){
		return service.findAllSortedByName();
	}
	
	@RequestMapping("/userGroupByAge")
	public Map<Integer, List<String>> findAllGroupByAge(){
		return service.groupByAge();	
	}
	
	@RequestMapping("/countUnderAge")
	public Long countUnderAge(){
		return service.countUnderAge();		
	}
	
	@RequestMapping("/countUnderAge")
	public Long countOfAge(){
		return service.countOfAge();		
	}
	
	
//	@RequestMapping("/new_user/{userName}")
//	public User createUser(@PathVariable("userName") String userName) {
//		return service.saveUser(userName);
//	}
	
}
