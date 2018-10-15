package com.selftraining.services;

import java.util.List;

import com.sleftraining.dto.CarDTO;

public interface ICarService 
{

	List<CarDTO> findAll() throws Exception;
	
	CarDTO findById(int id) throws Exception;
	
	CarDTO findCarByModel(String model) throws Exception;
	
	CarDTO addCar(CarDTO carObj) throws Exception;
	
	CarDTO updateCarById(int id) throws Exception;
	
	CarDTO updateCar(CarDTO carObj) throws Exception;
	
	void deleteCarById(int id) throws Exception;
	
	void deleteCar(CarDTO carObj) throws Exception;
}
