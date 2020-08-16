package com.mobileapplication.app.classroom.service.response.model;

public class BookRest {

	private String bookId;
	private String bookName;
	private String standard;
	private String subject;
	private int totalCopies;
	private int noOfCopiesIssued;

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

	private double price;

}
