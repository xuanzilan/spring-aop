package com.xuanzilan.ssm.spring4Aop.service.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class myAfterReturnAdvice implements AfterReturningAdvice {

    /**
     *
     * @param o 返回值
     * @param method 调用的方法
     * @param objects 传入的参数
     * @param o1 未知
     * @throws Throwable
     */
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行后置方法");
    }
}
