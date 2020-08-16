package com.mobileapplication.app.classroom.service.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rests")
public class RestEntity implements Serializable {

	private static final long serialVersionUID = 5180400593717256875L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String restId;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private int totalRests;
	@Column(nullable = false)
	private int occupiedRests;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "rest_rooms_id")
	@JsonIgnore
	private RestRoomEntity restRoomDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalRests() {
		return totalRests;
	}

	public void setTotalRests(int totalRests) {
		this.totalRests = totalRests;
	}

	public int getOccupiedRests() {
		return occupiedRests;
	}

	public void setOccupiedRests(int occupiedRests) {
		this.occupiedRests = occupiedRests;
	}

	public RestRoomEntity getRestRoomDetails() {
		return restRoomDetails;
	}

	public void setRestRoomDetails(RestRoomEntity restRoomDetails) {
		this.restRoomDetails = restRoomDetails;
	}

}
