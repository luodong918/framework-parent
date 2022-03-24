package com.framework.parent.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 业务日志记录
 *
 * @author luodong
 * @AfterReturning - 如果方法返回成功
 * @After - 将函数标记为在切入点覆盖的方法之后执行的通知
 */
@Slf4j
@Aspect
@Component
public class LogAdvice {


    @Pointcut("@annotation(com.framework.parent.aspect.Log)")
    public void controllerAspect() {

    }

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("After");
    }

    /**
     * 最后的最后
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("Before");
    }

    /**
     * 方法执行结束之后 @After方法之前
     */
    @AfterReturning("controllerAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("AfterReturning");
    }

    /**
     * 方法之前最最最先执行
     * point.proceed();
     * 方法之前最最最后执行
     */
    @Around("controllerAspect()")
    public void doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around 的 before");
        point.proceed();
        System.out.println("around 的 after");
    }

    /**
     * 异常之后执行
     * @param joinPoint
     * @param error
     */
    @AfterThrowing(pointcut="controllerAspect()", throwing = "error")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("AfterThrowing:"+error.toString());

    }

}
