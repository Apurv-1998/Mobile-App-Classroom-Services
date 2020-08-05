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
@Table(name = "attendance")
public class AttendanceEntity implements Serializable {

	private static final long serialVersionUID = 5162953449497427747L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String attendanceId;
	private Date date;
	@Column(nullable = false)
	private String standard;
	@Column(nullable = false)
	private String section;
	@Column(nullable = false)
	private boolean present = false;

	@ManyToOne
	@JoinColumn(name = "standards_id")
	@JsonIgnore
	private StandardEntity standardDetails;

	@OneToOne
	@JoinColumn(name = "sessions_id")
	private SessionsEntity sessionDetails;

	@OneToOne
	@JoinColumn(name = "students_id")
	private StudentEntity studentDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public StandardEntity getStandardDetails() {
		return standardDetails;
	}

	public void setStandardDetails(StandardEntity standardDetails) {
		this.standardDetails = standardDetails;
	}

	public SessionsEntity getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(SessionsEntity sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	public StudentEntity getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentEntity studentDetails) {
		this.studentDetails = studentDetails;
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
