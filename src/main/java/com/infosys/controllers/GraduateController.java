package com.infosys.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Graduate;
import com.infosys.services.GraduateService;


@RestController
@CrossOrigin("http://localhost:4200")
public class GraduateController {

    private final GraduateService graduateService;

    public GraduateController(GraduateService graduateService) {
        this.graduateService = graduateService;
    }

    
    @GetMapping("/getAllGraduates")
    public List<Graduate> getAllGraduates() {
        return graduateService.getAllGraduates();
        
    }
    
    @GetMapping("/getGraduateById/{id}")
    public Graduate getGraduateById(@PathVariable String id) {
    	return graduateService.getGraduateById(id);
    }

    @PostMapping("/addGraduate")
    public void addGraduate(@RequestBody Graduate graduate) {
        graduateService.addGraduate(graduate);
    }

    @PostMapping("/updateGraduate")
    public Graduate updateGraduate(@RequestBody Graduate graduate) {
    	return graduateService.updateGraduate(graduate.getRole().getRoleId(), graduate);
    }
    
    @DeleteMapping("/deleteGraduate")
    public void deleteGraduate(@RequestBody Graduate graduate) {
        graduateService.deleteGraduate(graduate);
    }
}
