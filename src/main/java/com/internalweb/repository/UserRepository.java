package com.internalweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internalweb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByUsername(String username);
	
	List<User> findAllByRole(String role);
	
	void deleteById(Long userId);
	
	List<User> findByFullNameContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrPositionContainingIgnoreCase(String fullName, String department, String position);
	
}
