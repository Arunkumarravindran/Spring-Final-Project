package com.handson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.entity.PassportRegistration;


@Repository
public interface PassportRepository extends JpaRepository<PassportRegistration,String>{
@Query("select max(p.temporaryId) from PassportRegistration p where p.bookletType=:type")
String findByType(@Param("type") String type );

//@Query("select p.max from PassportRegistration p where p.temporaryId=:name")
//List<PassportRegistration> findByType(@Param("name") String type );
} 