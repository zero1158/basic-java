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
 *@ClassName Chinese
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/20 16:52
 *@Version 1.0
 **/
public class Chinese {

    private String name;
    private String age;

    /**
     * 静态变量:在类加载的时候初始化,不需要创建对象,就已经在方法区中开辟内存了
     * 访问的时候不需要创建对象,直接使用类名.变量名的方式访问
     */
    private static String COUNTRY = "中国";

    public Chinese() {
    }

    public Chinese(String name, String age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 使用static来定义静态代码块:在类加载的时候执行,并且只执行一次
     * static{
     *     java语句
     * }
     */

}
