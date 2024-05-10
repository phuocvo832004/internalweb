package com.internalweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;
    
    @Column(name = "Username")
    private String username;
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "FullName")
    private String fullName;
    
    @Column(name = "Phone")
    private String phone;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Position")
    private String position;
    
    @Column(name = "Department")
    private String department;
    
    @Column(name = "Role")
    private String role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String username, String password, String fullName, String phone, String email,
			String position, String department, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.position = position;
		this.department = department;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
}

