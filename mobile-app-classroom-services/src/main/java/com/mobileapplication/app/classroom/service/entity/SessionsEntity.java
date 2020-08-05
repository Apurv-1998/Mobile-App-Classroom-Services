package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sessions")
public class SessionsEntity implements Serializable {

	private static final long serialVersionUID = 2907941676379020638L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String sessionsId;

	@Column(nullable = false)
	private Date sessionDate;
	@Column(nullable = false)
	private String startTime;
	@Column(nullable = false)
	private String endTime;
	@Column(nullable = false)
	private String sessionsPassword;

	@ManyToOne
	@JoinColumn(name = "sessions_details_id")
	@JsonIgnore
	private SessionDetailsEntity sessionDetails;

	@OneToOne
	@JoinColumn(name = "attendance_id")
	private AttendanceEntity attendanceDetails;

	public AttendanceEntity getAttendanceDetails() {
		return attendanceDetails;
	}

	public void setAttendanceDetails(AttendanceEntity attendanceDetails) {
		this.attendanceDetails = attendanceDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public SessionDetailsEntity getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(SessionDetailsEntity sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	@Override
	public String toString() {
		return "SessionsEntity [id=" + id + ", sessionsId=" + sessionsId + ", sessionDate=" + sessionDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", sessionsPassword=" + sessionsPassword + "]";
	}

}
