package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.Date;

public class AddStaffRoomDto implements Serializable {

	private static final long serialVersionUID = -325795151138029376L;

	private String staffRoomId;
	private boolean hasStaffRoom;
	private int capacity;
	private String name;
	private Date openingDate;
	private Date closingDate;

	public String getStaffRoomId() {
		return staffRoomId;
	}

	public void setStaffRoomId(String staffRoomId) {
		this.staffRoomId = staffRoomId;
	}

	public boolean isHasStaffRoom() {
		return hasStaffRoom;
	}

	public void setHasStaffRoom(boolean hasStaffRoom) {
		this.hasStaffRoom = hasStaffRoom;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

}
