package com.mobileapplication.app.classroom.service.response.model;

import java.util.List;

public class TeacherRest {

	private String teacherId;
	private String firstName;
	private String lastname;
	private String organization;
	private String dob;
	private String email;
	private String subject;
	private List<StandardRest> standard;

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<StandardRest> getStandard() {
		return standard;
	}

	public void setStandard(List<StandardRest> standard) {
		this.standard = standard;
	}

}
