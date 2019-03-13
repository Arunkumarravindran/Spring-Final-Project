package com.college.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EnableJpaAuditing
@Entity
@Table(name = "College")
@EntityListeners(AuditingEntityListener.class) // this is added so that that teh created and updated by fields will be
												// populated automatically by JPA
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "college_id")
	private Long CollegeId;

	@NotBlank
	private String collegeName;

	@NotNull
	private int collegeStrength;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createddate;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateddate;

	public Long getCollegeid() {
		return CollegeId;
	}

	public void setCollegeid(Long collegeid) {
		CollegeId = collegeid;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getCollegeStrength() {
		return collegeStrength;
	}

	public void setCollegeStrength(int collegeStrength) {
		this.collegeStrength = collegeStrength;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	@Override
	public String toString() {
		return "College [Collegeid=" + CollegeId + ", CollegeName=" + collegeName + ", CollegeStrength="
				+ collegeStrength + ", createddate=" + createddate + ", updateddate=" + updateddate + "]";
	}

}
