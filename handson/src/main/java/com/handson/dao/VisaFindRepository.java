package com.handson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.handson.entity.VisaRegistration;

public interface VisaFindRepository extends JpaRepository<VisaRegistration,String>{
	@Query("select v from VisaRegistration v where v.user_id=:userid")
	VisaRegistration findByid(@Param("userid") String userid); 
		
}
