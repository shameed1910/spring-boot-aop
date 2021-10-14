package com.example.aop.springaop.aspect;

import com.example.aop.springaop.model.Department;
import com.example.aop.springaop.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

    //@Pointcut("execution(* com.example.aop.springaop.controller.*.*(..))")
    //@Pointcut("within(com.example.aop.springaop..*)")
    //@Pointcut("this(com.example.aop.springaop.service.DepartmentService)")
    @Pointcut("@annotation(com.example.aop.springaop.annotation.CustomAnnotation)")
    public void loggingPointCut(){}

    /*@Before("loggingPointCut()")
    public void before( JoinPoint joinPoint ){
        log.info("Before method invoked::"+joinPoint.getSignature());
    }

    @AfterReturning(value = "execution(* com.example.aop.springaop.controller.*.*(..))",
            returning = "employee")
    public void after( JoinPoint joinPoint, Employee employee ){
        log.info("After method invoked::"+employee);
    }

    @AfterThrowing(value = "execution(* com.example.aop.springaop.controller.*.*(..))",
            throwing = "e")
    public void after( JoinPoint joinPoint, Exception e ){
        log.info("After method invoked::"+e.getMessage());
    }*/


    @Around("loggingPointCut()")
    public Object around( ProceedingJoinPoint joinPoint ) throws Throwable {
        log.info("Before method invoked::"+joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();

        if(object instanceof Employee){
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }else if(object instanceof Department){
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }

        return object;
    }

}
