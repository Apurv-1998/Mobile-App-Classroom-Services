package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = -6146437274792571772L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String studentId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String rollNumber;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String standard;
	@Column(nullable = false)
	private String organization;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String mobileNumber;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String password;
	private String emailVerificationToken;
	private boolean emailVerificationstatus = false;
	@Column(nullable = false)
	private String encryptedPassword;
	
	
	@ManyToOne
	@JoinColumn(name = "organizations_id")
	@JsonIgnore
	private OrganizationEntity organizationDetails;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public boolean isEmailVerificationstatus() {
		return emailVerificationstatus;
	}

	public void setEmailVerificationstatus(boolean emailVerificationstatus) {
		this.emailVerificationstatus = emailVerificationstatus;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public OrganizationEntity getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationEntity organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

}
