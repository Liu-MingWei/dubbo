package com.lmw.dubbo.write.framework.register;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供一个注册类 用来记录接口和具体实现类的绑定关系
 * 同过接口名字可以得到生产者提供的实现类
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class LocalRegister {
    private static Map<String, Class> map = new HashMap<>(16);

    public static void register(String interfaceName, Class clazz) {
        map.put(interfaceName, clazz);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
