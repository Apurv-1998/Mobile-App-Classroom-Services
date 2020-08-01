package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;

public class GetFilesDetailsDto implements Serializable {

	private static final long serialVersionUID = -4897386659295444897L;

	private String standard;
	private String section;
	private String subjectName;

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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
