package com.gears.lamdaExample.lambdaJavaExample.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gears.lamdaExample.lambdaJavaExample.domain.User;
import com.gears.lamdaExample.lambdaJavaExample.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public User findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public User saveUser(String name) {
		User user = new User();
		user.setName(name);		
		return repository.save(user);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public List<User> findAllSortedByName() {
		return repository.findAll().stream()
				.sorted(Comparator.comparing(User::getName).reversed())
				.collect(Collectors.toList());
	}
	
	@Override
	public Map<Integer, List<String>> groupByAge() {
		return repository.findAll().stream()
				.collect(
						Collectors.groupingBy(
								User::getAge, 
								Collectors.mapping(User::getName, Collectors.toList())));
	}
	
	

	
}
