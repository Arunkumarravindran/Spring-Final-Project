package com.handson.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EnableJpaAuditing
@Entity
@Table(name = "UserRegistration")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class UserRegistration {
	@NotBlank
	private String User_id;
	@NotBlank
	private String Name;
	@NotBlank
	private String Password;
	@NotBlank
	private String Qualification;
	@NotBlank
	private String EmailID;
	@NotBlank
	private int Contact;
	@NotBlank
	private String Date_Of_Birth;
	@NotBlank
	private String Apply_Type;
	@NotBlank
	private String Citizenship;
	@NotBlank
	private String Gender;
	@NotBlank
	private String Hint_Question;
	@NotBlank
	private String Hint_Answer;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Override
	public String toString() {
		return "UserRegistration [User_id=" + User_id + ", Name=" + Name + ", Password=" + Password + ", Qualification="
				+ Qualification + ", EmailID=" + EmailID + ", Contact=" + Contact + ", Date_Of_Birth=" + Date_Of_Birth
				+ ", Apply_Type=" + Apply_Type + ", Citizenship=" + Citizenship + ", Gender=" + Gender
				+ ", Hint_Question=" + Hint_Question + ", Hint_Answer=" + Hint_Answer + ", id=" + id + "]";
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailID) {
		EmailID = emailID;
	}

	public int getContact() {
		return Contact;
	}

	public void setContact(int contact) {
		Contact = contact;
	}

	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}

	public String getApply_Type() {
		return Apply_Type;
	}

	public void setApply_Type(String apply_Type) {
		Apply_Type = apply_Type;
	}

	public String getCitizenship() {
		return Citizenship;
	}

	public void setCitizenship(String citizenship) {
		Citizenship = citizenship;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getHint_Question() {
		return Hint_Question;
	}

	public void setHint_Question(String hint_Question) {
		Hint_Question = hint_Question;
	}

	public String getHint_Answer() {
		return Hint_Answer;
	}

	public void setHint_Answer(String hint_Answer) {
		Hint_Answer = hint_Answer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}