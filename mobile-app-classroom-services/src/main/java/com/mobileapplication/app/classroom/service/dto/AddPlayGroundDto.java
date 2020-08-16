package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;

public class AddPlayGroundDto implements Serializable {

	private static final long serialVersionUID = -5287298597468903467L;

	private String playGroundId;
	private String groundName;
	private int capacity;

	private List<AddSportDto> sportDetails;

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

	public List<AddSportDto> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<AddSportDto> sportDetails) {
		this.sportDetails = sportDetails;
	}

}
