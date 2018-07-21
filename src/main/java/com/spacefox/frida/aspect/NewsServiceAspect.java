package com.spacefox.frida.aspect;


import com.spacefox.frida.domain.DTO.NewsDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class NewsServiceAspect {

    @AfterReturning("execution(* com.spacefox.frida.services.NewsService.save(com.spacefox.frida.domain.DTO.NewsDTO))")
    public void beforeAdvice(JoinPoint joinPoint){
        NewsDTO dto =  (NewsDTO)joinPoint.getArgs()[0];
        log.info("Created or changed news " + dto.getTitle());
    }
}
