package com.infosys.services;

import java.util.List;

import com.infosys.entities.Graduate;

public interface GraduateServiceInterface {

	List<Graduate> getAllGraduates();

	void addGraduate(Graduate graduate);

	void deleteGraduate(Graduate graduate);

	public Graduate updateGraduate(String id, Graduate graduate);

	Graduate getGraduateById(String id);

}
