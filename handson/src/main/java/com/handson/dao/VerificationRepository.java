package com.handson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handson.entity.VisaCancellationVerification;
@Repository
public interface VerificationRepository extends JpaRepository<VisaCancellationVerification,String>{

		
}
