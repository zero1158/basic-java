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

/**
 *@ClassName ExtendsTest
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/20 17:19
 *@Version 1.0
 **/

/**
 * 面象对象三大特征:封装,继承,多态
 * 继承的基本作用时代码的复用,但是更"重要"的作用是:有了继承才有"方法覆盖"和"多态机制"
 * 子类无法继承父类中的:  1.私有的不支持继承
 *                      2.构造方法不支持继承
 */
public class ExtendsTest {

    public static void main(String[] args) {
        /**
         * 方法的重写: 1.只发生在具有继承关系的父子类中
         *            2.方法重写时:返回值相同,方法名相同,参数列表相同
         *            3.方法重写时访问权限不能更低,可以更高,抛出的异常不能更多,可以更少
         */
        Cat cat = new Cat();
        cat.run();

        /**
         * 方法的重载:在同一个类中方法名相同,参数列表不同,和方法的返回值无关和方法的修饰符无关
         */
    }

}
