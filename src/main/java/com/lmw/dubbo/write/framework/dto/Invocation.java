package com.lmw.dubbo.write.framework.dto;

import java.io.Serializable;

/**
 * 用来记录生产者和消费者传递的信息实体类载体
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class Invocation implements Serializable {

    // 接口名字 通过接口名字去注册列表找到具体的接口
    private String interfaceName;

    // 方法名字
    private String methodName;

    // 方法参数类型列表(区分方法重载) 为了识别方法名字相同方法参数列表不同的方法
    private Class[] paramTypes;

    // 方法参数的值
    private Object[] params;


    public Invocation(String interfaceName, String methodName, Class[] paramTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
