package com.scg.employee.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExecutionTimeTrackerAdvice {

	@Around("@annotation(com.scg.employee.advice.TrackExecutionTime)")
	public Object trackTime(final ProceedingJoinPoint proceedingJointPoint) throws Throwable {
		final long startTime = System.currentTimeMillis();
		final Object obj = proceedingJointPoint.proceed();
		final long endTime = System.currentTimeMillis();
		final long executionTime =endTime- startTime;
		log.info(proceedingJointPoint.getSignature() + "Execution Time is :   " + executionTime);

		return obj;

	}
}
