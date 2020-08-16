package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class BookEntity implements Serializable {

	private static final long serialVersionUID = -4901811822920569870L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String bookId;
	@Column(nullable = false)
	private String bookName;
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	private String standard;
	@Column(nullable = false)
	private String subject;
	@Column(nullable = false)
	private int totalCopies;
	@Column(nullable = false)
	private int noOfCopiesIssued;
	@Column(nullable = false)
	private double price;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "library_id")
	@JsonIgnore
	private LibraryEntity libraryDetails;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "subjects_id")
	@JsonIgnore
	private SubjectEntity subjectDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public int getNoOfCopiesIssued() {
		return noOfCopiesIssued;
	}

	public void setNoOfCopiesIssued(int noOfCopiesIssued) {
		this.noOfCopiesIssued = noOfCopiesIssued;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LibraryEntity getLibraryDetails() {
		return libraryDetails;
	}

	public void setLibraryDetails(LibraryEntity libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

	public SubjectEntity getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(SubjectEntity subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", bookId=" + bookId + ", bookName=" + bookName + ", author=" + author
				+ ", standard=" + standard + ", subject=" + subject + ", totalCopies=" + totalCopies
				+ ", noOfCopiesIssued=" + noOfCopiesIssued + ", price=" + price + ", libraryDetails=" + libraryDetails
				+ ", subjectDetails=" + subjectDetails + "]";
	}

}
