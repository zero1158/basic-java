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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicTest
 * @Description 动态代理测试
 * @Author zhutao
 * @Date 2021/2/21 11:44
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicTest {

    @Autowired
    private SamSungFactoryServiceImpl samSungFactoryService;

    @Autowired
    private DynamicProxyServiceImpl dynamicProxyService;

    @Test
    public void DynamicProxy(){
        //获取代理类对象
        DynamicProxyService proxy = (DynamicProxyService) Proxy.newProxyInstance(samSungFactoryService.getClass().getClassLoader(),
                samSungFactoryService.getClass().getInterfaces(),
                dynamicProxyService);

        int sellUsb = proxy.sellUsb();
        System.out.println("------------>"+sellUsb);
    }

}
