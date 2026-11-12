package com.craft.actormanagement.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// Only holds named pointcuts. Other aspects refer to them by name.
@Aspect
public class CommonPointcuts {

    // every method of ActorService
    @Pointcut("execution(* com.craft.actormanagement.service.ActorService.*(..))")
    public void anyServiceMethod() {
    }

    // only the methods whose name starts with "get"
    @Pointcut("execution(* com.craft.actormanagement.service.ActorService.get*(..))")
    public void readMethods() {
    }

    // combined: any service method AND NOT a read method
    @Pointcut("anyServiceMethod() && !readMethods()")
    public void writeMethods() {
    }
}