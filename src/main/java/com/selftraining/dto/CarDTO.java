package com.selftraining.dto;

import java.io.Serializable;

public class CarDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String brand;
	
	private String model;
	
	private String modelDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelDetails() {
		return modelDetails;
	}

	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

}
