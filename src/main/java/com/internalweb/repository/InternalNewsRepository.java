package com.internalweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.internalweb.model.InternalNews;

public interface InternalNewsRepository extends JpaRepository<InternalNews, Long> {
	
	List<InternalNews> findByTitleContainingIgnoreCase(String keyword);
	
	Page<InternalNews> findAll(Pageable pageable);
	
	List<InternalNews> findByUserId(Long userId);
	
}

