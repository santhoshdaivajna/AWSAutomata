package com.automata.cloudcore.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;

/**
 * Logging using aspects class supports method entry, method exit
 * and exception logging.
 * @author Santhosh Daivajna
 *
 */
@Aspect
public class LoggingAspect {

	/**
	 * Method entry aspect logging
	 * @param joinPoint
	 */
	@Before("execution(* *.*(..))")
	public void logInvocation(JoinPoint joinPoint) {
		logger.debug("Entering method " + joinPoint.getClass().getName() + "::"
				+ joinPoint.getSignature().getName() + "() with arguments "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	/**
	 * Method exit logging with aspects
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
	public void logComplete(JoinPoint joinPoint, Object result) {
		logger.debug("Exiting method " + joinPoint.getClass().getName() + "::"
				+ joinPoint.getSignature().getName() + "with arguments "
				+ Arrays.toString(joinPoint.getArgs()) + "returns with "
				+ ((result != null)? result.toString():"null"));
	}

	/**
	 * Exception logging thrown from methods.
	 * @param joinPoint
	 * @param ex
	 * @throws AmazonServiceException
	 * @throws AmazonClientException
	 * @throws Exception
	 */
	@AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
	public void processException(JoinPoint joinPoint, Exception ex)
			throws AmazonServiceException, AmazonClientException, Exception {

		if (ex instanceof AmazonServiceException) {
			AmazonServiceException ase = (AmazonServiceException) ex;
			logger.error("Caught Exception: " + ase.getMessage()
					+ "Reponse Status Code: " + ase.getStatusCode()
					+ "Error Code: " + ase.getErrorCode() + "Request ID: "
					+ ase.getRequestId(), ase);
			throw ase;
		} else if (ex instanceof AmazonClientException) {
			AmazonClientException ace = (AmazonClientException) ex;
			logger.error("AmazonClientException in "
					+ joinPoint.getClass().getName() + "method: "
					+ joinPoint.getSignature().getName(), ace);
			throw ace;
		} else {
			logger.debug("The class "+joinPoint.getClass().getName()+"method " + joinPoint.getSignature().getName()
					+ "() threw  Exception " + ex);
			throw ex;
		} 
	}
	
	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(LoggingAspect.class.getName());
}
