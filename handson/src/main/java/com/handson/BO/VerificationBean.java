package com.handson.BO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.dao.VerificationRepository;
import com.handson.entity.VisaCancellationVerification;

@Service
public class VerificationBean {
	@Autowired
	VerificationRepository repo;

	public void saveVerificationDetails(VisaCancellationVerification values) {
		String uid = values.getUser_id();
		String question = values.getQuestion();
		String answer = values.getAnswer();

		try {

			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/handson", "root", "");
			String query = "select hint_answer,hint_question from user_registration where user_id=?";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
			statement.setString(1, uid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String quest = rs.getString(1);
				String ans = rs.getString(2);

				if (quest.equals(question) && ans.equals(answer)) {
					values.setStatus("Cancelled");// Set Status
				}

			}

		} catch (Exception e) {
			e.getMessage();
		}

		repo.save(values);
	}

}
