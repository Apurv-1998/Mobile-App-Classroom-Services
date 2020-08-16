package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rest_rooms")
public class RestRoomEntity implements Serializable {

	private static final long serialVersionUID = -9152401240127948997L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String restRoomId;
	@Column(nullable = false)
	private boolean hasRestRoom = false;

	@OneToOne
	@JoinColumn(name = "floors_id")
	private FloorEntity floorDetails;

	@OneToMany(mappedBy = "restRoomDetails", cascade = CascadeType.ALL)
	private List<RestEntity> restDetails;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "organizations_id")
	@JsonIgnore
	private OrganizationEntity organizationDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRestRoomId() {
		return restRoomId;
	}

	public void setRestRoomId(String restRoomId) {
		this.restRoomId = restRoomId;
	}

	public boolean isHasRestRoom() {
		return hasRestRoom;
	}

	public void setHasRestRoom(boolean hasRestRoom) {
		this.hasRestRoom = hasRestRoom;
	}

	public FloorEntity getFloorDetails() {
		return floorDetails;
	}

	public void setFloorDetails(FloorEntity floorDetails) {
		this.floorDetails = floorDetails;
	}

	public List<RestEntity> getRestDetails() {
		return restDetails;
	}

	public void setRestDetails(List<RestEntity> restDetails) {
		this.restDetails = restDetails;
	}

	public OrganizationEntity getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationEntity organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

}
