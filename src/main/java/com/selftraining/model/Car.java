package com.selftraining.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Car 
{
	@Id @GeneratedValue
	int id;
	@NotNull
	String brand;
	
	String model;
	
	String modelDetails;
	
	public Car(String brand, String model, String modelDetails)
	{
		this.brand = brand;
		this.model = model;
		this.modelDetails = modelDetails;
	}

}
