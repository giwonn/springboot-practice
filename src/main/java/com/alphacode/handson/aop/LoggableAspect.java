package com.alphacode.handson.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggableAspect {

//  @Pointcut("execution(* com.alphacode.handson.web.apis.v1.user.UserRestController.details(..))")
//  public void details() {
//  }

//  @Around("details()")
  @Around("execution(* com.alphacode.handson.web.apis.v1.user.UserRestController.details(..))")
  public Object aroundDetails(ProceedingJoinPoint pjp) throws Throwable {
    var args = pjp.getArgs();
    return pjp.proceed();
  }
}
