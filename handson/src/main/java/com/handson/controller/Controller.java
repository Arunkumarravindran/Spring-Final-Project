package com.handson.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.entity.VisaDisplay;
import com.handson.BO.CancellationBean;
import com.handson.BO.LoginBean;
import com.handson.BO.PassportBean;
import com.handson.BO.VerificationBean;
import com.handson.BO.VisaBean;
import com.handson.entity.PassportRegistration;
import com.handson.entity.UserRegistration;
import com.handson.entity.VisaCancellation;
import com.handson.entity.VisaCancellationVerification;
import com.handson.entity.VisaRegistration;

@RestController
public class Controller {
	@Autowired
	LoginBean lb;
	@Autowired
	PassportBean pb;
	@Autowired
	VisaBean vb;
	@Autowired
	CancellationBean cb;
	@Autowired
	VerificationBean veb;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody void fetchPassword(@RequestBody UserRegistration details) {
		details.getUser_id();
		details.getPassword();
		lb.fetchPasswordbyUserid(details);

	}

	@RequestMapping(value = "/passportregistration", method = RequestMethod.POST)
	public @ResponseBody String PassportRegister(@RequestBody PassportRegistration values) {

		values.getAppType();
		String type=values.getBookletType();
		values.getCity();
		values.getCountry();
		values.getId();
		values.getIssueDate();
		values.getPin();
		values.getState();
		values.getUserId();
		values.getServiceType();
		String tempid = pb.fetchTempid(type);
		pb.savePassportDetails(values);
		return tempid;
	}

	@RequestMapping(value = "/visaregistrationmodule", method = RequestMethod.POST)
	public @ResponseBody VisaDisplay VisaRegister(@RequestBody VisaRegistration values) {
		
		values.getPassport_No();
		String occupation=values.getOccupation();
	   String userid= values.getUser_id();
		String country=values.getDestination();
		values.getDate_Of_Apply();
		int cost =vb.fetchCost(country, occupation);
		values.setRegistration_Cost(cost);
		vb.saveVisaDetails(values);
		VisaRegistration v=vb.fetchdetails(userid);
      
     String visan0=  v.getVisa_No();
       String dow= v.getDate_Of_Expiry();
      int rcost=  v.getRegistration_Cost();
      int permit=  v.getVisa_Permit();
      VisaDisplay vd=new VisaDisplay();
      vd.setVisano(visan0);
      vd.setDoe(dow);
      vd.setRcost(rcost);
      vd.setPermit(permit);
		return vd;
		
	}

	@RequestMapping(value = "/cancellvisa", method = RequestMethod.POST)
	public @ResponseBody VisaCancellation visaCancellDetails(@RequestBody VisaRegistration values) throws ParseException {
		String userid=values.getUser_id();
		values.getCancellDate();
		cb.saveCancellationDetails(values);
		VisaRegistration vr =cb.fetchdata(userid);
	int cid=	vr.getCancellationId();
	int cfees=	vr.getCancelFees();
	String Status=vr.getStatus();
	String vno=vr.getVisa_No();
		VisaCancellation vc=new VisaCancellation();
		vc.setCancelID(cid);
		vc.setCancelFee(cfees);
		vc.setStatus(Status);
		vc.setVisaNo(vno);
		return vc;
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public @ResponseBody void Authendication(@RequestBody VisaCancellationVerification values) {
		values.getUser_id();
		values.getQuestion();
		values.getAnswer();
		veb.saveVerificationDetails(values);

	}
}
