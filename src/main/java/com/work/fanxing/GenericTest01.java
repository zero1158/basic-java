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
import java.util.List;

/**
 *@ClassName GenericTest01
 *@Description 泛型类  和  泛型方法  --> 验证
 *@Author zhutao
 *@Date 2021/2/16 10:09
 *@Version 1.0
 **/
public class GenericTest01 {
    public static void main(String[] args) {

    }

    /**
     * 泛型方法之 : 静态方法
     * 泛型方法所属的类是不是泛型的都没有关系
     * 需要在返回类型前加<E>声明这是个泛型
     * @return
     */
    public static <E> List<E> getList(E[] arr){
        List<E> list = new ArrayList<>();
        return list;
    }

    /**
     * 泛型方法之 : 非静态方法
     * @return
     */
    public <T> List<T> getList2(){
        List<T> list = new ArrayList<>();
        return list;
    }
}

