package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class LoginBO extends LoginDAO{
 
		public boolean validateuser(Company list) {
//			String pass="Pass-1234";
////		if(list.equals(pass)) {
//			return true;
//			}
//				else
				return false;
//		}
		}
		public List<String> fetchUser()
		{
			LoginDAO dao=new LoginDAO();
			return(dao.fetchUser());
		}

	
	}

