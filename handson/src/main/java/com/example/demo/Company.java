package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Company {
//	@Autowired // example of field variable integration.
	Employee employee;

	public void open() {
		System.out.println("Company opened**");
		employee.work();
	}

	public Employee getEmployee() {
		return employee;
	}
//     @Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
 @Autowired // constructor based injection
 	public Company(Employee employee) {
 		super();
 		this.employee = employee;
 	}
}
