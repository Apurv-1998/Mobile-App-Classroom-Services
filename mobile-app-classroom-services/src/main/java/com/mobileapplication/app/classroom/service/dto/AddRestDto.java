package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;

public class AddRestDto implements Serializable {

	private static final long serialVersionUID = 1441784429482914498L;
	
	private String restId;
	private String type;
	private int totalRests;
	private int occupiedRests;
	
	private AddRestRoomDto restRoomDetails;

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

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

	public AddRestRoomDto getRestRoomDetails() {
		return restRoomDetails;
	}

	public void setRestRoomDetails(AddRestRoomDto restRoomDetails) {
		this.restRoomDetails = restRoomDetails;
	}
	
}
