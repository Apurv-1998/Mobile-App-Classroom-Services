package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "organizations")
public class OrganizationEntity implements Serializable {

	private static final long serialVersionUID = -4299984160707721364L;

	@Id
	@GeneratedValue
	private long id;

	private String organizationId;
	private String name;

	@OneToOne
	@JoinColumn(name = "library_id")
	private LibraryEntity libraryDetails;

	@OneToMany(mappedBy = "organizationDetails")
	private List<StudentEntity> studentDetails;

	@OneToMany(mappedBy = "organizationDetails")
	private List<TeacherEntity> teacherDetails;

	@OneToMany(mappedBy = "organizationDetails")
	private List<RestRoomEntity> restRoomDetails;

	@OneToMany(mappedBy = "organizationDetails")
	private List<StaffRoomEntity> staffRoomDetails;

	@OneToMany(mappedBy = "organizationDetails")
	private List<PlayGroundEntity> playGroundDetails;

	@Column(nullable = false)
	private boolean hasLibrary = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentEntity> getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(List<StudentEntity> studentDetails) {
		this.studentDetails = studentDetails;
	}

	public List<TeacherEntity> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherEntity> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public boolean isHasLibrary() {
		return hasLibrary;
	}

	public void setHasLibrary(boolean hasLibrary) {
		this.hasLibrary = hasLibrary;
	}

	public LibraryEntity getLibraryDetails() {
		return libraryDetails;
	}

	public void setLibraryDetails(LibraryEntity libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

	public List<RestRoomEntity> getRestRoomDetails() {
		return restRoomDetails;
	}

	public void setRestRoomDetails(List<RestRoomEntity> restRoomDetails) {
		this.restRoomDetails = restRoomDetails;
	}

	public List<StaffRoomEntity> getStaffRoomDetails() {
		return staffRoomDetails;
	}

	public void setStaffRoomDetails(List<StaffRoomEntity> staffRoomDetails) {
		this.staffRoomDetails = staffRoomDetails;
	}

	public List<PlayGroundEntity> getPlayGroundDetails() {
		return playGroundDetails;
	}

	public void setPlayGroundDetails(List<PlayGroundEntity> playGroundDetails) {
		this.playGroundDetails = playGroundDetails;
	}

}
