package com.infosys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infosys.entities.Employer;
import com.infosys.entities.Graduate;
import com.infosys.repositories.GraduateRepository;

@Service
public class GraduateService implements GraduateServiceInterface  {
    
    private final GraduateRepository graduateRepository;

    public GraduateService(GraduateRepository graduateRepository) {
        this.graduateRepository = graduateRepository;
    }


    public List<Graduate> getAllGraduates() {
        return graduateRepository.findAll();
    }
    
    public Graduate getGraduateById(String id) {
    	return graduateRepository.getByRoleId(id);
    }
    public void addGraduate(Graduate graduate) {
        graduateRepository.save(graduate);
    }
    
    public void deleteGraduate(Graduate graduate) {
        graduateRepository.delete(graduate);
    }

    
    public Graduate updateGraduate(String id, Graduate graduate) {
        Graduate existingGraduate = graduateRepository.getByRoleId(id);
        if (existingGraduate != null) {
            
            existingGraduate.setCollegeName(graduate.getCollegeName());
            existingGraduate.setCollegeAddress(graduate.getCollegeAddress());
            existingGraduate.setGender(graduate.getGender());
            existingGraduate.setDateOfBirth(graduate.getDateOfBirth());
            existingGraduate.setAddress(graduate.getAddress());
            existingGraduate.setSkills(graduate.getSkills());
            existingGraduate.setProject(graduate.getProject());
            
            return graduateRepository.save(existingGraduate);
        } else {
            return null;
        }
    }
    /*
    public void deleteGraduateByRoleId(String roleId) {
    	graduateRepository.deleteGraduateByRoleId(roleId);
    }
	*/
}
