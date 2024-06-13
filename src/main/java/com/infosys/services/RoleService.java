package com.infosys.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Employer;
import com.infosys.entities.Role;
import com.infosys.entities.User;
import com.infosys.repositories.AppointmentsRepository;
import com.infosys.repositories.EmployerRepository;
import com.infosys.repositories.GraduateRepository;
import com.infosys.repositories.JobRepository;
import com.infosys.repositories.RoleRepository;
import com.infosys.repositories.UserRepository;

@Service
public class RoleService implements RoleServiceInterface{
	
	@Autowired
	RoleRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	public List<Role> getAllRoles() {
		return repository.findAll();
	}

	public Role addRole(Role role) {
		
		return repository.save(role);
	}
	
	

	public Role getRoleInfoById(String roleId) {
		Optional<Role> optionalUser = repository.findById(roleId);
        return optionalUser.orElse(null);
	}

}
