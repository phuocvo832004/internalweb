package com.internalweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internalweb.model.InternalNews;
import com.internalweb.repository.InternalNewsRepository;

@RestController
@RequestMapping("/api/internal-news")
public class InternalNewsController {

    @Autowired
    private InternalNewsRepository internalNewsRepository;
    
    @GetMapping
    public Page<InternalNews> getNotificationsByPage(@RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "9") int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);

        return internalNewsRepository.findAll(pageable);
    }
    
    @GetMapping("/{newsId}")
    public ResponseEntity<InternalNews> getNewsById(@PathVariable Long newsId) {
        Optional<InternalNews> news = internalNewsRepository.findById(newsId);
        return news.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}


