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
@Table(name = "PassportRegistration")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class PassportRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long id;
	public String temporaryId;
	@NotBlank
	public String userId;
	@NotBlank
	public String country;
	@NotBlank
	public String state;
	@NotBlank
	public String city;
	public int pin;
	@NotBlank
	public String appType;
	@NotBlank
	public String bookletType;
	@NotBlank
	public String issueDate;
	public String expiryDate;
	public String passportno;
	@NotBlank
	public String serviceType;
	public int passportFees;

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public int getPassportFees() {
		return passportFees;
	}

	public void setPassportFees(int passportFees) {
		this.passportFees = passportFees;
	}

	public String getPassportno() {
		return passportno;
	}

	public void setPassportno(String passportno) {
		this.passportno = passportno;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "PassportRegistration [id=" + id + ", temporaryId=" + temporaryId + ", userId=" + userId + ", country="
				+ country + ", state=" + state + ", city=" + city + ", pin=" + pin + ", appType=" + appType
				+ ", bookletType=" + bookletType + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate
				+ ", passportno=" + passportno + ", serviceType=" + serviceType + ", passportFees=" + passportFees
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTemporaryId() {
		return temporaryId;
	}

	public void setTemporaryId(String temporaryId) {
		this.temporaryId = temporaryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getBookletType() {
		return bookletType;
	}

	public void setBookletType(String bookletType) {
		this.bookletType = bookletType;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
}
