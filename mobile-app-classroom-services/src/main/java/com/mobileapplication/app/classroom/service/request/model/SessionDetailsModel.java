package com.mobileapplication.app.classroom.service.request.model;

import java.util.List;

public class SessionDetailsModel {

	private String sessionName;
	private String standard;
	private String section;
	private List<SessionsModel> sessions;

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
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

	public List<SessionsModel> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionsModel> sessions) {
		this.sessions = sessions;
	}

}
