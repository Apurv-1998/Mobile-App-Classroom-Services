package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String subjectId;
	@Column(nullable = false)
	private String name;
//	@Column(nullable = false)
	private String standard;
//	@Column(nullable = false)
	private String section;

	@OneToMany(mappedBy = "subjectDetails",cascade = CascadeType.ALL)
	private List<TeacherEntity> teacherDetails;
	
	
	@ManyToMany(mappedBy = "subjectDetails")
	private Collection<StudentEntity> studentDetails;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "subjects_standards",
	           joinColumns = @JoinColumn(name = "subjects_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "standards_id",referencedColumnName = "id"))
	private Collection<StandardEntity> standardDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public List<TeacherEntity> getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(List<TeacherEntity> teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public Collection<StudentEntity> getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(Collection<StudentEntity> studentDetails) {
		this.studentDetails = studentDetails;
	}

	public Collection<StandardEntity> getStandardDetails() {
		return standardDetails;
	}

	public void setStandardDetails(Collection<StandardEntity> standardDetails) {
		this.standardDetails = standardDetails;
	}

}
