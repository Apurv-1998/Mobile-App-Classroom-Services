package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;

public class AddTeacherToSportsDto implements Serializable {

	private static final long serialVersionUID = -6994534285820365472L;

	private List<AddSportDto> sportDetails;

	public List<AddSportDto> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<AddSportDto> sportDetails) {
		this.sportDetails = sportDetails;
	}

}
