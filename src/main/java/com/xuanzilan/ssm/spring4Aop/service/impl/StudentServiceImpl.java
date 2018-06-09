package com.xuanzilan.ssm.spring4Aop.service.impl;

import com.xuanzilan.ssm.spring4Aop.service.IStudentService;
import org.apache.log4j.Logger;

public class StudentServiceImpl implements IStudentService {
    Logger logger =Logger.getLogger(StudentServiceImpl.class);

    public void doSome() {
        System.out.println("执行doSome方法");
    }

    public String doOther() {
        System.out.println("执行doOther方法");
        return "abcde";
    }

    public String doHello(String name) {
        System.out.println("执行doHello方法");
        return "Hello,"+name;
    }

    public void doThrow() throws Exception {
        throw new Exception("抛异常了");
    }
}
