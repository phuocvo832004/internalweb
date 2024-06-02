package com.internalweb.service;

import java.util.List;

import com.internalweb.model.Request;

public interface RequestService {
    List<Request> findByStatus(String status);
    List<Request> findByUserId(Long userId);
    List<Request> findAll();
    Request findById(Long id);
    void save(Request request);
    void deleteById(Long id);
	List<Request> getRequestByEmailAndStatus(String email, String status);
}
