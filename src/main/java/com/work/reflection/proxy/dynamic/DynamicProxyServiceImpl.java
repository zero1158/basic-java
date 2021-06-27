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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxyServiceImpl
 * @Description 商家(动态代理类) : 将从厂家拿到的u盘销售出去,不指定具体的商家(动态生成代理类)
 * @Author zhutao
 * @Date 2021/2/21 11:50
 * @Version 1.0
 **/
@Slf4j
@Service
public class DynamicProxyServiceImpl implements InvocationHandler {

    @Autowired
    private SamSungFactoryServiceImpl samSungFactoryService;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理类中的方法
        int invoke = (int) method.invoke(samSungFactoryService);
        System.out.println("------->已执行完被代理类中的方法");
        //进行方法增强等操作
        int price = invoke + 20;
        System.out.println("代理类对'被代理类'中的方法进行功能增强");
        return price;
    }
}
