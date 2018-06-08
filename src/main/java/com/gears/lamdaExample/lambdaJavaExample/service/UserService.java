package com.gears.lamdaExample.lambdaJavaExample.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gears.lamdaExample.lambdaJavaExample.domain.User;

@Service
public interface UserService {
	
	public User findByName(String name);
	
	public User saveUser(String name);
	
	public User save(User user);

	public List<User> findAll();

	public List<User> findAllSortedByName();
	
	public Map<Integer, List<String>> groupByAge();

}
