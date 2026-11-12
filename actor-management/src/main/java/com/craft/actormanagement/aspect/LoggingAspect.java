package com.craft.actormanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    // Runs before EVERY service method; JoinPoint tells us which one and its arguments
    @Before("com.craft.actormanagement.aspect.CommonPointcuts.anyServiceMethod()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(">>> [AOP @Before] " + joinPoint.getSignature().getName()
                + " is about to run with arguments " + Arrays.toString(joinPoint.getArgs()));
    }

    // Runs only before the methods that CHANGE data (combined pointcut)
    @Before("com.craft.actormanagement.aspect.CommonPointcuts.writeMethods()")
    public void logWrite(JoinPoint joinPoint) {
        System.out.println(">>> [AOP write-only @Before] " + joinPoint.getSignature().getName()
                + " is about to CHANGE data");
    }

    @AfterReturning(
            pointcut = "com.craft.actormanagement.aspect.CommonPointcuts.anyServiceMethod()",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(">>> [AOP @AfterReturning] " + joinPoint.getSignature().getName()
                + " returned: " + result);
    }

    @AfterThrowing(
            pointcut = "com.craft.actormanagement.aspect.CommonPointcuts.anyServiceMethod()",
            throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println(">>> [AOP @AfterThrowing] " + joinPoint.getSignature().getName()
                + " threw: " + ex.getMessage());
    }

    @After("com.craft.actormanagement.aspect.CommonPointcuts.anyServiceMethod()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(">>> [AOP @After] " + joinPoint.getSignature().getName() + " has finished");
    }
}