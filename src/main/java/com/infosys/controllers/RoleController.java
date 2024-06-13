package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Role;
import com.infosys.services.RoleService;

@RestController
@CrossOrigin("http://localhost:4200")
public class RoleController {
	
	@Autowired
	RoleService service;
	
	
	@GetMapping("/getAllRoles")
	public List<Role> getAllRoles(){
		
		return service.getAllRoles();
		
	}
	
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return service.addRole(role);
	}
	/*
	@DeleteMapping("/deleteRole/{id}")
	public void deleteRoleById(@PathVariable String id) {
		service.deleteRoleById(id);
	}
	*/
	
	@GetMapping("/getRoleInfoById/{id}")
	public Role getRoleInfoById(@PathVariable String id) {
		return service.getRoleInfoById(id);
	}
	

}
