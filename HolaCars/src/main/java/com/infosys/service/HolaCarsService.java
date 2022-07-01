package com.infosys.service;

import java.util.List;

import com.infosys.dao.HolaCarsDAO;
import com.infosys.exception.HolaCarException;
import com.infosys.model.Car;
import com.infosys.model.ShowRoom;

public interface HolaCarsService {
	void setHolaCarsDAO(HolaCarsDAO holaCarsDAO);

	String addCarToShowRoom(ShowRoom showRoom) throws HolaCarException;

	List<Car> updateCarCost(String manufacturer, Integer byPercent) throws HolaCarException;

	List<Car> getCarsByShowRoom(String showRoomName) throws HolaCarException;

	List<ShowRoom> getAllShowRoomDetails() throws HolaCarException;
}
