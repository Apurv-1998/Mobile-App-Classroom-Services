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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "floors")
public class FloorEntity implements Serializable {

	private static final long serialVersionUID = 1939469664511876067L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String floorId;
	@Column(nullable = false)
	private String floorName;
	@Column(nullable = false)
	private int floorNumber;

	@OneToMany(mappedBy = "floorDetails", cascade = CascadeType.ALL)
	private List<StandardEntity> standardDetails;

	@OneToOne
	@JoinColumn(name = "rest_rooms_id")
	private RestRoomEntity restRoomDetails;

	@OneToOne
	@JoinColumn(name = "staff_room_id")
	private StaffRoomEntity staffRoomDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public List<StandardEntity> getStandardDetails() {
		return standardDetails;
	}

	public void setStandardDetails(List<StandardEntity> standardDetails) {
		this.standardDetails = standardDetails;
	}

	public RestRoomEntity getRestRoomDetails() {
		return restRoomDetails;
	}

	public void setRestRoomDetails(RestRoomEntity restRoomDetails) {
		this.restRoomDetails = restRoomDetails;
	}

	public StaffRoomEntity getStaffRoomDetails() {
		return staffRoomDetails;
	}

	public void setStaffRoomDetails(StaffRoomEntity staffRoomDetails) {
		this.staffRoomDetails = staffRoomDetails;
	}

}
