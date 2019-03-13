package com.handson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.entity.PassportRegistration;
	@Repository
	public interface PassportNoRepository extends JpaRepository<PassportRegistration,String>{
		@Query("select max(p.passportno) from PassportRegistration p")
		String findpassno();
}
