package com.mobileapplication.app.classroom.service.request.model;

import java.util.List;

public class CreateTeacherRequestDetailsModel {

	private String firstName;
	private String lastname;
	private String regId;
	private String organization;
	private String dob;
	private String email;
	private String password;
	private String subject;
	private String role;
	private List<StandardDetailsModel> standard;

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

	public List<StandardDetailsModel> getStandard() {
		return standard;
	}

	public void setStandard(List<StandardDetailsModel> standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "CreateTeacherRequestDetailsModel [firstName=" + firstName + ", lastname=" + lastname + ", regId="
				+ regId + ", organization=" + organization + ", dob=" + dob + ", email=" + email + ", password="
				+ password + ", subject=" + subject + ", standard=" + standard + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
