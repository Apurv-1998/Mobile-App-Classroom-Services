package com.mobileapplication.app.classroom.service.response.model;

import java.util.Date;

public class SessionsRest {

	private String sessionsId;
	private Date sessionDate;
	private String startTime;
	private String endTime;
	private String sessionsPassword;

	public String getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(String sessionsId) {
		this.sessionsId = sessionsId;
	}

	public Date getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSessionsPassword() {
		return sessionsPassword;
	}

	public void setSessionsPassword(String sessionsPassword) {
		this.sessionsPassword = sessionsPassword;
	}

}
