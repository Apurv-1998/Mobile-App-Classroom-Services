package com.mobileapplication.app.classroom.service.request.model;

public class StandardDetailsModel {

	private String standardName;
	private String section;

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "StandardDetailsModel [standardName=" + standardName + ", section=" + section + "]";
	}

}
