package com.work.abstract_implements;
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
 *@ClassName TemplateTest
 *@Description 模板方法设计模式--->抽象类的应用
 *@Author zhutao
 *@Date 2021/1/25 14:45
 *@Version 1.0
 **/

/**
 * 抽象类作为多个子类的通用模板,子类在抽象类的基础上进行扩展,改造,但子类总体上会保留抽象类的行为方式
 * 当功能内部一部分实现是确定的,另一部分是不确定的,这时可以把不确定的地方暴露出去,由子类实现
 */
public class TemplateTest {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.getTime();
    }
}

abstract class Animal{
    public void getTime(){
        long startTime = System.currentTimeMillis();
        //不确定的实现部分,交给子类中的具体情况决定
        this.code();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
    abstract public void code();
}

class Cat extends Animal{

    @Override
    public void code() {
        for (int i=1;i<111;i++){
            System.out.println(i);
        }
    }
}
