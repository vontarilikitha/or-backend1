package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Job;
import com.infosys.services.JobService;

@RestController
@CrossOrigin("http://localhost:4200")
public class JobController {
	@Autowired
	JobService service;
	
	@GetMapping("/getAllJobs")
	public List<Job> getAllJobs(){
		return service.getAllJobs();
	}
	
	@GetMapping("/getJobsByRoleId/{roleId}")
	public List<Job> getJobsByRoleId(@PathVariable String roleId){
		return service.getJobsByRoleId(roleId);
	}
	
	@PostMapping("/addJob")
	public Job addJob(@RequestBody Job job) {
		return service.addJob(job);
	}
	
	@PostMapping("/updateJob/{jobId}")
	public Job updateJob(@RequestBody  Job job , @PathVariable int jobId) {
		job.setJobId(jobId);
		return service.updateJob(job.getJobId(),job);
	}
	
	
	@DeleteMapping("/deleteJob/{id}")
	public void deleteJobById(@PathVariable int id) {
		service.deleteJobById(id);
	}
	

	@GetMapping("/searchJobById/{id}")
	public Job searchJobById(@PathVariable int id) {
		return service.searchJobById(id);
	}
}
