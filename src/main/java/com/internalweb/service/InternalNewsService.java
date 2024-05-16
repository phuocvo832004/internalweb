package com.internalweb.service;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.internalweb.model.InternalNews;

public interface InternalNewsService {
    List<InternalNews> findByTitleContaining(String keyword);
    Page<InternalNews> findAll(int page, int size);
    InternalNews findById(Long id);
    List<InternalNews> findByUserId(Long id);
    void save(InternalNews news);
    void deleteById(Long id);
    ResponseEntity<InternalNews> getNewsById(Long newsId);
}

