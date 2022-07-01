package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.infosys.dao.HolaCarsDAO;
import com.infosys.exception.HolaCarException;
import com.infosys.model.Car;
import com.infosys.model.ShowRoom;
import com.infosys.validator.Validator;

@Service
public class HolaCarsServiceImpl implements HolaCarsService {
	@Autowired
	private HolaCarsDAO holaCarsDAO;

	@Override
	public void setHolaCarsDAO(HolaCarsDAO holaCarsDAO) {
		this.holaCarsDAO = holaCarsDAO;

	}
	

	@Override
	public String addCarToShowRoom(ShowRoom showRoom) throws HolaCarException {
		   List<Car> carList = Validator.validate(getCarList);
		   if (!carList.isEmpty()) {
			      
			    }

	           
	        return ("Service.SPACE.UNAVAILABLE");
	    
	}

	@Override
	public List<Car> updateCarCost(String manufacturer, Integer byPercent) throws HolaCarException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCarsByShowRoom(String showRoomName) throws HolaCarException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowRoom> getAllShowRoomDetails() throws HolaCarException {
		// TODO Auto-generated method stub
		return null;
	}

}
