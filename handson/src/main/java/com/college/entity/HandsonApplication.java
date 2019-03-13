package com.college.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaAuditing
public class HandsonApplication {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(HandsonApplication.class, args);
//		Manager m = ((BeanFactory) ctx).getBean(Manager.class);
//		m.appraise();
//		Company c=ctx.getBean(Company.class);
//		c.open();
//		System.out.println("Main class");
//		LoginBO bo=ctx.getBean(LoginBO.class);
//		LoginVO vo=ctx.getBean(LoginVO.class);
//		vo.getUser_id();
//		vo.getPassword();
		CollegeBO bo = ctx.getBean(CollegeBO.class);
		College coll = new College();
		//coll.setCollegeid(1l);
		coll.setCollegeName("Nandha Engineering College");
		coll.setCollegeStrength(100);
//		coll.setCreateddate(Createddate);
//		coll.setUpdateddate(null);
		bo.addCollege(coll);
		System.out.println("The College name Is--->"+bo.fetchCollege(1));
		System.out.println("the college name is--->"+ bo.fetchColleges());
	System.out.println("Colleges by name --->"+ bo.fetchCollegesByName("ss"));
	}
}
