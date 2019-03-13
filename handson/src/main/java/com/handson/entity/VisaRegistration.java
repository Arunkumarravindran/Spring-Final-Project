package com.handson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EnableJpaAuditing
@Entity
@Table(name = "Visa")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class VisaRegistration {
	private String visa_No;

	private String passport_No;
	@Id
	private String user_id;
	
	private String destination;
	
	private String occupation;
	private String date_Of_Apply;
	private String date_Of_Issue;
	private String date_Of_Expiry;
	private int registration_Cost;
	private int visa_Permit;
	private String status;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cancellationId;
	private String cancellDate;
	private int cancelFees;
	@Override
	public String toString() {
		return "VisaRegistration [ visa_No=" + visa_No + ", passport_No=" + passport_No + ", user_id="
				+ user_id + ", destination=" + destination + ", occupation=" + occupation + ", date_Of_Apply="
				+ date_Of_Apply + ", date_Of_Issue=" + date_Of_Issue + ", date_Of_Expiry=" + date_Of_Expiry
				+ ", registration_Cost=" + registration_Cost + ", visa_Permit=" + visa_Permit + ", status=" + status
				+ ", cancellationId=" + cancellationId + ", cancellDate=" + cancellDate + ", cancelFees=" + cancelFees
				+ "]";
	}
	public String getVisa_No() {
		return visa_No;
	}
	public void setVisa_No(String visa_No) {
		this.visa_No = visa_No;
	}
	public String getPassport_No() {
		return passport_No;
	}
	public void setPassport_No(String passport_No) {
		this.passport_No = passport_No;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getDate_Of_Apply() {
		return date_Of_Apply;
	}
	public void setDate_Of_Apply(String date_Of_Apply) {
		this.date_Of_Apply = date_Of_Apply;
	}
	public String getDate_Of_Issue() {
		return date_Of_Issue;
	}
	public void setDate_Of_Issue(String date_Of_Issue) {
		this.date_Of_Issue = date_Of_Issue;
	}
	public String getDate_Of_Expiry() {
		return date_Of_Expiry;
	}
	public void setDate_Of_Expiry(String date_Of_Expiry) {
		this.date_Of_Expiry = date_Of_Expiry;
	}
	public int getRegistration_Cost() {
		return registration_Cost;
	}
	public void setRegistration_Cost(int registration_Cost) {
		this.registration_Cost = registration_Cost;
	}
	public int getVisa_Permit() {
		return visa_Permit;
	}
	public void setVisa_Permit(int visa_Permit) {
		this.visa_Permit = visa_Permit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCancellationId() {
		return cancellationId;
	}
	public void setCancellationId(int cancellationId) {
		this.cancellationId = cancellationId;
	}
	public String getCancellDate() {
		return cancellDate;
	}
	public void setCancellDate(String cancellDate) {
		this.cancellDate = cancellDate;
	}
	public int getCancelFees() {
		return cancelFees;
	}
	public void setCancelFees(int cancelFees) {
		this.cancelFees = cancelFees;
	}

	

}