package com.mobileapplication.app.classroom.service.response.model;

import java.util.List;

public class PlayGroundRest {
	
	private String playGroundId;
	private String groundName;
	private int capacity;
	
	private List<SportRest> sportDetails;

	public String getPlayGroundId() {
		return playGroundId;
	}

	public void setPlayGroundId(String playGroundId) {
		this.playGroundId = playGroundId;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<SportRest> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<SportRest> sportDetails) {
		this.sportDetails = sportDetails;
	}
}
