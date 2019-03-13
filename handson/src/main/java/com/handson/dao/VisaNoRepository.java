package com.handson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.handson.entity.VisaRegistration;

public interface VisaNoRepository extends JpaRepository<VisaRegistration,Long>{
	@Query("SELECT max(v.visa_No) from VisaRegistration v")
	String findbyuserid();
}
