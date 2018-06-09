package com.xuanzilan.ssm.spring4Aop.service.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StringUtils;

public class myMethodInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("执行环绕方法，前半部分");
        Object object = methodInvocation.proceed();
        if(methodInvocation.getMethod().getName().equals("doOther")&&!StringUtils.isEmpty(object)){
            object = object.toString().toUpperCase();
        }
        System.out.println("执行环绕方法，后半部分");
        return object;
    }
}
