package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.entities.Appointments;
import com.infosys.entities.Job;
import com.infosys.entities.Role;
import com.infosys.services.AppointmentsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AppointmentsController {

	@Autowired
	AppointmentsService appointmentsService;
	
	@PostMapping("/addAppointment")
	public Appointments addAppointment(@RequestBody Appointments appointment){
		return appointmentsService.addAppointment(appointment);
	}
	
	@PostMapping("/updateAppointment/{id}")
	public void updateAppointment(
			@PathVariable("id") int id,
			@RequestParam("file") MultipartFile file  
			
			) {
		System.out.println("in controller");
		appointmentsService.updateAppointment(id, file);
	}
	
	@PostMapping("/acceptAppointment")
	public void acceptAppointment(@RequestBody Appointments appointment) {
		appointmentsService.acceptAppointment(appointment);
	}
	
	@DeleteMapping("/deleteAppointment/{id}")
	public void deleteAppointment(@PathVariable int id) {
		appointmentsService.deleteAppointment(id);
	}
	
	@GetMapping("/getAllAppointments")
	public List<Appointments> getAllAppointments(){
		return appointmentsService.getAllAppointments();
	}
	
	@GetMapping("/getJobsAppliedByRoleId/{roleId}")
	public List<Job> getJobsAppliedByRoleId(@PathVariable String roleId){
		return appointmentsService.getJobsAppliedByRoleId(roleId);
	}
	
	@GetMapping("/getResumeByAppointmentId/{id}")
	public byte[] getResumeByAppointmentId(@PathVariable int id) {
		return appointmentsService.getResumeByAppointmentId(id);
	}
	
	@GetMapping("/getAppointmentsByRoleId/{roleId}")
	public List<Appointments> getAppointmentsByRoleId(@PathVariable String roleId){
		return appointmentsService.getAppointmentsByRoleId(roleId);
	}
	

	@GetMapping("/getRejectedAppointmentsById/{roleId}")
	public List<Appointments> findRejectedAppointmentsById( @PathVariable String roleId){
		return appointmentsService.findRejectedAppointmentsById(roleId);
	}


	@GetMapping("/getAcceptedAppointmentsById/{roleId}")
	public List<Appointments> findAcceptedAppointmentsById( @PathVariable String roleId){
		return appointmentsService.findAcceptedAppointmentsById(roleId);
	}


	@GetMapping("/getPendingAppointmentsById/{roleId}")
	public List<Appointments> findPendingAppointmentsById( @PathVariable String roleId){
		return appointmentsService.findPendingAppointmentsById(roleId);
	}

}
