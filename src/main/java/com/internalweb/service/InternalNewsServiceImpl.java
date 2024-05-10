package com.internalweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internalweb.model.InternalNews;
import com.internalweb.repository.InternalNewsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InternalNewsServiceImpl implements InternalNewsService {

    @Autowired
    private InternalNewsRepository internalNewsRepository;

    @Override
    public List<InternalNews> findByTitleContaining(String keyword) {
        return internalNewsRepository.findByTitleContaining(keyword);
    }

    @Override
    public List<InternalNews> findAll() {
        return internalNewsRepository.findAll();
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
}
