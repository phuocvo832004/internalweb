package com.internalweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internalweb.model.Result;
import com.internalweb.repository.ResultRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<Result> findByRequestId(Long requestId) {
        return resultRepository.findByRequestRequestId(requestId);
    }

    @Override
    public List<Result> findBySender(String sender) {
        return resultRepository.findBySender(sender);
    }

    @Override
    public List<Result> findByContentContaining(String keyword) {
        return resultRepository.findByContentContaining(keyword);
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result findById(Long id) {
        Optional<Result> result = resultRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void save(Result result) {
        resultRepository.save(result);
    }

    @Override
    public void deleteById(Long id) {
        resultRepository.deleteById(id);
    }
}
