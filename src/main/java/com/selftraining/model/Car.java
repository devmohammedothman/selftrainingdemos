package com.selftraining.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Car 
{
	@Id @GeneratedValue
	private
	int id;
	@NotNull
	private String brand;
	
	private String model;
	
	private String modelDetails;
	
	public Car () {};
	
	public Car(String brand, String model, String modelDetails)
	{
		this.brand = brand;
		this.model = model;
		this.modelDetails = modelDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
