package com.mobileapplication.app.classroom.service.response.model;

public class RestsRest {
	
	private String type;
	private int totalRests;
	private int occupiedRests;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalRests() {
		return totalRests;
	}

	public void setTotalRests(int totalRests) {
		this.totalRests = totalRests;
	}

	public int getOccupiedRests() {
		return occupiedRests;
	}

	public void setOccupiedRests(int occupiedRests) {
		this.occupiedRests = occupiedRests;
	}

}
