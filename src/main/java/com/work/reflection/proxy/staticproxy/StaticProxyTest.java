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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName StaticProxyTest
 * @Description 测试静态代理写法
 * @Author zhutao
 * @Date 2021/2/21 11:03
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticProxyTest {

    @Autowired
    private TaobaoProxyImpl service;

    @Test
    public void StaticProxy(){
        int i = service.sellUsb();
        System.out.println(i);
    }

}
