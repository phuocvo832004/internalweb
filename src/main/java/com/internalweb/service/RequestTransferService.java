package com.internalweb.service;


import java.util.List;

import com.internalweb.model.RequestTransfer;

public interface RequestTransferService {
    List<RequestTransfer> findByTransferredBy(String transferredBy);
    List<RequestTransfer> findByReceivedBy(String receivedBy);
    List<RequestTransfer> findAll();
    void save(RequestTransfer requestTransfer);
    void deleteById(Long id);
    RequestTransfer findByRequestId(Long requestId);
}

