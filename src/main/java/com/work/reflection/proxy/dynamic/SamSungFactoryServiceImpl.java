package com.work.reflection.proxy.dynamic;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/21         zhutao                 1.0            Initial Version
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName SamSungFactoryServiceImpl
 * @Description 三星u盘厂家(被代理类) :
 * @Author zhutao
 * @Date 2021/2/21 11:47
 * @Version 1.0
 **/
@Service
@Slf4j
public class SamSungFactoryServiceImpl implements DynamicProxyService{

    //三星卖u盘
    @Override
    public int sellUsb() {
        int price = 100;
        System.out.println("三星u盘厂家卖 u盘 价格 : " + price);
        return price;
    }
}
