package com.infosys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infosys.entities.Employer;
import com.infosys.entities.User;
import com.infosys.repositories.EmployerRepository;

@Service
public class EmployerService  implements EmployerServiceInterface{
    
    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public void addEmployer(Employer employer) {
        employerRepository.save(employer);
    }

    public Employer getEmployerById(String id) {
    	return employerRepository.getByRoleId(id);
    }
    
    public void deleteEmployerByRoleId(String roleId) {
    	employerRepository.deleteEmployerByRoleId(roleId);
    }
    
    public Employer updateEmployer(String id, Employer employer) {
        Employer existingEmployer = employerRepository.getByRoleId(id);
        if (existingEmployer != null) {
            
            existingEmployer.setCompany(employer.getCompany());
            existingEmployer.setCompanyAddress(employer.getCompanyAddress());
            existingEmployer.setSector(employer.getSector());
            existingEmployer.setCompanySize(employer.getCompanySize());
            existingEmployer.setAddress(employer.getAddress());
            
            return employerRepository.save(existingEmployer);
        } else {
            return null;
        }
    }
    
}
