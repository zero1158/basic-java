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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TaobaoProxyImpl
 * @Description 创建代理类对象 : 淘宝商家(代理金士顿厂家进行销售)
 * @Author zhutao
 * @Date 2021/2/21 11:16
 * @Version 1.0
 **/

@Slf4j
@Service
public class TaobaoProxyImpl implements StaticProxyService{

    //声明要代理的厂家
    @Autowired
    private KingsdFactoryImpl kingsdFactory;

    @Override
    public int sellUsb() {
        //调用被代理类的方法,从厂家获取u盘,获取出厂价格
        int i = kingsdFactory.sellUsb();
        //商家加价,包装等处理后,得到销售价格,在卖个客户
        int price = i + 30;
        System.out.println("淘宝商家 加价销售 u盘(代理类对被代理类中的方法进行增强等操作)-------");

        return price;
    }
}
