package com.infosys.validator;

import java.util.List;

import com.infosys.exception.HolaCarException;
import com.infosys.model.Car;

public class Validator {

	public Validator() {

	}

	public static void validate(List<Car> car) throws HolaCarException {
		for (Car c : car) {
			if (!validateCarType(c.getCarType()))
				throw new HolaCarException("Validator.INVALID_CARTYPE");
		}
	}

	private static boolean validateCarType(String carType) {

		return (carType.equals("Gasoline") || carType.equals("Diesel"));
	}

}
