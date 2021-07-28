package com.work.super_test;
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

import lombok.Data;

import java.util.Objects;

/**
 *@ClassName Animals
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/20 18:32
 *@Version 1.0
 **/
@Data
public class Animals {

    private String name;
    private String age;
    private String aderss;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        System.out.println("开始调用equals()方法");
        return Objects.equals(name, animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, aderss);
    }

    public void run(){
        System.out.println("跑.............");
    }

}
