package com.craft.actormanagement.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Runs BEFORE any method of ActorService
    @Before("execution(* com.craft.actormanagement.service.ActorService.*(..))")
    public void logBefore() {
        System.out.println(">>> [AOP @Before] An ActorService method is about to run");
    }
}