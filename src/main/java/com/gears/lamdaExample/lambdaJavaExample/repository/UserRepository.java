package com.gears.lamdaExample.lambdaJavaExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gears.lamdaExample.lambdaJavaExample.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u from User u where u.name = :name")
	public User findByName(@Param("name") String name);
	
}
