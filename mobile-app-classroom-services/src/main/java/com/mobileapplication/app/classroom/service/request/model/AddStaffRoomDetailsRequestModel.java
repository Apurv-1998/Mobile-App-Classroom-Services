package com.mobileapplication.app.classroom.service.request.model;

import java.util.Date;

public class AddStaffRoomDetailsRequestModel {

	private Date openingDate;
	private Date closingDate;
	
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
