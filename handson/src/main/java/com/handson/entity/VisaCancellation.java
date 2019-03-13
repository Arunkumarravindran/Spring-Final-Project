package com.handson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EnableJpaAuditing
@Entity
@Table(name = "VisaCancellation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class VisaCancellation {
	@Id
	private String visaNo;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cancelID;
	private int cancelFee;
	private String status;

	
	@Override
	public String toString() {
		return "VisaCancellation [visaNo=" + visaNo + ", cancelID=" + cancelID + ", cancelFee=" + cancelFee
				+ ", status=" + status + "]";
	}

	

	public String getVisaNo() {
		return visaNo;
	}

	public void setVisaNo(String visaNo) {
		this.visaNo = visaNo;
	}

	public int getCancelID() {
		return cancelID;
	}

	public void setCancelID(int cancelID) {
		this.cancelID = cancelID;
	}

	

	public int getCancelFee() {
		return cancelFee;
	}

	public void setCancelFee(int cancelFee) {
		this.cancelFee = cancelFee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
