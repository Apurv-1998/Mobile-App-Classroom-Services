package com.mobileapplication.app.classroom.service.request.model;

import java.util.List;

public class AddPlayGroundDetailsModel {

	private String groundName;
	private int capacity;
	private List<AddSportDetailsModel> sportDetails;

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public List<AddSportDetailsModel> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<AddSportDetailsModel> sportDetails) {
		this.sportDetails = sportDetails;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
