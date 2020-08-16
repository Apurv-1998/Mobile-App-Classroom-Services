package com.mobileapplication.app.classroom.service.response.model;

import java.util.List;

public class SportTeacherRest {

	private String firstName;
	private String lastname;
	private String regId;

	private List<SportRest> sportDetails;

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

	public List<SportRest> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<SportRest> sportDetails) {
		this.sportDetails = sportDetails;
	}

}
