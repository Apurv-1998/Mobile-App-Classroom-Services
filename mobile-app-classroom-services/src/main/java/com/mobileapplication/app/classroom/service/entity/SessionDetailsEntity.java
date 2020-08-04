package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sessions_details")
public class SessionDetailsEntity implements Serializable {

	private static final long serialVersionUID = -1318213338586563860L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String sessionId;
	@Column(nullable = false)
	private String sessionName;
	@Column(nullable = false)
	private String standard;
	@Column(nullable = false)
	private String section;

	@OneToMany(mappedBy = "sessionDetails", cascade = CascadeType.ALL)
	private List<SessionsEntity> sessions;

	@ManyToOne
	@JoinColumn(name = "teachers_id")
	@JsonIgnore
	private TeacherEntity teacherDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public List<SessionsEntity> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionsEntity> sessions) {
		this.sessions = sessions;
	}

	public TeacherEntity getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherEntity teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	@Override
	public String toString() {
		return "SessionDetailsEntity [id=" + id + ", sessionId=" + sessionId + ", sessionName=" + sessionName
				+ ", standard=" + standard + ", section=" + section + ", sessions=" + sessions + ", teacherDetails="
				+ teacherDetails + ", getId()=" + getId() + ", getSessionId()=" + getSessionId() + ", getSessionName()="
				+ getSessionName() + ", getStandard()=" + getStandard() + ", getSection()=" + getSection()
				+ ", getSessions()=" + getSessions() + ", getTeacherDetails()=" + getTeacherDetails() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
