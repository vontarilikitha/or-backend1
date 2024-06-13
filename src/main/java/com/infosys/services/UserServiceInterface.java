package com.infosys.services;

import java.util.List;

import com.infosys.entities.User;

public interface UserServiceInterface {

	public User updateUser(String roleId, User user);

	List<User> getAllUsers();

	User addUser(User user);

	public void deleteUserByRoleId(String roleId);

    public User getUserInfoByRoleId(String roleId);
}
