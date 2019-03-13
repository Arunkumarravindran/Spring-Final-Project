package com.handson.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.entity.UserRegistration;
@Repository
public interface LoginRepository extends JpaRepository<UserRegistration, String> {
	@Query("select U.Password from UserRegistration U where U.User_id=:uname")
	List<UserRegistration> findByName(@Param("uname") String User_Id);
}
