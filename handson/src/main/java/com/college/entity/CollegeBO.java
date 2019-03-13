package com.college.entity;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.entity.College;
import com.college.entity.CollegeRespository;

@Service
public class CollegeBO {
	@Autowired
	CollegeRespository repo;

	public void addCollege(College coll) {
		System.out.println("College being saved");
		repo.save(coll);

	}
	
	public College fetchCollege(long collegeid) {
		
		System.out.println("College being fetched");
		Optional <College> l =  repo.findById(collegeid);
		return l.get();

	}
	public List<College> fetchColleges() {
		System.out.println("Collegess being fetched");
		 return(repo.findAll());

}
	
	public List<College> fetchCollegesByName(String collegename) {
		System.out.println("Colleges being fetched");
		 return(repo.findByName(collegename));

	}
}
