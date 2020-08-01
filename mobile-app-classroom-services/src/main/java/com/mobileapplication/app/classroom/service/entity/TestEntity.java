package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tests")
public class TestEntity implements Serializable {

	private static final long serialVersionUID = 684179760578355929L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String testId;
	@Column(nullable = false)
	private String testType;
	@Column(nullable = false)
	private String standard;
	@Column(nullable = false)
	private String section;
	@Column(nullable = false)
	private double averageScore;

	@OneToMany(mappedBy = "testDetails", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<StudentScoresEntity> studentScoresDetails;

	@ManyToOne
	@JoinColumn(name = "subjects_id")
	@JsonIgnore
	private SubjectEntity subjectDetails;

	@ManyToMany(mappedBy = "testDetails")
	@JsonIgnore
	private Collection<StudentEntity> studentDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public SubjectEntity getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(SubjectEntity subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public Collection<StudentEntity> getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(Collection<StudentEntity> studentDetails) {
		this.studentDetails = studentDetails;
	}

	public List<StudentScoresEntity> getStudentScoresDetails() {
		return studentScoresDetails;
	}

	public void setStudentScoresDetails(List<StudentScoresEntity> studentScoresDetails) {
		this.studentScoresDetails = studentScoresDetails;
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

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", testId=" + testId + ", testType=" + testType + ", standard=" + standard
				+ ", section=" + section + ", averageScore=" + averageScore + ", studentScoresDetails="
				+ studentScoresDetails + ", subjectDetails=" + subjectDetails + ", studentDetails=" + studentDetails
				+ "]";
	}

}
