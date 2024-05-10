package com.internalweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internalweb.model.Request;
import com.internalweb.repository.RequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> findByStatus(String status) {
        return requestRepository.findByStatus(status);
    }

    @Override
    public List<Request> findByUserId(Long userId) {
        return requestRepository.findByUserUserId(userId);
    }

    @Override
    public List<Request> findByRequestType(String requestType) {
        return requestRepository.findByRequestType(requestType);
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request findById(Long id) {
        Optional<Request> result = requestRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void save(Request request) {
        requestRepository.save(request);
    }

    @Override
    public void deleteById(Long id) {
        requestRepository.deleteById(id);
    }
}

