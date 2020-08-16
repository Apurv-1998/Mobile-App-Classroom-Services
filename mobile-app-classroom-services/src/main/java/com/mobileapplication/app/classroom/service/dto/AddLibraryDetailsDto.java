package com.mobileapplication.app.classroom.service.dto;

import java.io.Serializable;
import java.util.List;

public class AddLibraryDetailsDto implements Serializable {

	private static final long serialVersionUID = 6869007584812888715L;

	private String libraryId;

	private String name;

	private List<AddBooksDetailsDto> bookDetails;

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AddBooksDetailsDto> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<AddBooksDetailsDto> bookDetails) {
		this.bookDetails = bookDetails;
	}

}
