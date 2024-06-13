package com.infosys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Job;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface JobRepository extends JpaRepository<Job, Integer> {
    
    @Query("SELECT j FROM Job j WHERE j.roles.roleId = :roleId")
    List<Job> getJobsByRoleId(String roleId);
    
    @Modifying
	@Query("DELETE FROM Job u WHERE u.roles.roleId = :roleId")
	void deleteJobsByRoleId(String roleId);


    @Query("SELECT j FROM Job j WHERE j.jobId IN (SELECT a.jobId FROM Appointments a WHERE a.rolea.roleId = :roleId)")
    List<Job> getJobsAppliedByRoleId(String roleId);
 
    @Query("SELECT j FROM Job j WHERE j.jobId IN :jobIds")
    List<Job> findJobsByIds(List<Integer> jobIds);
    
}
