package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sports")
public class SportEntity implements Serializable {

	private static final long serialVersionUID = -7892909525532388859L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String sportId;
	@Column(nullable = false)
	private String sportName;
	@Column(nullable = false)
	private boolean hasGround = false;

	@ManyToMany(mappedBy = "sportDetails")
	private List<TeacherEntity> teacherDetails;

	@ManyToOne
	@JoinColumn(name = "play_ground_id")
	@JsonIgnore
	private PlayGroundEntity playGroundDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSportId() {
		return sportId;
	}

	public void setSportId(String sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public boolean isHasGround() {
		return hasGround;
	}

	public void setHasGround(boolean hasGround) {
		this.hasGround = hasGround;
	}

	public List<TeacherEntity> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherEntity> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public PlayGroundEntity getPlayGroundDetails() {
		return playGroundDetails;
	}

	public void setPlayGroundDetails(PlayGroundEntity playGroundDetails) {
		this.playGroundDetails = playGroundDetails;
	}
}
