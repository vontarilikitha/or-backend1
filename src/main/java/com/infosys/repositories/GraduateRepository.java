package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Graduate;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface GraduateRepository extends JpaRepository<Graduate, Integer>{

	@Query("SELECT g FROM Graduate g WHERE g.role.roleId = :roleId")
	Graduate getByRoleId(String roleId);
	/*
	@Query("DELETE FROM Graduate u WHERE u.role.roleId = :roleId")
	void deleteGraduateByRoleId(String roleId);
*/

}
