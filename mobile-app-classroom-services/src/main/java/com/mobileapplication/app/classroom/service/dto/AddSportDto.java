package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;

public class AddSportDto implements Serializable {

	private static final long serialVersionUID = 869664760596601947L;

	private String sportId;
	private String sportName;
	private boolean hasGround;

	private AddPlayGroundDto playGroundDetails;

	public String getSportId() {
		return sportId;
	}

	public void setSportId(String sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public boolean isHasGround() {
		return hasGround;
	}

	public void setHasGround(boolean hasGround) {
		this.hasGround = hasGround;
	}

	public AddPlayGroundDto getPlayGroundDetails() {
		return playGroundDetails;
	}

	public void setPlayGroundDetails(AddPlayGroundDto playGroundDetails) {
		this.playGroundDetails = playGroundDetails;
	}

}
