package com.internalweb.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Result")
public class Result {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResultID")
    private Long resultId;
    
    @ManyToOne
    @JoinColumn(name = "RequestID")
    private Request request;
    
    @Column(name = "Sender")
    private String sender;
    
    @Column(name = "Content")
    @Lob
    private String content;
    
    @Column(name = "SentDate")
    private Date sentDate;
    
    @Column(name = "Notes")
    private String notes;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(Long resultId, Request request, String sender, String content, Date sentDate, String notes) {
		super();
		this.resultId = resultId;
		this.request = request;
		this.sender = sender;
		this.content = content;
		this.sentDate = sentDate;
		this.notes = notes;
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    
}

