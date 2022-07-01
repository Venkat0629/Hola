package com.infosys.model;

import java.util.List;

public class ShowRoom {
	private Integer showRoomId;
	private String showRoomName;
	private Integer spaceAvailability;
	private List<Car> carList;

	public Integer getShowRoomId() {
		return showRoomId;
	}

	public void setShowRoomId(Integer showRoomId) {
		this.showRoomId = showRoomId;
	}

	public String getShowRoomName() {
		return showRoomName;
	}

	public void setShowRoomName(String showRoomName) {
		this.showRoomName = showRoomName;
	}

	public Integer getSpaceAvailability() {
		return spaceAvailability;
	}

	public void setSpaceAvailability(Integer spaceAvailability) {
		this.spaceAvailability = spaceAvailability;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

}
