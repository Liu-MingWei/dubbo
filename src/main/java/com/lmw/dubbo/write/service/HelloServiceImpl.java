package com.lmw.dubbo.write.service;

/**
 * 服务提供的实现类
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return name;
    }
}
