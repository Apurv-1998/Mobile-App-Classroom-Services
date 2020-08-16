package com.mobileapplication.app.classroom.service.request.model;

import java.util.List;

public class AddTeachersToSportsRequestDetailsModel {

	private List<AddSportDetailsModel> sportDetails;

	public List<AddSportDetailsModel> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<AddSportDetailsModel> sportDetails) {
		this.sportDetails = sportDetails;
	}

}
