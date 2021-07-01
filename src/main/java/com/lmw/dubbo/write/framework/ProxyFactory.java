package com.lmw.dubbo.write.framework;


import com.lmw.dubbo.write.framework.dto.Invocation;
import com.lmw.dubbo.write.framework.http.HttpSend;
import com.lmw.dubbo.write.framework.register.LoadBalance;
import com.lmw.dubbo.write.framework.register.RemoteMapRegister;
import com.lmw.dubbo.write.framework.register.URL;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 为消费者拿到接口的代理对象
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class ProxyFactory {

    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] {interfaceClass}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 代理逻辑
                HttpSend httpClient = new HttpSend();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),
                        method.getParameterTypes(), args);
                // 获取接口绑定的远程调用地址
                // 虽然生产者把url注册进去了 但是消费者拿不到 因为生产者和消费者是两个jvm
                // 所以得采用zk或者redis当注册中心
                 List<URL> urlList = RemoteMapRegister.get(interfaceClass.getName());
                // 根据负载均衡算法取一个地址
                URL url = LoadBalance.random(urlList);
                // 发起Http请求
                String httpClientResult = httpClient.send("localHost",8082, invocation);
                return httpClientResult;
            }
        });
    }
}
