package com.internalweb.service;


import java.util.List;

import com.internalweb.model.InternalNews;

public interface InternalNewsService {
    List<InternalNews> findByTitleContaining(String keyword);
    List<InternalNews> findAll();
    InternalNews findById(Long id);
    void save(InternalNews news);
    void deleteById(Long id);
}

