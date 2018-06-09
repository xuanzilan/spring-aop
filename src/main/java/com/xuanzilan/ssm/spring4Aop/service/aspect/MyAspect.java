package com.xuanzilan.ssm.spring4Aop.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * JoinPoint可能在每个注解方法中都可以用（环绕方法除外），代表切入点
 */
@Aspect
public class MyAspect {

    /**
     * 注意表达式形式，* *..service.*.*()，第一个*表示返回值类型，第二部分为方法全名（包括包），括号中有..说明参数个数>=0， 无..则表示无参
     * joinPoint 为可选参数，可以直接使用before()，argNames与下文的returning相同，可见下
     */
    @Before("execution(* *..service.*.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("AspectJ执行前置方法");
    }

    /**
     * returning为可选，代表返回的结果，后面的参数名称应该与方法参数（Object result）一致
     * 当然这个注解还有pointcut、argNames两个参数可选
     * @param result
     */
    @AfterReturning(value = "execution(* *..service.*.*(..))", returning = "result")
    public void afterReturning(Object result){
        System.out.println("AspectJ执行后置方法");
    }

    /**
     * 注解可选参数：argNames
     * 方法可选参数：
     */
    @Around("execution(* *..service.*.*(..))")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AspectJ执行环绕方法方法前");
        Object object = joinPoint.proceed();
        System.out.println("AspectJ执行环绕方法方法后");
        return object;
    }

    /**
     * 注解可选：value、pointcut、throwing、argNames
     * @param e 可选参数
     */
    @AfterThrowing(value = "execution(* *..service.*.*(..))", throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("AspectJ执行异常处理方法");
        System.out.println("接受到的异常：e="+e.getMessage());
    }

    /**
     * 注解可选：value、argNames
     * 使用自定义的切入点，注意的是value中应该使用的是方法名，有括号
     * @param joinPoint
     */
    @After(value = "myPointCut()")
    public void finaly(JoinPoint joinPoint){
        System.out.println("AspectJ执行最终方法,joinPoint="+joinPoint.toString());
    }


    /**
     * 定义切入点,切入点表达式还是在注解中，方法体可以为空
     */
    @Pointcut("execution(* *..service.*.*(..))")
    public void myPointCut(){}
}
