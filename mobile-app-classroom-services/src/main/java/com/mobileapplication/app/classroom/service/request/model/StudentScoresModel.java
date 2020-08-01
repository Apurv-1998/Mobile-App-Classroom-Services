package com.mobileapplication.app.classroom.service.request.model;

public class StudentScoresModel {

	private String rollNumber;
	private Double score;

	private AddTestScoreRequestDetailsModel testDetails;

	public AddTestScoreRequestDetailsModel getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(AddTestScoreRequestDetailsModel testDetails) {
		this.testDetails = testDetails;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
