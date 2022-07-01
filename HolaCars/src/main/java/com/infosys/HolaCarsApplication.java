package com.infosys;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.infosys.model.Car;
import com.infosys.model.ShowRoom;
import com.infosys.service.HolaCarsService;

@SpringBootApplication(scanBasePackages={"com.infosys.service","com.infosys.dao"})
@PropertySource("classpath:messages.properties")
public class HolaCarsApplication implements CommandLineRunner {
	@Autowired
	private Environment environment;
	@Autowired
	private HolaCarsService holaCarsService;
	private static String generalException = "General.EXCEPTION";
	private static Logger logger = LoggerFactory.getLogger(HolaCarsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HolaCarsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addCarToShowroom();
		updateCarCost();
		getCarsByShowroom();
		getAllShowroomDetails();
	}

	private void getAllShowroomDetails() {

		try {
			List<ShowRoom> showroomList = holaCarsService.getAllShowRoomDetails();
			System.out.println("Details of all Showroom");
			System.out.println(
					"===============================================================================================================");
			System.out.printf("%-20d%-20s%-20d%-20d%n", "Showroom Id", "Showroom Name", "Space Availability",
					"Total Cars Availiable");
			System.out.println(
					"===============================================================================================================");
			for (ShowRoom showroom : showroomList) {
				System.out.printf("%-20d%-20s%-20d%-20d%n", showroom.getShowRoomId(), showroom.getShowRoomName(),
						showroom.getSpaceAvailability(), showroom.getCarList().size());
			}
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage());
			if (message == null) {
				message = environment.getProperty(generalException);
			}
			logger.error(message);
		}
	}

	private void getCarsByShowroom() {
		String showroomName = "Telsa";
		try {
			List<Car> carList = holaCarsService.getCarsByShowRoom(showroomName);

			System.out.println("List of Cars Available for Showroom :" + showroomName);
			System.out.println("========================================================");
			System.out.printf("Car Id\tManufacturer\tCar Cost\tCar Type");
			System.out.println("========================================================");
			for (Car car : carList) {
				System.out.println(
						car.getCarId() + "\t" + car.getManufacturer() + "\t\t" + car.getCarCost() + car.getCarType());
			}
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage());
			if (message == null) {
				message = environment.getProperty(generalException);
			}
			logger.error(message);
		}
	}

	private void updateCarCost() {
		String manufacturer = "Audi";
		Integer byPercent = 5;
		List<Car> cars = null;
		try {
			cars = holaCarsService.updateCarCost(manufacturer, byPercent);

			System.out.println("List of Car details updated :");
			System.out.println("====================");
			System.out.printf("Car Id updated Cost");
			System.out.println("====================");
			for (Car car : cars) {
				System.out.println(car.getCarId() + "\t" + car.getCarCost());
			}
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage());
			if (message == null) {
				message = environment.getProperty(generalException);
			}
			logger.error(message);
		}

	}

	private void addCarToShowroom() {
		ShowRoom showroom = new ShowRoom();
		showroom.setShowRoomId(2001);
		Car car1 = new Car();
		car1.setCarId(1006);
		car1.setCarCost(400000);
		car1.setCarType("Gasoline");
		car1.setManufacturer("Daimler");
		Car car2 = new Car();
		car2.setCarId(1007);
		car2.setCarCost(2000000);
		car2.setCarType("Diesel");
		car2.setManufacturer("BMW");
		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		showroom.setCarList(carList);
		String showroomName;
		try {
			showroomName = holaCarsService.addCarToShowRoom(showroom);
			System.out.println(environment.getProperty("UserInterface.ADDED_SUCCESS") + showroomName);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage());
			if (message == null) {
				message = environment.getProperty(generalException);
			}
			logger.error(message);
		}

	}

}
