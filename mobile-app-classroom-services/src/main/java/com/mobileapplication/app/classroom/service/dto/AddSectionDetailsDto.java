package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;

public class AddSectionDetailsDto implements Serializable {

	private static final long serialVersionUID = 2564272447585418585L;
	

	private String subjectName;
	private String standard;
	private String section;


	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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

}
