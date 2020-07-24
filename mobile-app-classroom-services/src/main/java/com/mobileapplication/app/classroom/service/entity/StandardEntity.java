package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "standards")
public class StandardEntity implements Serializable {

	private static final long serialVersionUID = -8279557602960270608L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String standardName;
	@Column(nullable = false)
	private String section;
	
	@ManyToOne
	@JoinColumn(name = "teachers_id")
	@JsonIgnore
	private TeacherEntity teacherDetails;
	
	@ManyToMany(mappedBy = "standardDetails")
	private Collection<SubjectEntity> subjectDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public TeacherEntity getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherEntity teacherDetails) {
		this.teacherDetails = teacherDetails;
	}


}
