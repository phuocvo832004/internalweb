package com.internalweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internalweb.model.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
	
	List<Result> findByRequestRequestId(Long requestId);
	List<Result> findBySender(String sender);
	List<Result> findByContentContaining(String keyword);

}
