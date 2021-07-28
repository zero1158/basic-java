package com.work.super_test;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/7/4          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName Test
 *@Description 测试重写 equals()和hashCode()方法
 *@Author zhutao
 *@Date 2021/7/4 16:57
 *@Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Animals a1 = new Animals();
        a1.setName("小明");
        a1.setAge("11");
        a1.setAderss("aaa");
        Animals a2 = new Animals();
//        a2.setName("笑话");
//        a2.setAge("22");
//        a2.setAderss("bbb");
        a2.setName("小明");
        a2.setAge("11");
        a2.setAderss("aaa");

        System.out.println(a1.equals(a2));
    }
}
