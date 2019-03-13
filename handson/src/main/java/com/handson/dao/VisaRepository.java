package com.handson.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.entity.VisaRegistration;
@Repository
public interface VisaRepository extends JpaRepository<VisaRegistration,String>{
	@Query("select v.cost from VisaRegistrationCost v where v.country=:country and v.occupation=:occupation")
   int findByName(@Param("country") String country,@Param("occupation") String occupation); 
	
}
