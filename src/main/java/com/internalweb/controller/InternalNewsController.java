package com.internalweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internalweb.model.InternalNews;
import com.internalweb.service.InternalNewsService;

@RestController
@RequestMapping("/api/internal-news")
public class InternalNewsController {

    @Autowired
    private InternalNewsService internalNewsService;

    @GetMapping
    public ResponseEntity<List<InternalNews>> getAllInternalNews() {
        List<InternalNews> internalNewsList = internalNewsService.findAll();
        return ResponseEntity.ok(internalNewsList);
    }
}


