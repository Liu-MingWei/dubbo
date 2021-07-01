package com.lmw.dubbo.spi.service;

/**
 * @author liumingwei
 * @date 2021/6/15
 */
public class BlackCar implements Car {
    @Override
    public String hello() {
        return "BlackCar";
    }
}
