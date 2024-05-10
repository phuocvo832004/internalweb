package com.internalweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internalweb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByUsername(String username);
	
}
