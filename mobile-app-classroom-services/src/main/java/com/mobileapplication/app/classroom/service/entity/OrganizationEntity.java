package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "organizations")
public class OrganizationEntity implements Serializable {

	private static final long serialVersionUID = -4299984160707721364L;

	@Id
	@GeneratedValue
	private long id;

	private String organizationId;
	private String name;

	@OneToMany(mappedBy = "organizationDetails")
	private List<StudentEntity> studentDetails;
	
	@OneToMany(mappedBy = "organizationDetails")
	private List<TeacherEntity> teacherDetails;

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

}
