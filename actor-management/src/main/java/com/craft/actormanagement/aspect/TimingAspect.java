package com.craft.actormanagement.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimingAspect {

    // Wraps every ActorService method: we decide when the real method runs
    @Around("com.craft.actormanagement.aspect.CommonPointcuts.anyServiceMethod()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();          // code here runs BEFORE the method
        try {
            return joinPoint.proceed();          // run the real method
        } finally {                              // code here runs AFTER, even on exceptions
            long micros = (System.nanoTime() - start) / 1000;
            System.out.println(">>> [AOP @Around] " + joinPoint.getSignature().getName()
                    + " took " + micros + " microseconds");
        }
    }
}