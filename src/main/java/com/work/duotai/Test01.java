package com.work.duotai;
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
 *@ClassName Test01
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/20 18:44
 *@Version 1.0
 **/
public class Test01 {

    public static void main(String[] args) {
        /**
         * new Cat()创建的时Cat类型对象,但是cat引用的类型却是Animals,这里进行了类型的转换,
         * 父类型的引用指向了子类型对象
         */
        Animals cat = new Cat();

        /**
         * java程序分为编译阶段和运行阶段,先编译在运行
         * 编译阶段:编译器检查cat这个引用的数据类型时Animals,由于Animals.class文件中包含eat()方法,
         *         所以可以编译成功,这个过程叫做静态绑定
         * 运行阶段:jvm堆内存中真实创建的对象时Cat对象,那么以下程序在运行阶段一定会调用Cat对象中的eat()方法
         *         这个过程叫做动态绑定
         * 运行阶段调用的一定是jvm堆内存中创建的真实对象
         * 注意:父类型引用指向子类型对象这种机制导致程序在编译阶段绑定和运行阶段绑定是两种不通的形态
         *      这种机制就是一种多态语法机制
         */
        cat.eat();

        /**
         * cat.catchMouse();该调用编译时,编译器发现cat的类型时Animals,而Animals的字节码中没有catchMouse()方法
         * 导致静态绑定失败
         * 当调用的方法是子类中特有的,必须向下转型,若是想要执行catchMouse()方法,必须进行类型转换,
         */
        Cat c = (Cat)cat;
        c.catchMouse();
    }
}
