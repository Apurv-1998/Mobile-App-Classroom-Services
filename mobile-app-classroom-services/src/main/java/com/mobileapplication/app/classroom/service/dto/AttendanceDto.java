package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.Date;

public class AttendanceDto implements Serializable {

	private static final long serialVersionUID = 8164850684316074878L;

	private String attendanceId;
	private Date date;
	private String standard;
	private String section;
	private boolean present;

	public String getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
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
