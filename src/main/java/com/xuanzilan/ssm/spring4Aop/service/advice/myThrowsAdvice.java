package com.xuanzilan.ssm.spring4Aop.service.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 异常处理通知可以自定义一下四种方法来接受和处理异常
 * public void afterThrowing(Exception ex)
 * public void afterThrowing(RemoteException)
 * public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
 * public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)
 *
 * 当定了多个以上的方法时，只会执行最后一个方法（按照自己写的顺序执行，不是上面的顺序）
 *
 */
public class myThrowsAdvice implements ThrowsAdvice {



    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("处理抛出的异常:method="+method.getName());
    }

    public void afterThrowing(Exception e){
        System.out.println("处理抛出的异常:e="+e.getMessage());
    }
}
