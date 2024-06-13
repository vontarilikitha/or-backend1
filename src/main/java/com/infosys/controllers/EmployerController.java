package com.infosys.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Employer;
import com.infosys.services.EmployerService;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("/getAllEmployers")
    public List<Employer> getAllEmployers() {
    	return employerService.getAllEmployers();
    }
    
    @GetMapping("/getEmployerById/{id}")
    public Employer getEmployerById(@PathVariable String id) {
    	return employerService.getEmployerById(id);
    }

    @PostMapping("/addEmployer")
    public void addEmployer(@RequestBody Employer employer) {
        employerService.addEmployer(employer);
    }
    
    @PostMapping("/updateEmployerByRoleId")
    public Employer updateEmployer(@RequestBody Employer employer) {
    	return employerService.updateEmployer(employer.getRole().getRoleId(), employer);
    }

    /*
    @DeleteMapping("/deleteEmployer")
    public void deleteEmployer(@RequestBody Employer employer) {
        employerService.deleteEmployer(employer);
    }
    */
    
}
