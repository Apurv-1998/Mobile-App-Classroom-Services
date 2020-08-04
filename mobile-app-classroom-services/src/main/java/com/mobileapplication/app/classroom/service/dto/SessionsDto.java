package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.Date;

public class SessionsDto implements Serializable {

	private static final long serialVersionUID = -8753695692775851287L;

	private String sessionsId;

	private Date sessionDate;
	private String startTime;
	private String endTime;
	private String sessionsPassword;

	private SessionDetailsDto sessionDetails;

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

	public SessionDetailsDto getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(SessionDetailsDto sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	@Override
	public String toString() {
		return "SessionsDto [sessionsId=" + sessionsId + ", sessionDate=" + sessionDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", sessionsPassword=" + sessionsPassword + ", sessionDetails="
				+ sessionDetails + "]";
	}

}
