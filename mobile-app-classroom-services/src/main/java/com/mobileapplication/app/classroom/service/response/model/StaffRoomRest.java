package com.mobileapplication.app.classroom.service.response.model;

import java.util.List;

public class StaffRoomRest {

	private String staffRoomId;
	private String name;
	private int capacity;
	private List<TeacherRest> teacherDetails;

	public String getStaffRoomId() {
		return staffRoomId;
	}

	public void setStaffRoomId(String staffRoomId) {
		this.staffRoomId = staffRoomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<TeacherRest> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherRest> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

}
