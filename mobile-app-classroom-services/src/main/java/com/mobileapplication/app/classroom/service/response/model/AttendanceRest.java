package com.mobileapplication.app.classroom.service.response.model;

public class AttendanceRest {

	public static final double THRESHOLD = 75.0;

	private String subject;
	private double attendance;
	private int number_of_classes_to_attain_threshold;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getAttendance() {
		return attendance;
	}

	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}

	public int getNumber_of_classes_to_attain_threshold() {
		return number_of_classes_to_attain_threshold;
	}

	public void setNumber_of_classes_to_attain_threshold(int number_of_classes_to_attain_threshold) {
		this.number_of_classes_to_attain_threshold = number_of_classes_to_attain_threshold;
	}

}
