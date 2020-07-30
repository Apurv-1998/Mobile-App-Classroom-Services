package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "scores")
public class StudentScoresEntity implements Serializable {


	private static final long serialVersionUID = 2242949085837797087L;

	
	@Id
	@GeneratedValue
	private long id;

	private String rollNumber;
	private double score;

	@ManyToOne
	@JoinColumn(name = "tests_id")
	@JsonIgnore
	private TestEntity testDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public TestEntity getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(TestEntity testDetails) {
		this.testDetails = testDetails;
	}

}
