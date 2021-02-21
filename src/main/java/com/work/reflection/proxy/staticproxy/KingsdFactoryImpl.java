package com.work.reflection.proxy.staticproxy;
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
 * @ClassName KingsdFactoryImpl
 * @Description 定义被代理类(目标类) : 金士顿u盘厂家首先将u盘批发卖给taobao商家
 * @Author zhutao
 * @Date 2021/2/21 11:12
 * @Version 1.0
 **/

@Service
@Slf4j
public class KingsdFactoryImpl implements StaticProxyService{


    /**
     * 被代理类实现接口
     * @return
     */
    @Override
    public int sellUsb() {
        //出厂价格
        int price = 50;
        System.out.println("被代理类(金士顿厂家) 将 u盘卖给 taobao商家(代理类)");
        return price;
    }
}
