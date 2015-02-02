package com.iboray.lms.application.service.aop;

import org.apache.ibatis.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class LogAspect {

	
	  public void doAfter(JoinPoint jp) {
		 
//		  LogFactory.useLog4JLogging();
//		  String logstr = "log Ending method: "
//	                + jp.getTarget().getClass().getName() + "."
//	                + jp.getSignature().getName();
//	      Logger logger = Logger.getLogger(jp.getTarget().getClass().getName());
//	      
//	      logger.info(logstr);
	  }

	  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//	      long time = System.currentTimeMillis();
	      Object retVal = pjp.proceed();
//	      time = System.currentTimeMillis() - time;
	      
	      //Logger logger = Logger.getLogger(pjp.getTarget().getClass().getName());
	      //String logstr ="process time: " + time + " ms";
	      //logger.info(logstr);
	      
	      return retVal;
	  }

	  public void doBefore(JoinPoint jp) {
		  LogFactory.useLog4JLogging();
//	      String logstr = "log Begining method: "
//	                + jp.getTarget().getClass().getName() + "."
//	                + jp.getSignature().getName();
//	      
//	      Logger logger = Logger.getLogger(jp.getTarget().getClass().getName());
//	      
//	      logger.info(logstr);
	      
	  }

	  public void doThrowing(JoinPoint jp, Throwable ex) {
	   
//	      String logstr = "method " + jp.getTarget().getClass().getName()
//	                + "." + jp.getSignature().getName() + " throw exception" + ex.getMessage();
//	      
//	      Logger logger = Logger.getLogger(jp.getTarget().getClass().getName());
//	      
//	      logger.info(logstr);
	  }

	  @SuppressWarnings("unused")
	private void sendEx(String ex) {
	        //TODO 发送短信或邮件提醒
	  }
	

}