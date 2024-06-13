package com.infosys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Job;
import com.infosys.repositories.JobRepository;

@Service
public class JobService implements JobServiceInterface{

	@Autowired
	private JobRepository repository;

	public List<Job> getAllJobs(){
		return  repository.findAll();
	}
	
	public List<Job> getJobsByRoleId(String roleId){
		return repository.getJobsByRoleId(roleId);
	}
	
	public Job addJob(Job job) {
		return repository.save(job);
	}
	
	

	public Job updateJob(int id , Job job) {
		Optional<Job> optionalExistingUser = repository.findById(id);
        if (optionalExistingUser.isPresent()) {
        	
            Job existingUser = optionalExistingUser.get();
            existingUser.setJobId(job.getJobId());
            existingUser.setJobName(job.getJobName());
            existingUser.setCompany(job.getCompany());
            existingUser.setJobLocation(job.getJobLocation());
            existingUser.setJobSalary(job.getJobSalary());
            existingUser.setJobType(job.getJobType());
            existingUser.setJobDescription(job.getJobDescription());
            existingUser.setJobVacancy(job.getJobVacancy());
            existingUser.setRoles(job.getRoles());
            
            return repository.save(existingUser);
        } else {
            return null;
        }
	}

	public void deleteJobById(int id) {
		repository.deleteById(id); ;
	}

	public Job searchJobById(int id) {
		Optional<Job> optionalJob = repository.findById(id);
        return optionalJob.orElse(null);
	}

}
