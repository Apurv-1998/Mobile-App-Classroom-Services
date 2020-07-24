package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;

public class AddSubjectDto implements Serializable {

	private static final long serialVersionUID = -946445650684078715L;

	private String subjectId;
	private String name;
	private String standard;
	private String section;
	
	private List<TeacherDto> teacherDetails;
	
	private List<StudentDto> studentDetails;

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

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

	public List<TeacherDto> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherDto> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public List<StudentDto> getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(List<StudentDto> studentDetails) {
		this.studentDetails = studentDetails;
	}

}
