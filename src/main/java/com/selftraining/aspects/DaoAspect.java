/*package com.selftraining.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DaoAspect {

	
	//Only one class Aspect with execution way
	
	
	@Before ("execution(public * findAll())")
	public void getCarsAdvice()
	{
		System.out.println("get cars Aspect Called");
	}
	
	@After ("execution(public * findAll())")
	public void carAfterAdvice()
	{
		System.out.println("get cars After Advice Aspect Called");
	}
	
}
*/