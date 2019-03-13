package com.handson.BO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.handson.dao.CancellationRepository;
import com.handson.entity.VisaRegistration;

@Service
public class CancellationBean {
	@Autowired
	CancellationRepository repo;

	public VisaRegistration fetchdata(String userid) {
		return repo.findByUserid(userid);
	}

	public void saveCancellationDetails(VisaRegistration values) throws ParseException {
		String userid = values.getUser_id();
		String cancelldate = values.getCancellDate();
		VisaRegistration vr = fetchdata(userid);
		String passno = vr.getPassport_No();
		String visano = vr.getVisa_No();
		String doe = vr.getDate_Of_Expiry();
		String occu = vr.getOccupation();
		int regcost = vr.getRegistration_Cost();
		vr.setCancellDate(cancelldate);
		vr.setStatus("Pending");
		vr.setPassport_No(passno);// Set Passport Number
		vr.setVisa_No(visano);// Set Passport Number
		vr.setDate_Of_Expiry(doe);// Set ExpiryDate
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(doe);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(cancelldate);
		int difInDays = (int) ((date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24));
		System.out.println(difInDays);
		int month = difInDays / 30;

		if (occu.equals("Student") && month < 6) {
			int amt = regcost * 15 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);// Set Cancellation Fees

		}
		if (occu.equals("Student") && month >= 6) {
			int amt = regcost * 25 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Private Employee") && month < 6) {
			int amt = regcost * 15 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Private Employee") && month >= 6 && month < 12) {
			int amt = regcost * 25 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Private Employee") && month >= 12) {
			int amt = regcost * 20 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Government Employee") && month < 6) {
			int amt = regcost * 12 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Government Employee") && month >= 6 && month < 12) {
			int amt = regcost * 20 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Government Employee") && month >= 12) {
			int amt = regcost * 25 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Self Employee") && month < 6) {
			int amt = regcost * 15 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Self Employee") && month >= 6) {
			int amt = regcost * 25 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Retired") && month < 6) {
			int amt = regcost * 10 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}
		if (occu.equals("Retired") && month >= 6) {
			int amt = regcost * 20 / 100;
			int fine = regcost - amt;
			vr.setCancelFees(fine);

		}

		repo.save(vr);
	}

}
