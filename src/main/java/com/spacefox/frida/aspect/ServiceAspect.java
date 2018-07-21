package com.spacefox.frida.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@Slf4j
public class ServiceAspect {

    private Logger log = LoggerFactory.getLogger("Aspect");

    @Before("allServicesMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("service method was called [ " + className + "." + methodName + " ]");
    }

    @AfterReturning("allServicesMethods()")
    public void afterRetAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getTarget().getClass().getName();
        log.debug("class: " + className + ", in method: " + methodName + " worked well.");
    }

    @AfterThrowing("allServicesMethods()")
    public void afterThrowing(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getTarget().getClass().getName();
        log.debug("class: " + className + ", in method: " + methodName + " worked not so well.");
    }

    @Pointcut("within(com.spacefox.frida.services.*)")
    private void allServicesMethods(){}
}
