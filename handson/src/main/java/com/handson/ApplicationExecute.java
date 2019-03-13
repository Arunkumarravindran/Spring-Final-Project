package com.handson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.handson.BO.CancellationBean;
import com.handson.BO.PassportBean;
import com.handson.BO.VerificationBean;
import com.handson.BO.VisaBean;
@SpringBootApplication
@EnableJpaAuditing
public class ApplicationExecute {
	public static  void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(ApplicationExecute.class, args);
	ctx.getBean(PassportBean.class);
	ctx.getBean(CancellationBean.class);
	ctx.getBean(VisaBean.class);
//	ctx.getBean(VerificationBean.class);
	}
}