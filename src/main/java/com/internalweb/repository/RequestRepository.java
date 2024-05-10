package com.internalweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internalweb.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
	
	List<Request> findByStatus(String status);
    List<Request> findByUserUserId(Long userId);
    List<Request> findByRequestType(String requestType);

}

