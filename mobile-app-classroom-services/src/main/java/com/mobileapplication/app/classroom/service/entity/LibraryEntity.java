package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class LibraryEntity implements Serializable {

	private static final long serialVersionUID = 3991903233510950784L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String libraryId;

	@Column(nullable = false)
	private String name;

	@OneToOne
	@JoinColumn(name = "organizations_id")
	private OrganizationEntity organizationDetails;

	@OneToMany(mappedBy = "libraryDetails", cascade = CascadeType.ALL)
	private List<BookEntity> bookDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public List<BookEntity> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<BookEntity> bookDetails) {
		this.bookDetails = bookDetails;
	}

	public OrganizationEntity getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationEntity organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LibraryEntity [id=" + id + ", libraryId=" + libraryId + ", name=" + name + ", organizationDetails="
				+ organizationDetails + "]";
	}

}
