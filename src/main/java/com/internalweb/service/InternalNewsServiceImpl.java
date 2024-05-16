package com.internalweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.internalweb.model.InternalNews;
import com.internalweb.repository.InternalNewsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InternalNewsServiceImpl implements InternalNewsService {

    @Autowired
    private InternalNewsRepository internalNewsRepository;
    
    public InternalNewsServiceImpl(InternalNewsRepository internalNewsRepository) {
        this.internalNewsRepository = internalNewsRepository;
    }

    @Override
    public List<InternalNews> findByTitleContaining(String keyword) {
        return internalNewsRepository.findByTitleContaining(keyword);
    }

    @Override
    public Page<InternalNews> findAll(int page, int size) {
    	PageRequest pageable = PageRequest.of(page - 1, size);
    	return internalNewsRepository.findAll(pageable);
    }

    @Override
    public InternalNews findById(Long id) {
        Optional<InternalNews> result = internalNewsRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void save(InternalNews news) {
        internalNewsRepository.save(news);
    }

    @Override
    public void deleteById(Long id) {
        internalNewsRepository.deleteById(id);
    }
    
    @Override
    public ResponseEntity<InternalNews> getNewsById(Long newsId) {
        Optional<InternalNews> news = internalNewsRepository.findById(newsId);
        return news.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @Override
    public List<InternalNews> findByUserId(Long id){
    	return internalNewsRepository.findByUserId(id);
    }
    
}
