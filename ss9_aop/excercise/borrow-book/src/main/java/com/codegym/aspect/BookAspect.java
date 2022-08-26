package com.codegym.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    private static int count = 1;
    @AfterReturning(pointcut = "execution(* com.codegym.controller.BookController.*(..))")
    public static void processing(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        int c = count++;
        System.err.println("Method " + methodName + " Đã chạy xong" + " Số lần " + c );
    }
}
