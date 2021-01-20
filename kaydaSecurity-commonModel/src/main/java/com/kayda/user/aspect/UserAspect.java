package com.kayda.user.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

	@Around("execution(* com.kayda..*Controller.*(..))")
	public Object handleController(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("userAspect Start...");
		Object[] args = pjp.getArgs();
		for(Object arg:args) {
			System.out.println("arg is "+arg);
		}
		Long start = new Date().getTime();
		Object obj =pjp.proceed();
		System.out.println("userAspect user time:"+(new Date().getTime()-start));
		System.out.println("userAspect End...");
		return obj;
		
	}
}
