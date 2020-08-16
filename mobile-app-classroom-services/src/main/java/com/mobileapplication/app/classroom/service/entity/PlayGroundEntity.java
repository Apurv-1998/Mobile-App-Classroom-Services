package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "play_ground")
public class PlayGroundEntity implements Serializable {

	private static final long serialVersionUID = -7245486425302978455L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String playGroundId;
	@Column(nullable = false)
	private String groundName;
	@Column(nullable = false)
	private int capacity;

	@OneToMany(mappedBy = "playGroundDetails", cascade = CascadeType.ALL)
	private List<SportEntity> sportDetails;

	@ManyToOne
	@JoinColumn(name = "organizations_id")
	@JsonIgnore
	private OrganizationEntity organizationDetails;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "play_ground_teachers", joinColumns = @JoinColumn(name = "play_ground_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "teachers_id", referencedColumnName = "id"))
	private List<TeacherEntity> teacherDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlayGroundId() {
		return playGroundId;
	}

	public void setPlayGroundId(String playGroundId) {
		this.playGroundId = playGroundId;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<SportEntity> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<SportEntity> sportDetails) {
		this.sportDetails = sportDetails;
	}

	public OrganizationEntity getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationEntity organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	public List<TeacherEntity> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherEntity> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

}
