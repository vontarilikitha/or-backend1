package com.infosys.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Graduate{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	private String collegeName;
	private String collegeAddress;
	private String gender;
	private String dateOfBirth;
	private String address;
	private String skills;
	private String project;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Role role;
	
	
	public Graduate() {
		super();
	}


	public Graduate(int id, String collegeName, String collegeAddress, String gender, String dateOfBirth,
			String address, String skills, String project, Role role) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.collegeAddress = collegeAddress;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.skills = skills;
		this.project = project;
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getCollegeAddress() {
		return collegeAddress;
	}


	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Graduate [id=" + id + ", collegeName=" + collegeName + ", collegeAddress=" + collegeAddress
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", skills=" + skills
				+ ", project=" + project + ", role=" + role + "]";
	}
	
	

		
}
