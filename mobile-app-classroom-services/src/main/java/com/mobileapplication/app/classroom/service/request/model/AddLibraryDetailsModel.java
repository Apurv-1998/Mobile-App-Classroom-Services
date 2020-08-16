package com.mobileapplication.app.classroom.service.request.model;

import java.util.List;

public class AddLibraryDetailsModel {

	private String name;

	private List<AddBooksDetailsModel> bookDetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AddBooksDetailsModel> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<AddBooksDetailsModel> bookDetails) {
		this.bookDetails = bookDetails;
	}

}
