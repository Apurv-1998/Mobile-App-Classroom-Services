package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;

public class AddBooksDetailsDto implements Serializable {

	private static final long serialVersionUID = -6010499881485802761L;

	private String bookId;
	private String bookName;
	private String author;
	private String standard;
	private String subject;
	private int totalCopies;
	private int noOfCopiesIssued;
	private double price;

	private AddLibraryDetailsDto libraryDetails;

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

	public AddLibraryDetailsDto getLibraryDetails() {
		return libraryDetails;
	}

	public void setLibraryDetails(AddLibraryDetailsDto libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
