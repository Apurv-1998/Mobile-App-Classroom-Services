package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;

public class TeacherDto implements Serializable {

	private static final long serialVersionUID = -514408234664743707L;

	private String teacherId;
	private String firstName;
	private String lastname;
	private String regId;
	private String organization;
	private String dob;
	private String email;
	private String password;
	private String subject;

	private String emailVerificationToken;
	private boolean emailVerificationStatus;
	private String encryptedPassword;
	private String encrpytedRegId;

	private List<StandardDto> standard;

	private OrganizationDto organizationDetails;

	private AddSubjectDto subjectDetails;

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<StandardDto> getStandard() {
		return standard;
	}

	public void setStandard(List<StandardDto> standard) {
		this.standard = standard;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public boolean isEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEncrpytedRegId() {
		return encrpytedRegId;
	}

	public void setEncrpytedRegId(String encrpytedRegId) {
		this.encrpytedRegId = encrpytedRegId;
	}

	public OrganizationDto getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationDto organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	public AddSubjectDto getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(AddSubjectDto subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	@Override
	public String toString() {
		return "TeacherDto [teacherId=" + teacherId + ", firstName=" + firstName + ", lastname=" + lastname + ", regId="
				+ regId + ", organization=" + organization + ", dob=" + dob + ", email=" + email + ", password="
				+ password + ", subject=" + subject + ", emailVerificationToken=" + emailVerificationToken
				+ ", emailVerificationStatus=" + emailVerificationStatus + ", encryptedPassword=" + encryptedPassword
				+ ", encrpytedRegId=" + encrpytedRegId + ", standard=" + standard + "]";
	}

}
