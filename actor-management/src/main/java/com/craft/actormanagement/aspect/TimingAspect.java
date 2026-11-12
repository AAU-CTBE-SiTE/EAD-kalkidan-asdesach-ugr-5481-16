package com.craft.actormanagement.aspect;

import com.craft.actormanagement.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class TimingAspect {

    // Applies only to methods that carry @LogExecutionTime.
    // The annotation itself is passed in, so we can read its label.
    @Around("@annotation(logExecutionTime)")
    public Object measureTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        System.out.println(">>> [AOP @LogExecutionTime] " + joinPoint.getSignature().getName() + " starts");
        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long micros = (System.nanoTime() - start) / 1000;
            String label = logExecutionTime.label().isEmpty() ? "" : " (" + logExecutionTime.label() + ")";
            System.out.println(">>> [AOP @LogExecutionTime] " + joinPoint.getSignature().getName()
                    + label + " took " + micros + " microseconds");
        }
    }
}