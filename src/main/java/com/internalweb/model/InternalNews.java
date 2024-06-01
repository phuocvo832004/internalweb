package com.internalweb.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Internal_News")
public class InternalNews {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "News_ID")
    private Long newsId;
    
    @Column(name = "Title")
    private String title;
    
    @Column(name = "Content")
    @Lob
    private String content;
    
    @Column(name = "Author")
    private String author;
    
    @Column(name = "Date_Posted")
    private Date datePosted;
    
    @Column(name = "User_ID")
    private Long userId;

	public InternalNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternalNews(Long newsId, String title, String content, String author, Date datePosted, Long userId) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.content = content;
		this.author = author;
		this.datePosted = datePosted;
		this.userId = userId;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
	
    
}

