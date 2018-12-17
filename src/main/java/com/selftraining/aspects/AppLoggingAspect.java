package com.selftraining.aspects;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {

	//adding logging support
	private static final Logger logger = LogManager.getLogger(AppLoggingAspect.class);
	
	//declaring point cut
	//predicate indicate that point cut will applied on any class in controller package any method with any number of arguments
	
	@Pointcut("execution (* com.selftraining.controller.*.*(..))")
	private void forControllerLog()
	{}
	
	//declare point cut for service and dao packages
	@Pointcut("execution (* com.selftraining.services.*.*(..))")
	private void forServicesLog()
	{}
	
	@Pointcut("execution (* com.selftraining.dao.*.*(..))")
	private void forDaoLog()
	{}
	
	//merge all point cuts to one
	@Pointcut ("forControllerLog() || forServicesLog() || forDaoLog()")
	private void appLog() {}
	
	
	//before advice
	
	@Before("appLog()")
	public void beforeLogging(JoinPoint jpoint)
	{
		//display method signature
		String methodSig = jpoint.getSignature().toShortString();
		logger.info("=================> @Before Logging :Calling Method: "+methodSig);
		
		//display method params
		Object[] methodParams = jpoint.getArgs();
		for(Object temp : methodParams)
		{
			logger.info("=================> arguments: "+temp);
			
		}
		
	}
	
	@AfterThrowing("appLog()")
	public void afterThrowException(JoinPoint jpoint)
	{
		String methodSig = jpoint.getSignature().toShortString();
		logger.error("=================> @Exception Logging :Calling Method: "+methodSig);
	}
	
	
	//after running advice
}
