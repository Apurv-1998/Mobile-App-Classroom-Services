package com.mobileapplication.app.classroom.service.request.model;

import java.util.List;

public class AddTestScoreRequestDetailsModel {

	private String testType;
	private String standard;
	private String section;

	private List<StudentScoresModel> studentScoresDetails;

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	private SubjectDetailsModel subjectDetails;

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public SubjectDetailsModel getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(SubjectDetailsModel subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public List<StudentScoresModel> getStudentScoresDetails() {
		return studentScoresDetails;
	}

	public void setStudentScoresDetails(List<StudentScoresModel> studentScoresDetails) {
		this.studentScoresDetails = studentScoresDetails;
	}


}
