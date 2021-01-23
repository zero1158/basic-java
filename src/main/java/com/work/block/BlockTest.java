package com.work.block;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/22          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName BlockTest
 *@Description 代码块
 *@Author zhutao
 *@Date 2021/1/22 16:54
 *@Version 1.0
 **/
public class BlockTest {
    public static void main(String[] args) {
        String sex = A.sex;
        System.out.println(sex);
        A a = new A();
        System.out.println(A.sex);
        System.out.println(a.name);
        System.out.println(a.age);
    }
}

/**
 * 代码块的作用:用来初始化类,对象
 * 代码块的修饰词:static,所以只有静态代码块和非静态代码块的区别
 * 静态代码块:   1.内部可以有输出语句
 *              2.在类被加载的时候执行,且只执行一次-->可以用作初始化信息
 *              3.不能调用非静态方法和变量
 *              4.静态代码块要比非静态代码块优先执行,当有多个静态代码块时,按顺序执行
 * 非静态代码块: 1.内部可以有输出语句
 *              2.在类被创建的时候执行(new),且没创建一个对象就执行一次
 *              3.可以调用静态属性,方法或非静态方法,属性
 */
class A{
    String name;
    String age;
    static String sex = "男";

    {
        System.out.println("这是一个非静态代码块");
        sex = "女";
        name = "小明";
    }
    static {
        System.out.println("这是一个静态代码块");
//        eat();不能待用非静态方法和变量
        sex = "随便写点..";
    }
    {
        System.out.println("这是另个非静态代码块");
        age = "18";
        eat();
    }

    public A() {
    }

    public A(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("这是一个实例方法");
    }

    public static void run(){
        System.out.println("这是一个静态方法");
    }
}