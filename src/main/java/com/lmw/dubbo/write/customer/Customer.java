package com.lmw.dubbo.write.customer;

import com.lmw.dubbo.write.framework.ProxyFactory;
import com.lmw.dubbo.write.service.HelloService;

import java.io.IOException;

/**
 * 服务消费者启动类
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class Customer {
    public static void main(String[] args) throws IOException {

        // 简单实现dubbo消费者的调用 但每次都这样去调用很麻烦 我们需要简化
        /*HttpSend httpClient = new HttpSend();
        Invocation invocation = new Invocation(HelloService.class.getName(), "hello",
                new Class[]{String.class}, new Object[]{"lmw"});

        String httpClientResult = httpClient.send("localhost", 8080, invocation);
        System.out.printf(httpClientResult);*/

        // 简化版实现 需要拿到接口的代理对象 通过ProxyFactory去实现
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.hello("lmw");
        System.out.println(result);


    }
}
