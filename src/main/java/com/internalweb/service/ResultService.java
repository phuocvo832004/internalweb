package com.internalweb.service;


import java.util.List;

import com.internalweb.model.Result;

public interface ResultService {
    List<Result> findByRequestId(Long requestId);
    List<Result> findBySender(String sender);
    List<Result> findByContentContaining(String keyword);
    List<Result> findAll();
    Result findById(Long id);
    void save(Result result);
    void deleteById(Long id);
}
