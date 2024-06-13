package com.infosys.entities;


import java.io.File;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;


@Entity
public class Appointments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int jobId;
	private String fullName;
	private String email;
	private String phoneNo;
	private String college;
	private String collegeAddress;
	private String yearOfPassing;
	private String percentage;
	private String skills;
	private String project;
	private String employerId;
	private String status;
	
	@Lob
	@Column(name="resume" , length=1000000000)
	private byte[] resume;


	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role rolea;

	
	
	public Appointments() {
		super();
	}
	
	
	
	public Appointments(int id, int jobId, String fullName, String email, String phoneNo, String college,
			String collegeAddress, String yearOfPassing, String percentage, String skills, String project,
			String employerId, String status, byte[] resume, Role rolea) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.fullName = fullName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.college = college;
		this.collegeAddress = collegeAddress;
		this.yearOfPassing = yearOfPassing;
		this.percentage = percentage;
		this.skills = skills;
		this.project = project;
		this.employerId = employerId;
		this.status = status;
		this.resume = resume;
		this.rolea = rolea;
	}



	public String getEmployerId() {
		return employerId;
	}



	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
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

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public Role getRolea() {
		return rolea;
	}

	public void setRolea(Role rolea) {
		this.rolea = rolea;
	}

	@Override
	public String toString() {
		return "Appointments [id=" + id + ", jobId=" + jobId + ", fullName=" + fullName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", college=" + college + ", collegeAddress=" + collegeAddress
				+ ", yearOfPassing=" + yearOfPassing + ", percentage=" + percentage + ", skills=" + skills
				+ ", project=" + project + ", resume=" + Arrays.toString(resume) + ", rolea=" + rolea + "]";
	}
	
	
		
	
}
