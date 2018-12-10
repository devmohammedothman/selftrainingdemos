package com.selftraining.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DaoAspect {

	
	@Before ("execution(public * findAll())")
	public void getCarsAdvice()
	{
		System.out.println("get cars Aspect Called");
	}
	
}
