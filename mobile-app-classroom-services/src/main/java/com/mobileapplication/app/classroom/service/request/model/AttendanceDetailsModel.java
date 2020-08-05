package com.mobileapplication.app.classroom.service.request.model;

import java.util.Date;

public class AttendanceDetailsModel {

	private Date date;
	private String standard;
	private String section;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
