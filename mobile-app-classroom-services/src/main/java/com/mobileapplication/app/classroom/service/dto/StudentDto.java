package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;

public class StudentDto implements Serializable {

	private static final long serialVersionUID = -6194290212695507805L;
	private String studentId;
	private String firstName;
	private String lastName;
	private String rollNumber;
	private String email;
	private String standard;
	private String section;
	private String organization;
	private String gender;
	private String mobileNumber;
	private String dob;
	private String password;
	private String emailVerificationToken;
	private boolean emailVerificationstatus;
	private String encryptedPassword;
	
	private OrganizationDto organizationDetails;
	
	private List<AddSubjectDto> subjectDetails;

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

	public OrganizationDto getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationDto organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<AddSubjectDto> getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(List<AddSubjectDto> subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

}
