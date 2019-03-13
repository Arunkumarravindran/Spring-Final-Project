package com.example.demo;
import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class LoginDAO {
	
	public List<String> fetchUser()
	{
		
		List<String> list =new ArrayList<String>();
	try {
	
	Driver driver=new com.mysql.jdbc.Driver();
	DriverManager.registerDriver(driver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/handson", "root", "");
	String query="select * from user_registration";
	PreparedStatement statement=(PreparedStatement) connection.prepareStatement(query);
	ResultSet rs=statement.executeQuery();
	while(rs.next())
	{
list.add(rs.getString(1));
		
	}
		
	
}catch(SQLException e)
{
	e.printStackTrace();
}
return list;

}

}
