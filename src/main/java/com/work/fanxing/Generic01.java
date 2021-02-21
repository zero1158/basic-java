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

import lombok.Data;

/**
 *@ClassName Generic
 *@Description 泛型类
 *@Author zhutao
 *@Date 2021/2/16 10:23
 *@Version 1.0
 **/
@Data
public class Generic01<T> {
    private String name;
    private Integer age;

    /**
     * 泛型
     */
    T order;

    public Generic01() {
    }

    /**
     * 泛型类中的构造器需要添加泛型,但是在使用泛型类的时候需要添加泛型
     */
    public Generic01(String name, Integer age, T order) {
        this.name = name;
        this.age = age;
        this.order = order;
    }

}
