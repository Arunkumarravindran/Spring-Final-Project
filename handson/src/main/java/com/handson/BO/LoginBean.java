package com.handson.BO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.dao.LoginRepository;
import com.handson.entity.UserRegistration;

@Service
public class LoginBean {
	@Autowired
	LoginRepository repo;

	public List<UserRegistration> fetchPasswordbyUserid(UserRegistration details) {
		String User_Id = details.getUser_id();
		String Password = details.getPassword();
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/handson", "root", "");
			String query = "select password from user_registration where user_id=?";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
			statement.setString(1, User_Id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				String pass = rs.getString(1);
				if (pass.equals(Password)) {
			    System.out.println("LOGIN SUCCESSFULLY");
				return repo.findByName(User_Id);

		}
	    }

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
