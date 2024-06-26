package com.internalweb.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Requests")
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Request_ID")
    private Long requestId;
    
    @Column(name = "User_ID")
    private Long userId;
    
    @Column(name = "Title")
    private String title;
    
    @Column(name = "Status")
    private String status;
    
    @Column(name = "Date_Submitted")
    private Date dateSubmitted;
    
    @Column(name = "Processed_By")
    private String processedBy;
    
    @Column(name = "Comments")
    private String comments;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Request(Long requestId, Long userId, String title, String status, Date dateSubmitted, String processedBy,
			String comments) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.title = title;
		this.status = status;
		this.dateSubmitted = dateSubmitted;
		this.processedBy = processedBy;
		this.comments = comments;
	}



	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	

	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(String processedBy) {
		this.processedBy = processedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
    
    
}
