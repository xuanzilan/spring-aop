package com.xuanzilan.ssm.spring4Aop.service.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class myMethodBeforeAdvice implements MethodBeforeAdvice {

    /**
     *
     * @param method 目前调用的方法
     * @param objects 传入的参数
     * @param o 暂时未知
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("执行前置方法");
    }
}
