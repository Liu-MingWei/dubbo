package com.lmw.dubbo.write.framework.http;


import com.alibaba.fastjson.JSONObject;
import com.lmw.dubbo.write.framework.register.LocalRegister;
import com.lmw.dubbo.write.framework.dto.Invocation;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;

/**
 * 请求接受类 dubbo源码使用的是netty框架实现的
 * 用来处理Http请求逻辑具体实现类 get/post等请求
 * 相当于是DispatcherServlet的实现类
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class HttpServiceHandler {

    protected void handler(HttpServletRequest req, HttpServletResponse resp) {
        // 把生产者发送的参数取出来 就是把Invocation对象拿出来
        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            String interfaceName = invocation.getInterfaceName();
            // 根据生产者提供的名字去注册中心表取出对应的实现类
            Class implClass = LocalRegister.get(interfaceName);
            // 根据类名以及类型参数列表拿到对应的方法
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            // 传入方法的实例和方法参数执行对应的方法
            Object result = method.invoke(implClass.newInstance(), invocation.getParams());

            //返回结果
            IOUtils.write(result.toString(), resp.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
