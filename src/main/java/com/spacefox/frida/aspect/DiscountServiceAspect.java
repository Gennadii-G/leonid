package com.spacefox.frida.aspect;

import com.spacefox.frida.domain.DTO.DiscountDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DiscountServiceAspect {

    @AfterReturning("execution(* com.spacefox.frida.services.DiscountService.save(com.spacefox.frida.domain.DTO.DiscountDTO))")
    public void beforeAdvice(JoinPoint joinPoint){
        DiscountDTO discount =  (DiscountDTO)joinPoint.getArgs()[0];
        log.info("Created or changed discount " + discount.getName());
    }

}
