package com.craft.actormanagement.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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

    // Runs only if the method returned normally, and receives the returned value
    @AfterReturning(
            pointcut = "execution(* com.craft.actormanagement.service.ActorService.*(..))",
            returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println(">>> [AOP @AfterReturning] The method returned: " + result);
    }

    // Runs after the method no matter what (like a finally block)
    @After("execution(* com.craft.actormanagement.service.ActorService.*(..))")
    public void logAfter() {
        System.out.println(">>> [AOP @After] The method has finished");
    }
}