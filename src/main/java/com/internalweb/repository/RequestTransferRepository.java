package com.internalweb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internalweb.model.RequestTransfer;

public interface RequestTransferRepository extends JpaRepository<RequestTransfer, Long> {
	
	List<RequestTransfer> findByTransferredBy(String transferredBy);
	List<RequestTransfer> findByReceivedBy(String receivedBy);
	RequestTransfer findByRequestId(Long requestId);
}

