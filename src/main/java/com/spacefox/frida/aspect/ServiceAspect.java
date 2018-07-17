package com.spacefox.frida.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
@Slf4j
public class ServiceAspect {

    @Before("allServicesMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {

        log.info("halilua");
    }

    @After("allServicesMethods()")
    public void afterAdvice(ProceedingJoinPoint joinPoint) {
        log.info("halilua");
    }

    @Pointcut("within(com.spacefox.frida.services.*)")
    private void allServicesMethods(){}
}
