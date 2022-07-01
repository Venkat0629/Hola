package com.infosys.dao;

import java.util.List;

import com.infosys.model.Car;
import com.infosys.model.ShowRoom;

public interface HolaCarsDAO {
	Integer checkSpaceAvailability(Integer showRoomId);

	String addCarToShowRoom(ShowRoom showRoom);

	List<Integer> getCarsByManufacturer(String manufacturer);

	List<Car> updateCarCost(List<Integer> carIdList, Integer byPercent);

	List<Car> getCarsByShowRoom(String showRoomName);

	List<ShowRoom> getAllShowRoomDetails();
}
