package com.mobileapplication.app.classroom.service.response.model;

import java.util.List;

public class LibraryRest {

	private String name;

	private List<BookRest> bookDetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookRest> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<BookRest> bookDetails) {
		this.bookDetails = bookDetails;
	}

}
