package com.handson.BO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.dao.PassportNoRepository;
import com.handson.dao.PassportRepository;
import com.handson.entity.PassportRegistration;

@Service
public class PassportBean {
	@Autowired
	PassportRepository repo;
	@Autowired
	PassportNoRepository prepo;

	public String fetchTempid(String type) {
		return repo.findByType(type);
	}

	public String fetchPassno() {
		return prepo.findpassno();

	}

	public void savePassportDetails(PassportRegistration values) {
		values.getAppType();
		String type = values.getBookletType();
		values.getCity();
		values.getCountry();
		values.getId();
		String issuedate = values.getIssueDate();
		values.getPin();
		values.getState();
		values.getUserId();
		String service = values.getServiceType();
		String tempid = fetchTempid(type);
		String passno = fetchPassno();
		if (service.equals("Normal")) {
			values.setPassportFees(2500);

		}

		if (service.equals("Tatkal")) {
			values.setPassportFees(5000);

		}

		String first = tempid.substring(0, 6);
		String last = tempid.substring(6, 8);
		int las = Integer.parseInt(last);
		las++;
		String la = Integer.toString(las);
		String temporaryid = first.concat(la);
		values.setTemporaryId(temporaryid);// Set Temporary Id

		String passportno = passno;
		String num = passportno.substring(4, 8);
		int number = Integer.parseInt(num);
		number++;
		String last1 = Integer.toString(number);
		String ind = "IND-";
		String pass = ind.concat(last1);
		values.setPassportno(pass);// Set Passport Number

		String year = issuedate.substring(6, 10);
		int ye = Integer.parseInt(year);
		int ten = ye + 10;
		String after = Integer.toString(ten);
		String dm = issuedate.substring(0, 6);
		String date = dm.concat(after);
		values.setExpiryDate(date);// Set ExpiryDate

		repo.save(values);
	}

}
