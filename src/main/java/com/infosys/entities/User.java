package com.infosys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
	public Role role;


	private String userName;
	private String password;
	private String userEmail;
	private String nationality;
	private String phoneNo;
	
	@Transient
	private String typeOfUser;
	
	
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	public User() {
		super();
	}
	public User(int userId, Role role, String userName, String password, String userEmail, String nationality,
			String phoneNo) {
		super();
		this.userId = userId;
		this.role = role;
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
		this.nationality = nationality;
		this.phoneNo = phoneNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/*
	@Override
	public String toString() {
		return "User [userId=" + userId + ", role=" + role + ", userName=" + userName + ", password=" + password
				+ ", userEmail=" + userEmail + ", nationality=" + nationality + ", phoneNo=" + phoneNo + "]";
	}*/		
	
}
