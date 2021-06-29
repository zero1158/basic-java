package com.work.reflection.proxy.CGLB;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/6/29          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName HelloService
 *@Description 模拟CGLB动态代理 -- 被代理对象
 *@Author zhutao
 *@Date 2021/6/29 11:05
 *@Version 1.0
 **/
public class HelloService {

    public HelloService() {
        System.out.println("HelloService构造");
    }

    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>"+name);
        return null;
    }

    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}
