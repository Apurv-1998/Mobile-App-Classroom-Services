package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;

public class StudentScoresDto implements Serializable {

	private static final long serialVersionUID = -6449181091303939658L;

	private String rollNumber;
	private double score;

	private AddTestDetailsDto testDetails;

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public AddTestDetailsDto getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(AddTestDetailsDto testDetails) {
		this.testDetails = testDetails;
	}

}
