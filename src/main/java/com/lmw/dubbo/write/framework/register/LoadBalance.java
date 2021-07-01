package com.lmw.dubbo.write.framework.register;

import java.util.List;
import java.util.Random;

/**
 * 负载均衡算法 根据多个地址选择一个调用地址
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class LoadBalance {
    public static URL random(List<URL> list) {
        Random random = new Random();
        int n = 0;
        if (list != null) {
            n = random.nextInt(list.size());
        }
        return list.get(n);
    }
}
