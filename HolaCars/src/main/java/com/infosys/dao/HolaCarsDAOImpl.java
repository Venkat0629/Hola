package com.infosys.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.infosys.model.Car;
import com.infosys.model.ShowRoom;

@Repository
public class HolaCarsDAOImpl implements HolaCarsDAO {
	private List<Car> carList;
	private Map<Integer, ShowRoom> showRoomMap;

	public HolaCarsDAOImpl() {
		Car car1 = new Car();
		car1.setCarId(1001);
		car1.setManufacturer("Audi");
		car1.setCarCost(2500000);
		car1.setCarType("Diesel");

		Car car2 = new Car();
		car2.setCarId(1002);
		car2.setManufacturer("BMW");
		car2.setCarCost(2000000);
		car2.setCarType("Diesel");

		Car car3 = new Car();
		car3.setCarId(1003);
		car3.setManufacturer("Chevrolet");
		car3.setCarCost(700000);
		car3.setCarType("Gasoline");

		Car car4 = new Car();
		car4.setCarId(1004);
		car4.setManufacturer("Daimler");
		car4.setCarCost(800000);
		car4.setCarType("Diesel");

		Car car5 = new Car();
		car5.setCarId(1005);
		car5.setManufacturer("Audi");
		car5.setCarCost(2400000);
		car5.setCarType("Gasoline");

		this.carList = new ArrayList<>();
		this.carList.add(car1);
		this.carList.add(car2);
		this.carList.add(car3);
		this.carList.add(car4);
		this.carList.add(car5);

		ShowRoom showRoom1 = new ShowRoom();
		showRoom1.setShowRoomId(2001);
		showRoom1.setShowRoomName("Tesla");
		showRoom1.setSpaceAvailability(2);

		List<Car> carList1 = new ArrayList<>();
		carList1.add(car1);
		carList1.add(car5);
		showRoom1.setCarList(carList1);

		ShowRoom showRoom2 = new ShowRoom();
		showRoom2.setShowRoomId(2002);
		showRoom2.setShowRoomName("General Motors");
		showRoom2.setSpaceAvailability(1);

		List<Car> carList2 = new ArrayList<>();
		carList2.add(car3);
		carList2.add(car2);
		showRoom2.setCarList(carList2);

		ShowRoom showRoom3 = new ShowRoom();
		showRoom3.setShowRoomId(2003);
		showRoom3.setShowRoomName("Fiat Chrysler");
		showRoom3.setSpaceAvailability(0);

		List<Car> carList3 = new ArrayList<>();
		carList3.add(car4);
		showRoom3.setCarList(carList3);
		showRoomMap.put(2001, showRoom1);
		showRoomMap.put(2002, showRoom2);
		showRoomMap.put(2003, showRoom3);
	}

	@Override
	public Integer checkSpaceAvailability(Integer showRoomId) {
		ShowRoom showRoom = this.showRoomMap.get(showRoomId);
		if (showRoom == null)
			return null;
		else
			return showRoom.getSpaceAvailability();
	}

	@Override
	public String addCarToShowRoom(ShowRoom showRoom) {
		ShowRoom showRoom1 = this.showRoomMap.get(showRoom.getShowRoomId());
		showRoom1.getCarList().addAll(showRoom.getCarList());
		showRoom1.setSpaceAvailability(showRoom1.getSpaceAvailability() - showRoom.getCarList().size());
		this.showRoomMap.put(showRoom1.getShowRoomId(), showRoom1);
		return this.showRoomMap.get(showRoom.getShowRoomId()).getShowRoomName();

	}

	@Override
	public List<Integer> getCarsByManufacturer(String manufacturer) {
		List<Integer> carIdList = new ArrayList<>();
		for (Car c : this.carList) {
			if (c.getManufacturer().equals(manufacturer)) {
				carIdList.add(c.getCarId());
			}
		}
		return carIdList;
	}

	@Override
	public List<Car> updateCarCost(List<Integer> carIdList, Integer byPercent) {
		List<Car> toRet = new ArrayList<>();
		for (Car c : carList) {
			Integer carId = c.getCarId();
			if (carIdList.contains(carId)) {
				c.setCarCost((int) (c.getCarCost() * (1 + (byPercent / 100.0))));
				toRet.add(c);
			}
		}
		return toRet;

	}

	@Override
	public List<Car> getCarsByShowRoom(String showRoomName) {
		List<Car> toRet = new ArrayList<>();
		Set<Entry<Integer, ShowRoom>> entrySet = this.showRoomMap.entrySet();
		for (Entry<Integer, ShowRoom> entry : entrySet) {
			ShowRoom value = entry.getValue();
			if (value.getShowRoomName().equals(showRoomName)) {
				toRet = value.getCarList();
			}
		}
		return toRet;
	}

	@Override
	public List<ShowRoom> getAllShowRoomDetails() {
		List<ShowRoom> showRooms = new ArrayList<>();
		Collection<ShowRoom> showRoomsCollection = this.showRoomMap.values();
		for (ShowRoom showRoom : showRoomsCollection) {
			showRooms.add(showRoom);
		}
		return showRooms;
	}

}
