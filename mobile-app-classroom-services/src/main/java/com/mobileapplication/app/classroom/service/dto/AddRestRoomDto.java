package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;

public class AddRestRoomDto implements Serializable {
	
	private static final long serialVersionUID = -1390074058078301300L;
	
	private String restRoomId;
	private boolean hasRestRoom;
	
	private List<AddRestDto> restDetails;

	public String getRestRoomId() {
		return restRoomId;
	}

	public void setRestRoomId(String restRoomId) {
		this.restRoomId = restRoomId;
	}

	public boolean isHasRestRoom() {
		return hasRestRoom;
	}

	public void setHasRestRoom(boolean hasRestRoom) {
		this.hasRestRoom = hasRestRoom;
	}

	public List<AddRestDto> getRestDetails() {
		return restDetails;
	}

	public void setRestDetails(List<AddRestDto> restDetails) {
		this.restDetails = restDetails;
	}
	
	

}
