package com.internalweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.internalweb.model.InternalNews;

public interface InternalNewsRepository extends JpaRepository<InternalNews, Long> {
	
	List<InternalNews> findByTitleContaining(String keyword);
	
}

