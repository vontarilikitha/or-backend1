package com.infosys.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.entities.Appointments;
import com.infosys.entities.Job;
import com.infosys.entities.Role;
import com.infosys.repositories.AppointmentsRepository;
import com.infosys.repositories.JobRepository;

@Service
public class AppointmentsService implements AppointmentsServiceInterface{

	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	@Autowired
	JobRepository jobRepository;

	@Override
	public Appointments addAppointment(Appointments appointment) {
	    return appointmentsRepository.save(appointment);
	}

	@Override
	public void updateAppointment(int id, MultipartFile file) {
	    Optional<Appointments> demo = appointmentsRepository.findById(id);
	    System.out.println("in service layer");
	    if (demo.isPresent()) {
	    	System.out.println("outside try");
	        try {
	            demo.get().setResume(file.getBytes());
	            System.out.println("inside try block");
	            appointmentsRepository.save(demo.get());
	        } catch (IOException e) {
	            // Handle the exception
	        	System.out.println("esception");
	        }
	    } else {
	        // Handle the case where the appointment is not found
	    }
	}

	public void acceptAppointment(Appointments appointment) {
		appointmentsRepository.save(appointment);
	}
	
	public void deleteAppointment(int id) {
		appointmentsRepository.deleteById(id);
	}

	@Override
	public List<Appointments> getAllAppointments(){
		return appointmentsRepository.findAll();
	}
	
	@Override
	public List<Appointments> getAppointmentsByRoleId(String roleId){
		return appointmentsRepository.findAppointmentsByRoleId(roleId);
	}
	
	@Override
	public List<Job> getJobsAppliedByRoleId(String roleId){
		List<Integer> jobIds =  appointmentsRepository.getAppointmentsByRoleId(roleId);
		
		return jobRepository.findJobsByIds(jobIds);
	}
	
	@Override
	public byte[] getResumeByAppointmentId(int id) {
		Appointments appointment = appointmentsRepository.getById(id);
		return appointment.getResume();
	}

	@Override
	public List<Appointments> findPendingAppointmentsById(String roleId) {
		return appointmentsRepository.findPendingAppointmentsById(roleId);
	}

	@Override
	public List<Appointments> findAcceptedAppointmentsById(String roleId) {
		return appointmentsRepository.findAcceptedAppointmentsById(roleId);
	}

	@Override
	public List<Appointments> findRejectedAppointmentsById(String roleId) {
		return appointmentsRepository.findRejectedAppointmentsById(roleId);
	}
}
