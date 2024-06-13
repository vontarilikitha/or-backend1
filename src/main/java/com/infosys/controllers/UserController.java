package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.User;
import com.infosys.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
    	return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUserByRoleId/{roleId}")
    public void deleteUserByRoleId(@PathVariable String roleId) {
        userService.deleteUserByRoleId(roleId);
    }
    
    

    @GetMapping("/getUserByRoleId/{id}")
    public User getUserInfoByRoleId(@PathVariable String id) {
    	return userService.getUserInfoByRoleId(id);
    }
    
    @PostMapping("/updateUserByRoleId")
    public User updateUser(@RequestBody User user) {
    	return userService.updateUser(user.role.getRoleId(), user);
    }
    
    
}
