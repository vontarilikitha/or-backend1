package com.infosys.services;

import java.util.List;

import com.infosys.entities.Role;

public interface RoleServiceInterface {

	List<Role> getAllRoles();

	Role addRole(Role role);

	public Role getRoleInfoById(String roleId) ;


}
