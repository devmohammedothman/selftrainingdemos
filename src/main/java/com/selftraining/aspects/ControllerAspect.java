package com.selftraining.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
	
	@Before ("execution(public * coolCars())")
	public void getCarsAdvice()
	{
		System.out.println("Hit Controller !!");
	}
}
