package com.lmw.dubbo.write.provider;

import com.lmw.dubbo.write.framework.http.HttpService;
import com.lmw.dubbo.write.framework.register.LocalRegister;
import com.lmw.dubbo.write.service.HelloService;
import com.lmw.dubbo.write.service.HelloServiceImpl;
import com.lmw.dubbo.write.framework.register.RemoteMapRegister;
import com.lmw.dubbo.write.framework.register.URL;

import java.net.MalformedURLException;


/**
 * 服务提供者 启动类
 * 一个服务提供者要做的步骤
 * 1、提供服务接口
 * 2、提供实现类
 * 3、注册服务接口
 * 4、暴露服务(通过Tomcat等)
 */
public class Provider {
    public static void main(String[] args) throws MalformedURLException {
        // 注册生产者接口和实现类的绑定关系
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        // 注册接口和调用服务的地址绑定关系
        URL url1 = new URL("localhost",8082);
        URL url2 = new URL("localhost",8083);
        // 虽然生产者把url注册进去了 但是消费者拿不到 因为生产者和消费者是两个jvm
        // 所以得采用zk或者redis当注册中心
        RemoteMapRegister.register(HelloService.class.getName(), url1);
        RemoteMapRegister.register(HelloService.class.getName(), url2);

        // 启动自己实现的Tomcat
        HttpService httpService = new HttpService();
        httpService.start(url1.getHostName(),url1.getPost());
    }
}
