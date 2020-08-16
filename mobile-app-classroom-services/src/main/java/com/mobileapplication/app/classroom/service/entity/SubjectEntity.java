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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToMany(mappedBy = "subjectDetails", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TeacherEntity> teacherDetails;

	@OneToMany(mappedBy = "subjectDetails", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TestEntity> testDetails;

	@OneToMany(mappedBy = "subjectDetails", cascade = CascadeType.ALL)
	private List<FilesEntity> fileDetails;

	@OneToMany(mappedBy = "subjectDetails", cascade = CascadeType.ALL)
	private List<BookEntity> bookDetails;

	@ManyToMany(mappedBy = "subjectDetails")
	@JsonIgnore
	private Collection<StudentEntity> studentDetails;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "subjects_standards", joinColumns = @JoinColumn(name = "subjects_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "standards_id", referencedColumnName = "id"))
	@JsonIgnore
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

	public List<TestEntity> getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(List<TestEntity> testDetails) {
		this.testDetails = testDetails;
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

	public List<FilesEntity> getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(List<FilesEntity> fileDetails) {
		this.fileDetails = fileDetails;
	}

	public List<BookEntity> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<BookEntity> bookDetails) {
		this.bookDetails = bookDetails;
	}

	@Override
	public String toString() {
		return "SubjectEntity [id=" + id + ", subjectId=" + subjectId + ", name=" + name + ", standard=" + standard
				+ ", section=" + section + "]";
	}

}
