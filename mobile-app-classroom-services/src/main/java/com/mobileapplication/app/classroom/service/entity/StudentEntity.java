package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = -6146437274792571772L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String studentId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String rollNumber;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String standard;
	@Column(nullable = false)
	private String section;
	@Column(nullable = false)
	private String organization;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String mobileNumber;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String password;
	private String emailVerificationToken;
	private boolean emailVerificationstatus = false;
	@Column(nullable = false)
	private String encryptedPassword;

	@Column(nullable = true)
	private String loginTime;
	@Column(nullable = true)
	private String logoutTime;

	private boolean isSignedIn = false;

	@ManyToOne
	@JoinColumn(name = "organizations_id")
	@JsonIgnore
	private OrganizationEntity organizationDetails;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "students_subjects", joinColumns = @JoinColumn(name = "students_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "subjects_id", referencedColumnName = "id"))
	private Collection<SubjectEntity> subjectDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "students_tests", joinColumns = @JoinColumn(name = "students_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tests_id", referencedColumnName = "id"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<TestEntity> testDetails;

	@OneToOne
	@JoinColumn(name = "attendance_id")
	private AttendanceEntity attendanceDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public boolean isEmailVerificationstatus() {
		return emailVerificationstatus;
	}

	public void setEmailVerificationstatus(boolean emailVerificationstatus) {
		this.emailVerificationstatus = emailVerificationstatus;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public OrganizationEntity getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationEntity organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	public String getSection() {
		return section;
	}

	public Collection<SubjectEntity> getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(Collection<SubjectEntity> subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Collection<TestEntity> getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(Collection<TestEntity> testDetails) {
		this.testDetails = testDetails;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public boolean isSignedIn() {
		return isSignedIn;
	}

	public void setSignedIn(boolean isSignedIn) {
		this.isSignedIn = isSignedIn;
	}

	public AttendanceEntity getAttendanceDetails() {
		return attendanceDetails;
	}

	public void setAttendanceDetails(AttendanceEntity attendanceDetails) {
		this.attendanceDetails = attendanceDetails;
	}

}
