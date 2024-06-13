package com.infosys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.User;
import com.infosys.entities.Role;
import com.infosys.repositories.UserRepository;
import com.infosys.repositories.AppointmentsRepository;
import com.infosys.repositories.EmployerRepository;
import com.infosys.repositories.GraduateRepository;
import com.infosys.repositories.JobRepository;
import com.infosys.repositories.RoleRepository;

@Service
public class UserService implements UserServiceInterface{
    
	
    private final UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
	EmployerRepository employerRepository;
	
	@Autowired
	GraduateRepository graduateRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	@Autowired
	GraduateService graduateService;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	
    public User getUserInfoByRoleId(String roleId) {
    	return userRepository.getUserByRoleId(roleId);
    }
	
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
    	int count = 0;
    	Role role = new Role();
    	if(user.getTypeOfUser().equals("graduate") ) {
    		count = roleRepository.countByRoleIdPrefix("grd");
    		count++;
    		role.setRoleTitle("graduate");
    		role.setRoleDesc("grd");
    		role.setRoleId("grd"+String.format("%05d",count ));
    		user.setRole(role);
    		
    	}
    	else {
    		count = roleRepository.countByRoleIdPrefix("emp");
    		count++;
    		role.setRoleTitle("employer");
    		role.setRoleDesc("emp");
    		role.setRoleId("emp"+String.format("%05d",count ));
    		user.setRole(role);
    	}
    	user.setRole(role);
        return userRepository.save(user);
    }

    public void deleteUserByRoleId(String roleId) {
    	Role role = roleRepository.findById(roleId).orElse(null);
	    
	    if(role.getRoleId().charAt(0)=='g') {
	    	appointmentsRepository.deleteAppointmentsByRoleId(roleId);
	    	graduateService.deleteGraduate(graduateRepository.getByRoleId(roleId));
	    	userRepository.deleteUserByRoleId(roleId);
	    }
	    else {
	    	System.out.print("hello");
	    	jobRepository.deleteJobsByRoleId(roleId);
	    	employerRepository.deleteEmployerByRoleId(roleId);
	    	userRepository.deleteUserByRoleId(roleId);
	    	
	    }
    }

    public User updateUser(String roleId, User user) {
        User existingUser = userRepository.getUserByRoleId(roleId);
        if (existingUser != null) {
            
            existingUser.setUserName(user.getUserName());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setNationality(user.getNationality());
            existingUser.setPhoneNo(user.getPhoneNo());
            
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

	
}
