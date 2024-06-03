package com.internalweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internalweb.model.InternalNews;
import com.internalweb.model.Request;
import com.internalweb.model.RequestTransfer;
import com.internalweb.repository.RequestRepository;
import com.internalweb.service.RequestService;
import com.internalweb.service.RequestTransferService;

@RestController
@RequestMapping("/api/request")
public class RequestController {

	@Autowired
	private RequestService requestService;
	@Autowired
	private RequestTransferService requestTransferService;
	
	@GetMapping("/sended-request/{userId}")
	public List<Request> getSendedRequest(@PathVariable Long userId){
		return requestService.findByUserId(userId);

	}
	
	@GetMapping("/handle-request/{email}")
	public List<Request> getRequestByEmail(@PathVariable String email){
		return requestService.getRequestByEmailAndStatus(email, "Pending");
	}
	
	@GetMapping("/notes/{requestId}")
	public String getNotesByRequestId(@PathVariable Long requestId) {
		RequestTransfer requestTransfer = requestTransferService.findByRequestId(requestId);
	    return requestTransfer.getNotes();
	}

	
	@PostMapping("/create")
	public ResponseEntity<String> postRequest(@RequestBody Request request) {
		requestService.save(request);
        return new ResponseEntity<>("Một thông báo đã được tạo thành công!", HttpStatus.CREATED);

	}
	

	@PostMapping("/transfer")
	public ResponseEntity<String> postRequestTransfer(@RequestBody RequestTransfer requestTransfer){
		requestTransferService.save(requestTransfer);
		return new ResponseEntity<>("Một thông báo đã được tạo thành công!", HttpStatus.CREATED);
	}
	
	@PatchMapping("/change-status/{requestId}")
	public ResponseEntity<String> changeRequestStatus(@PathVariable Long requestId, @RequestBody Map<String, Object> updates){
		Request req = requestService.findById(requestId);
	     updates.forEach((key, value) -> {
	         switch (key) {
	             case "status":
	                 req.setStatus((String) value);
	                 break;
	             case "processedBy":
	            	 req.setProcessedBy((String) value);
	            	 break;
	         }
	     });
	     
	     requestService.save(req);
	     return new ResponseEntity<>("Thông tin cá nhân đã được cập nhật thành công", HttpStatus.OK);
	}
	
}
