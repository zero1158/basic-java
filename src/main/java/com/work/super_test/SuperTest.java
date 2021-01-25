package com.work.super_test;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/21          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName SuperTest
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/21 9:57
 *@Version 1.0
 **/
public class SuperTest {

    /**
     * super()方法的的作用,其实就是初始化当前对象的父类型特征,并不是创建父对象,实际上对象只创建了一个
     * super代表的是当前对象的父类型特征
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 一个类若是不提供任何构造方法则默认提供一个无参构造方法,若是已经手动提供了构造方法,
         * 则系统不会在提供无参构造方法,
         * this()与super()不能共存:super()->子类调用父类的无参构造方法
         *                        this()->在构造方法中调用其他的构造方法,其实在其他的构造方法中还是会有super()
         */
        new B();
    }
}

class A{
    public A(){
        System.out.println("A类的无参构造方法");
    }

    public A(int i){
        System.out.println("A类的有参构造方法--->"+i);
    }
}

class B extends A{
    public B(){
//        super();此处有一个隐藏的super(),在子类的构造方法中调用父类的无参构造
        this("小明");
        System.out.println("B类的无参构造方法");
    }

    public B(String name){
        System.out.println("B类的有参构造方法--->"+name);
    }
}
