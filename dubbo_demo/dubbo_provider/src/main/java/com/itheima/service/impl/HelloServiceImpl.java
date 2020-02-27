package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = HelloService.class,protocol = "dubbo") //使用dubbo提供的注解对外发布服务
public class HelloServiceImpl implements HelloService {
    @Override
    @Transactional
    public String sayHello(String name) {
        return "8081 hello " + name;
    }
}
