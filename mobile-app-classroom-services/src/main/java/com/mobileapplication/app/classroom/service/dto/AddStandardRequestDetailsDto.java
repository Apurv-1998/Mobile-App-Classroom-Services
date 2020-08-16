package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;

public class AddStandardRequestDetailsDto implements Serializable {

	private static final long serialVersionUID = 5395935008287973794L;

	private String standard;
	private String section;
	private int strength;

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

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

}
