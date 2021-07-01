package com.lmw.dubbo.spi.service;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author liumingwei
 * @date 2021/6/15
 */
@SPI
public interface Car {
    String hello();
}
