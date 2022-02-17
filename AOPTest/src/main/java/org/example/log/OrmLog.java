package org.example.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class OrmLog {

    public void afterUpdateLog(JoinPoint joinPoint){
        System.out.println("[MONEY LOG] Execute: " + joinPoint.getSignature() + " Args:{" + Arrays.toString(joinPoint.getArgs()));
    }


}
