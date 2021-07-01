package com.lmw.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import com.lmw.dubbo.spi.service.Car;

/**
 * @author liumingwei
 * @date 2021/6/15
 */
public class Test {
    public static void main(String[] args) {
        /*ExtensionLoader<Protocol> extensionLoaderProtocol = ExtensionLoader.getExtensionLoader(Protocol.class);
        Protocol dubbo = extensionLoaderProtocol.getExtension("dubbo");
        System.out.println(dubbo);
        System.out.println("+++++++++++++");*/


        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
/*
        System.out.println(extensionLoader.toString());
*/
        Car carRed = extensionLoader.getExtension("red");
        System.out.println(carRed.hello());

        /*System.out.println(carRed.hello());*/
        /*Car carBlackCar = extensionLoader.getExtension("blackCar");
        System.out.println(carRed.hello());
        System.out.println(carBlackCar);*/

    }
}
