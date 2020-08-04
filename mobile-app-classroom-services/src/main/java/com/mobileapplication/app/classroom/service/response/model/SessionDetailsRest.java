package com.mobileapplication.app.classroom.service.response.model;

import java.util.List;

public class SessionDetailsRest {

	private String sessionId;
	private String sessionName;
	private String standard;
	private String section;

	private List<SessionsRest> sessions;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

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

	public List<SessionsRest> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionsRest> sessions) {
		this.sessions = sessions;
	}

}
