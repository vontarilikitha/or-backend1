package com.infosys.services;

import java.util.List;

import com.infosys.entities.Employer;

public interface EmployerServiceInterface {

	public List<Employer> getAllEmployers();

	void addEmployer(Employer employer);

	public void deleteEmployerByRoleId(String roleId);
	
	public Employer updateEmployer(String id, Employer employer);
	
	public Employer getEmployerById(String id);

}
