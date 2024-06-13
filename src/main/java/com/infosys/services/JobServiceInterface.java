package com.infosys.services;

import java.util.List;


import com.infosys.entities.Job;

public interface JobServiceInterface {
	
	List<Job> getAllJobs();

	Job addJob(Job job);

	Job updateJob(int id, Job job);

	void deleteJobById(int id);

	Job searchJobById(int id);
	
	public List<Job> getJobsByRoleId(String roleId);


}
