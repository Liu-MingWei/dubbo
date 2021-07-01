package com.lmw.dubbo.write.framework.register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 远程服务注册中心 用于注册端口和地址
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class RemoteMapRegister {
    private static Map<String, List<URL>> Register = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> urlList = Register.get(interfaceName);
        if (urlList == null) {
            urlList = new ArrayList<>();
        }
        urlList.add(url);
        Register.put(interfaceName, urlList);
    }

    public static List<URL> get(String interfaceName) {
        List<URL> urlList = Register.get(interfaceName);
        return urlList;
    }
}
