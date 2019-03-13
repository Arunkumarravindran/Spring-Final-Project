package com.example.demo;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.handson.entity.VisaRegistration;




public class ValidateUser {
	public void validateUser()
	
	{
		
	    System.out.println("Pass-1234");
//		String Password="amit123#";
		try {

			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/handson", "root", "");
			String query = "select passport_no,visa_no,date_of_expiry,occupation,registration_cost from visa_registration where user_id=?";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
			statement.setString(1,"Pass-1234");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String passno = rs.getString(1);
				String visano = rs.getString(2);
				String doe = rs.getString(3);
				String occu = rs.getString(4);
				int regcost = rs.getInt(5);
				System.out.println(passno);
				System.out.println(doe);
				System.out.println(occu);
				System.out.println(regcost);
				System.out.println(visano);
				}
			

	}catch(Exception e) {
		e.getMessage();
	}
	}
	public void add(){
	List list=new ArrayList();	
	list.add("11");
	list.add("3423");
	list.add("1444");
	list.add("3444423");
	list.add(1);
Iterator iterator=list.iterator();
while(iterator.hasNext()) {
System.out.println(iterator.next());
	}
	}
public static void main(String args[])  {
	ValidateUser call=new ValidateUser();
	call.add();
}
}
