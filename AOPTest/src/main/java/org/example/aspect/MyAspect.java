package org.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Before("execution(* org.example.service.UserServiceImpl.*(..))")
    public void myBefore(){
        System.out.println("I am My Before...");
    }
}
