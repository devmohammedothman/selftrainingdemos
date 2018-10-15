package com.selftraining.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selftraining.dao.ICarRepository;
import com.selftraining.model.Car;
import com.selftraining.services.ICarService;
import com.sleftraining.dto.CarDTO;

@Service
public class CarServiceImpl implements ICarService {

	@Autowired
	private ICarRepository carRepo;
	
	@Autowired
	protected ModelMapper modelMapper;
	
	private Car _car = new Car();
	
	@Override
	public List<CarDTO> findAll() throws Exception
	{
		List<CarDTO> resultList ; 
		resultList = carRepo.findAll().stream().map(item -> convertToDTO(item, new CarDTO())).collect(Collectors.toList());
		
		return resultList;
	}

	@Override
	public CarDTO findById(int id) throws Exception 
	{
		
		CarDTO resultObj = new CarDTO();
				
		_car =  carRepo.findById(id).get();
		
		resultObj = convertToDTO(_car, resultObj);
		
		return resultObj;
	}

	@Override
	public CarDTO findCarByModel(String model) throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public CarDTO addCar(CarDTO carObj) throws Exception
	{
		CarDTO resultObj ; 
		
		 _car = convertToEntity(_car, carObj);
		 
		_car =  carRepo.save(_car);
		
		resultObj = convertToDTO(_car, carObj);
		
		return resultObj;
	}

	@Override
	public CarDTO updateCarById(int id) throws Exception
	{
		CarDTO resultObj ; 
		
		resultObj =  findById(id);
		
		 _car = convertToEntity(_car,resultObj);
		 
		_car =  carRepo.save(_car);
		
		resultObj = convertToDTO(_car, resultObj);
		
		return resultObj;
	}
	
	@Override
	public CarDTO updateCar(CarDTO carObj) throws Exception
	{
		
		CarDTO resultObj ; 
		
		 _car = convertToEntity(_car, carObj);
		 
		_car =  carRepo.save(_car);
		
		resultObj = convertToDTO(_car, carObj);
		
		return resultObj;
	}

	@Override
	public void deleteCarById(int id) throws Exception
	{
		
		CarDTO resultObj ; 
		
		resultObj =  findById(id);
		
		 _car = convertToEntity(_car,resultObj);
		 
		carRepo.delete(_car);
				
	}
	
	@Override
	public void deleteCar(CarDTO carObj) throws Exception
	{
		
		 _car = convertToEntity(_car, carObj);
		 
		 carRepo.delete(_car);		
	}
	
	@SuppressWarnings("unchecked")
	public CarDTO convertToDTO(Car entity , CarDTO dto)
	{
		
		CarDTO convertedDtoObj = (CarDTO) modelMapper.map(entity, dto.getClass());
		return convertedDtoObj;
	}
	
	@SuppressWarnings("unchecked")
	public Car convertToEntity(Car entity , CarDTO dto)
	{
		Car convertedEntity = (Car) modelMapper.map(dto, entity.getClass());
		return convertedEntity;
	}

	

}
