package com.handson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.entity.VisaCancellation;
import com.handson.entity.VisaRegistration;

@Repository
public interface CancellationRepository extends JpaRepository<VisaRegistration, String> {
	@Query("select v from VisaRegistration v where v.user_id=:userid")
     VisaRegistration findByUserid(@Param("userid") String userid );

}
