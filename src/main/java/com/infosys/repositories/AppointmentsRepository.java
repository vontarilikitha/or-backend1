package com.infosys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Appointments;
import com.infosys.entities.Employer;
import com.infosys.entities.User;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AppointmentsRepository extends JpaRepository<Appointments, Integer> {

	@Modifying
	@Query("DELETE FROM Appointments u WHERE u.rolea.roleId = :roleId")
	void deleteAppointmentsByRoleId(String roleId);
	
	
	@Query("SELECT a.jobId FROM Appointments a WHERE a.rolea.roleId = :roleId")
	public List<Integer> getAppointmentsByRoleId(String roleId);


	Appointments getById(int id);

	@Query("SELECT a FROM Appointments a WHERE a.rolea.roleId = :roleId")
	List<Appointments> findAppointmentsByRoleId(String roleId);

	@Query("SELECT a FROM Appointments a WHERE a.employerId = :roleId and a.status =  'accepted'")
	List<Appointments> findAcceptedAppointmentsById(String roleId);
	

	@Query("SELECT a FROM Appointments a WHERE a.employerId = :roleId and a.status =  'rejected' ")
	List<Appointments> findRejectedAppointmentsById(String roleId);
	

	@Query("SELECT a FROM Appointments a WHERE a.employerId = :roleId and a.status = 'pending'")
	List<Appointments> findPendingAppointmentsById(String roleId);
	
}
