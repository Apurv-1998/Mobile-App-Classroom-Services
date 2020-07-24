package com.mobileapplication.app.classroom.service.request.model;

import java.util.List;

public class SubjectDetailsModel {

	private String name;
	private String standard;
	private String section;

	private List<CreateTeacherRequestDetailsModel> teacherDetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<CreateTeacherRequestDetailsModel> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<CreateTeacherRequestDetailsModel> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

}
