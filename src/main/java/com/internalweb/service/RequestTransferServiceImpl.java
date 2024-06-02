package com.internalweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internalweb.model.RequestTransfer;
import com.internalweb.repository.RequestTransferRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RequestTransferServiceImpl implements RequestTransferService {

    @Autowired
    private RequestTransferRepository requestTransferRepository;

    @Override
    public List<RequestTransfer> findByTransferredBy(String transferredBy) {
        return requestTransferRepository.findByTransferredBy(transferredBy);
    }

    @Override
    public List<RequestTransfer> findByReceivedBy(String receivedBy) {
        return requestTransferRepository.findByReceivedBy(receivedBy);
    }

    @Override
    public List<RequestTransfer> findAll() {
        return requestTransferRepository.findAll();
    }

    @Override
    public RequestTransfer findById(Long id) {
        Optional<RequestTransfer> result = requestTransferRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void save(RequestTransfer requestTransfer) {
        requestTransferRepository.save(requestTransfer);
    }

    @Override
    public void deleteById(Long id) {
        requestTransferRepository.deleteById(id);
    }
    
    @Override
    public String findByRequestId(Long requestId) {
    	return requestTransferRepository.findByRequestId(requestId);
    }
}
