package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "files")
public class FilesEntity implements Serializable {

	private static final long serialVersionUID = -2222276296603722683L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String filesId;
	@Column(nullable = false)
	private String fileName;
	@Column(nullable = false)
	private String fileType;

	@Lob
	private byte[] data;

	public FilesEntity() {

	}

	public FilesEntity(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public FilesEntity(String filesId, String fileName, String fileType, byte[] data) {
		super();
		this.filesId = filesId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public FilesEntity(long id, String filesId, String fileName, String fileType, byte[] data) {
		super();
		this.id = id;
		this.filesId = filesId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	@ManyToOne
	@JoinColumn(name = "teachers_id")
	@JsonIgnore
	private TeacherEntity teacherDetails;

	@ManyToOne
	@JoinColumn(name = "subjects_id")
	@JsonIgnore
	private SubjectEntity subjectDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilesId() {
		return filesId;
	}

	public void setFilesId(String filesId) {
		this.filesId = filesId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public TeacherEntity getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherEntity teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public SubjectEntity getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(SubjectEntity subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

}
