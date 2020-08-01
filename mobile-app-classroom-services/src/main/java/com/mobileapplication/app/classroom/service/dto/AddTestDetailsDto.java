package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;


public class AddTestDetailsDto implements Serializable {

	private static final long serialVersionUID = 5708356752048628751L;

	private String testId;
	private String testType;
	private String standard;
	private String section;
	private double averageScore;

	private List<StudentScoresDto> studentScoresDetails;

	public List<StudentScoresDto> getStudentScoresDetails() {
		return studentScoresDetails;
	}

	public void setStudentScoresDetails(List<StudentScoresDto> studentScoresDetails) {
		this.studentScoresDetails = studentScoresDetails;
	}

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

	private AddSubjectDto subjectDetails;

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public AddSubjectDto getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(AddSubjectDto subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

}
