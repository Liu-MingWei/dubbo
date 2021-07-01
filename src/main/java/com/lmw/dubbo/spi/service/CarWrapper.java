package com.lmw.dubbo.spi.service;

/**
 * @author liumingwei
 * @date 2021/6/16
 */
public class CarWrapper implements Car {
    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    @Override
    public String hello() {
        System.out.println("AOP");

        return car.hello();
    }
}
