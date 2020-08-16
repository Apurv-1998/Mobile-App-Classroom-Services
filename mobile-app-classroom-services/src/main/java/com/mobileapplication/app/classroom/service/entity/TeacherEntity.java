package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teachers")
public class TeacherEntity implements Serializable {

	private static final long serialVersionUID = -8468009862743413711L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String teacherId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String regId;
	@Column(nullable = false)
	private String organization;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String subject;
	@Column(nullable = false)
	private String role;

	private String emailVerificationToken;
	private boolean emailVerificationStatus = false;
	@Column(nullable = false)
	private String encryptedPassword;
	@Column(nullable = false)
	private String encrpytedRegId;

	@OneToMany(mappedBy = "teacherDetails", cascade = CascadeType.ALL)
	private List<StandardEntity> standard;

	@OneToMany(mappedBy = "teacherDetails", cascade = CascadeType.ALL)
	private List<FilesEntity> fileDetails;

	@OneToMany(mappedBy = "teacherDetails", cascade = CascadeType.ALL)
	private List<SessionDetailsEntity> sessionDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sports_teachers", joinColumns = @JoinColumn(name = "teachers_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sports_id", referencedColumnName = "id"))
	private List<SportEntity> sportDetails;

	@ManyToOne
	@JoinColumn(name = "organizations_id")
	@JsonIgnore
	private OrganizationEntity organizationDetails;

	@ManyToOne
	@JoinColumn(name = "subjects_id")
	@JsonIgnore
	private SubjectEntity subjectDetails;

	@ManyToOne
	@JoinColumn(name = "staff_room_id")
	@JsonIgnore
	private StaffRoomEntity staffRoomDetails;

	@ManyToMany(mappedBy = "teacherDetails")
	private List<PlayGroundEntity> playGroundDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<StandardEntity> getStandard() {
		return standard;
	}

	public List<SessionDetailsEntity> getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(List<SessionDetailsEntity> sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	public void setStandard(List<StandardEntity> standard) {
		this.standard = standard;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public boolean isEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEncrpytedRegId() {
		return encrpytedRegId;
	}

	public OrganizationEntity getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationEntity organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	public void setEncrpytedRegId(String encrpytedRegId) {
		this.encrpytedRegId = encrpytedRegId;
	}

	public SubjectEntity getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(SubjectEntity subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public List<FilesEntity> getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(List<FilesEntity> fileDetails) {
		this.fileDetails = fileDetails;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public StaffRoomEntity getStaffRoomDetails() {
		return staffRoomDetails;
	}

	public void setStaffRoomDetails(StaffRoomEntity staffRoomDetails) {
		this.staffRoomDetails = staffRoomDetails;
	}

	public List<SportEntity> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<SportEntity> sportDetails) {
		this.sportDetails = sportDetails;
	}

	public List<PlayGroundEntity> getPlayGroundDetails() {
		return playGroundDetails;
	}

	public void setPlayGroundDetails(List<PlayGroundEntity> playGroundDetails) {
		this.playGroundDetails = playGroundDetails;
	}

	@Override
	public String toString() {
		return "TeacherEntity [id=" + id + ", teacherId=" + teacherId + ", firstName=" + firstName + ", lastname="
				+ lastname + ", regId=" + regId + ", organization=" + organization + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + ", subject=" + subject + ", role=" + role + ", emailVerificationToken="
				+ emailVerificationToken + ", emailVerificationStatus=" + emailVerificationStatus
				+ ", encryptedPassword=" + encryptedPassword + ", encrpytedRegId=" + encrpytedRegId + ", standard="
				+ standard + "]";
	}

}
