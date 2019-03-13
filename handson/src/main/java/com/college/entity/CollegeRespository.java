package com.college.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.college.entity.College;

@Repository
public interface CollegeRespository extends JpaRepository<College, Long> {
	
	
	@Query("select c from College c where c.collegeName like CONCAT('%',:name,'%')")
    List<College> findByName(@Param("name") String collegename);

}
	


