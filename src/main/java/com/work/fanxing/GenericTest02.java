package com.work.fanxing;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/16          zhutao                 1.0            Initial Version
 **/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *@ClassName GenericTest02
 *@Description 继承关系 和 通配符
 *@Author zhutao
 *@Date 2021/2/16 10:50
 *@Version 1.0
 **/
public class GenericTest02 {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        show(list1); //成功
//        show(list2); //编译报错 -->类型不同
        /**
         * 对于一个入参是List<Object>的方法来说,list2就是无法作为参数的,
         * 怎样才能实现入参是List类型的就可以呢?
         * 这里就要使用到通配符 ? ,设置List<?> 意味着? 是 一个公共的父类
         */

        show1(list1);
        show1(list2);
    }

    public static void show(List<Object> list){

    }
    //通配符的使用
    public static void show1(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
