package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "staff_room")
public class StaffRoomEntity implements Serializable {

	private static final long serialVersionUID = 3175592972038377290L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String staffRoomId;
	@Column(nullable = false)
	private boolean hasStaffRoom = false;
	@Column(nullable = false)
	private int capacity;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Date openingDate;
	@Column(nullable = false)
	private Date closingDate;

	@OneToOne
	@JoinColumn(name = "floors_id")
	private FloorEntity floorDetails;

	@OneToMany(mappedBy = "staffRoomDetails", cascade = CascadeType.ALL)
	private List<TeacherEntity> teacherDetails;

	@ManyToOne
	@JoinColumn(name = "organizations_id")
	@JsonIgnore
	private OrganizationEntity organizationDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaffRoomId() {
		return staffRoomId;
	}

	public void setStaffRoomId(String staffRoomId) {
		this.staffRoomId = staffRoomId;
	}

	public boolean isHasStaffRoom() {
		return hasStaffRoom;
	}

	public void setHasStaffRoom(boolean hasStaffRoom) {
		this.hasStaffRoom = hasStaffRoom;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public FloorEntity getFloorDetails() {
		return floorDetails;
	}

	public void setFloorDetails(FloorEntity floorDetails) {
		this.floorDetails = floorDetails;
	}

	public List<TeacherEntity> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherEntity> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public OrganizationEntity getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationEntity organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

}
