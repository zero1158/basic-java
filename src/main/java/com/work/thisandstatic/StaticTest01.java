package com.work.thisandstatic;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/20          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName StaticTest01
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/20 17:09
 *@Version 1.0
 **/
public class StaticTest01 {

    /**
     * 静态代码块:在类加载的时候执行,并且只执行一次
     *           在类中可以写多个,并且遵循自上而下的执行顺序
     */
    static{
        System.out.println("1)静态代码块执行......");
    }

    static{
        System.out.println("2)静态代码块执行......");
    }

    public static void main(String[] args) {
        System.out.println("main方法执行.......");
    }

}
