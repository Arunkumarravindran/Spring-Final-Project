package com.handson.BO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.entity.College;
import com.handson.dao.CancellationRepository;
import com.handson.dao.VisaFindRepository;
import com.handson.dao.VisaNoRepository;
import com.handson.dao.VisaRepository;
import com.handson.entity.VisaRegistration;

@Service
public class VisaBean {
	@Autowired
	VisaRepository repo;
	@Autowired
	VisaNoRepository vrepo;
	@Autowired
	VisaFindRepository vvrepo;
	@Autowired
	CancellationRepository crepo;
	

	public int fetchCost(String country, String occupation) {

		return (repo.findByName(country, occupation));

	}

	public String fetchVisano() {

		return vrepo.findbyuserid();
	}
	public VisaRegistration fetchdetails(String userid){
		return vvrepo.findByid(userid);
		
	}

	public void saveVisaDetails(VisaRegistration values) {

		values.getPassport_No();
		String Occupation = values.getOccupation();
		String userid=values.getUser_id();
		String Country = values.getDestination();
		String dop = values.getDate_Of_Apply();
		
        
		String apply = dop.substring(0, 2);
		int ye = Integer.parseInt(apply);
		int ten = ye + 10;
		String after = Integer.toString(ten);
		String dm = dop.substring(2, 10);
		String date = after.concat(dm);
		String issue = dop.substring(6, 10);
		int year = Integer.parseInt(issue);
		int tenyear = year + 10;
		String after1 = Integer.toString(tenyear);
		String before = date.substring(0, 6);
		String expiry = before.concat(after1);

		values.setDate_Of_Issue(date);
		values.setDate_Of_Expiry(expiry);
		int cost =fetchCost(Country, Occupation);
		values.setRegistration_Cost(cost);
		
		String visano = fetchVisano();
		getOccupation(values, Occupation);

		if (Occupation.equals("Student")) {
			String occ = "ST-";
			String last = visano.substring(3, 7);
			int las = Integer.parseInt(last);
			las++;
			String la = Integer.toString(las);
			String visa_No = occ.concat(la);
			values.setVisa_No(visa_No);

		}
		if (Occupation.equals("Government Employee")) {
			String occ = "GE-";
			String last = visano.substring(3, 7);
			int las = Integer.parseInt(last);
			las++;
			String la = Integer.toString(las);
			String visa_No = occ.concat(la);
			values.setVisa_No(visa_No);

		}
		if (Occupation.equals("Self Employee")) {
			String occ = "SE-";
			String last = visano.substring(3, 7);
			int las = Integer.parseInt(last);
			las++;
			String la = Integer.toString(las);
			String visa_No = occ.concat(la);
			values.setVisa_No(visa_No);

		}
		if (Occupation.equals("Private Employee")) {
			String occ = "PE-";
			String last = visano.substring(3, 7);
			int las = Integer.parseInt(last);
			las++;
			String la = Integer.toString(las);
			String visa_No = occ.concat(la);
			values.setVisa_No(visa_No);

		}
		if (Occupation.equals("Retired")) {
			String occ = "RE-";
			String last = visano.substring(3, 7);
			int las = Integer.parseInt(last);
			las++;
			String la = Integer.toString(las); 
			String visa_No = occ.concat(la);
			values.setVisa_No(visa_No);

		}
		repo.save(values);

		

	}
	

	public void getOccupation(VisaRegistration values, String Occupation) {
		if (Occupation.equals("Student")) {
			values.setVisa_Permit(2);
		}
		if (Occupation.equals("Government Employee")) {
			values.setVisa_Permit(4);
		}
		if (Occupation.equals("Self Employee")) {
			values.setVisa_Permit(1);
		}
		if (Occupation.equals("Retired")) {
			values.setVisa_Permit(3);
		}
		if (Occupation.equals("Private Employee")) {
			values.setVisa_Permit(1);
		}
	}

}
