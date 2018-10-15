package com.selftraining.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.selftraining.dto.CarDTO;
import com.selftraining.dto.ResponseDTO;
import com.selftraining.services.ICarService;

@RestController
@RequestMapping("/demo")
@CrossOrigin ("*")
public class CarController {

	@Autowired
	private ICarService carService;

	
	
	@RequestMapping (value = "/cool-cars", method = RequestMethod.GET,
	consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseDTO> coolCars()
	{
		ResponseDTO responseDTO;
		try
		{
			 responseDTO = new ResponseDTO("Status.code.1000", "Successfully Done",carService.findAll());
			 
			 return ResponseEntity.ok().body(responseDTO);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			responseDTO = new ResponseDTO("Status.code.1001", "Error ",ex.getMessage());
			return ResponseEntity.ok().body(responseDTO);
		}
		
	}
	
	@RequestMapping (value = "/secure/add-car", method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseDTO> addCar(@RequestBody CarDTO carObj)
	{	 
	  ResponseDTO responseDTO;
		try
		{
			responseDTO = new ResponseDTO("Status.code.1000", "Successfully Done",carService.addCar(carObj));
			 
			 return ResponseEntity.ok().body(responseDTO);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			 responseDTO = new ResponseDTO("Status.code.1001", "Error ",ex.getMessage());
			return ResponseEntity.ok().body(responseDTO);
		}
	}
	
	@RequestMapping (value = "/find-car-by-id/{id}", method = RequestMethod.GET,
	consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseDTO> findCarById(@PathVariable("id") int id)
	{		
		ResponseDTO responseDTO ;
		try
		{
			responseDTO = new ResponseDTO("Status.code.1000", "Successfully Done",carService.findById(id));
			 
			 return ResponseEntity.ok().body(responseDTO);
		}
		catch(Exception ex)
		{
			 ex.printStackTrace();
			 responseDTO = new ResponseDTO("Status.code.1001", "Error ",ex.getMessage());
			return ResponseEntity.ok().body(responseDTO);
		}
	}
	
	@RequestMapping (value = "/secure/update-car", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseDTO> updateCar(@RequestBody CarDTO carObj)
	{		
		 
		ResponseDTO responseDTO;
		try
		{
			responseDTO = new ResponseDTO("Status.code.1000", "Successfully Done",carService.updateCar(carObj));
			 
			 return ResponseEntity.ok().body(responseDTO);
		}
		catch(Exception ex)
		{
			 ex.printStackTrace();
			 responseDTO = new ResponseDTO("Status.code.1001", "Error ",ex.getMessage());
			return ResponseEntity.ok().body(responseDTO);
		}
	}

	@RequestMapping (value = "/secure/delete-car", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseDTO> deleteCar(@RequestBody CarDTO carObj)
	{		
		ResponseDTO responseDTO;
		try
		{
			carService.deleteCar(carObj);
			responseDTO = new ResponseDTO("Status.code.1000", "Successfully Done","Deleted");
			 
			 return ResponseEntity.ok().body(responseDTO);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			responseDTO = new ResponseDTO("Status.code.1001", "Error ",ex.getMessage());
			return ResponseEntity.ok().body(responseDTO);
		}
	}
	
}
