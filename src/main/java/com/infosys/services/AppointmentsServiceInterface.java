package com.infosys.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infosys.entities.Appointments;
import com.infosys.entities.Job;

public interface AppointmentsServiceInterface {
	public Appointments addAppointment(Appointments appointment);
	
	public void updateAppointment(int jobId, MultipartFile file);
	
	public List<Appointments> getAllAppointments();
	
	public List<Job> getJobsAppliedByRoleId(String roleId);
	
	public byte[] getResumeByAppointmentId(int id);
	
	public List<Appointments> getAppointmentsByRoleId(String roleId);
	
	public List<Appointments> findPendingAppointmentsById(String roleId);
	
	public List<Appointments> findAcceptedAppointmentsById(String roleId);
	
	public List<Appointments> findRejectedAppointmentsById(String roleId);
	
}
