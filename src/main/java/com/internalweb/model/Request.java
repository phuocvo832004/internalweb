package com.internalweb.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Requests")
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private Long requestId;
    
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
    
    @Column(name = "Title")
    private String title;
    
    @Column(name = "RequestType")
    private String requestType;
    
    @Column(name = "Status")
    private String status;
    
    @Column(name = "DateSubmitted")
    private Date dateSubmitted;
    
    @Column(name = "ProcessedBy")
    private String processedBy;
    
    @Column(name = "Comments")
    private String comments;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(Long requestId, User user, String title, String requestType, String status, Date dateSubmitted,
			String processedBy, String comments) {
		super();
		this.requestId = requestId;
		this.user = user;
		this.title = title;
		this.requestType = requestType;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
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
