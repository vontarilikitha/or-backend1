package com.infosys.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employer{
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
	private String company;
	private String companyAddress;
	private String sector;
	private String companySize;
	private String address;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Role role;
	
    
	
    public Employer() {
		super();
	}

	public Employer(int empId, String company, String companyAddress, String sector, String companySize, String address,
			Role role) {
		super();
		this.empId = empId;
		this.company = company;
		this.companyAddress = companyAddress;
		this.sector = sector;
		this.companySize = companySize;
		this.address = address;
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employer [empId=" + empId + ", company=" + company + ", companyAddress=" + companyAddress + ", sector="
				+ sector + ", companySize=" + companySize + ", address=" + address + ", role=" + role + "]";
	}
	
	
	
}
