package com.infosys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	
	private String jobName;
	private String jobSalary;
	private String jobType;
	private String company;
	private String jobLocation;
	private String jobDescription;
	private String jobVacancy;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role roles;
	
	public Job() {
		super();
	}

	public Job(int jobId, String jobName, String jobSalary, String jobType, String company, String jobLocation,
			String jobDescription, String jobVacancy, Role roles) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobSalary = jobSalary;
		this.jobType = jobType;
		this.company = company;
		this.jobLocation = jobLocation;
		this.jobDescription = jobDescription;
		this.jobVacancy = jobVacancy;
		this.roles = roles;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobVacancy() {
		return jobVacancy;
	}

	public void setJobVacancy(String jobVacancy) {
		this.jobVacancy = jobVacancy;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", jobSalary=" + jobSalary + ", jobType=" + jobType
				+ ", company=" + company + ", jobLocation=" + jobLocation + ", jobDescription=" + jobDescription
				+ ", jobVacancy=" + jobVacancy + ", roles=" + roles + "]";
	}

	
}
