package com.mobileapplication.app.classroom.service.dto;

import java.util.List;
import java.io.Serializable;

public class OrganizationDto implements Serializable {

	private static final long serialVersionUID = -8867967537153353995L;
	private String organizationId;
	private String name;
	
	private List<StudentDto> studentDetails;
	
	private List<TeacherDto> teacherDetails;

	public List<TeacherDto> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherDto> teacherDetails) {
		this.teacherDetails = teacherDetails;
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

	public List<StudentDto> getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(List<StudentDto> studentDetails) {
		this.studentDetails = studentDetails;
	}

}
