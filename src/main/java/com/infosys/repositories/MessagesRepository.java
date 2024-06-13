package com.infosys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Messages;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
	

	@Query("SELECT m FROM Messages m WHERE m.toRoleId = :roleId")
	public List<Messages> getInboxMessages(String roleId);
	
	@Query("SELECT m FROM Messages m WHERE m.from.roleId = :roleId")
	public List<Messages> getOutboxMessages(String roleId);
	
	
}
