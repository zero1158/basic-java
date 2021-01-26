package com.work.abstract_test;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/25          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName ImplementsTest
 *@Description 接口
 *@Author zhutao
 *@Date 2021/1/25 16:28
 *@Version 1.0
 **/
public class ImplementsTest {

}

interface A{
    public void eat();
}

interface B{
    public void run();
}

/**
 * 接口之间属于继承关系,并且接口可以继承多个接口,但其实现类需要实现多个接口的方法
 */
interface C extends A,B{
}

/**
 * 需要实现接口A,B中的方法
 */
class D implements C{
    @Override
    public void eat() {
        System.out.println("D--->吃饭");
    }
    @Override
    public void run() {
        System.out.println("D--->跑步");
    }
}