package com.mobileapplication.app.classroom.service.response.model;

import java.util.List;

public class StudentRest {

	private String studentId;
	private String firstName;
	private String lastName;
	private String rollNumber;
	private String dob;
	private String gender;
	private String mobileNumber;
	private String organization;
	private String standard;
	private String section;
	
	private List<SubjectRest> subjectDetails;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<SubjectRest> getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(List<SubjectRest> subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

}
