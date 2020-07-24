package com.mobileapplication.app.classroom.service.dto;

public class StandardDto {
	private String standardName;
	private String section;

	private TeacherDto teacherDetails;

	public TeacherDto getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherDto teacherDetails) {
		this.teacherDetails = teacherDetails;
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

	@Override
	public String toString() {
		return "StandardDto [standardName=" + standardName + ", section=" + section + ", teacherDetails="
				+ teacherDetails + "]";
	}
}
