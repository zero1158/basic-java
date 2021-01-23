package com.work.supertest;
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
 *@ClassName SuperTest02
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/21 19:30
 *@Version 1.0
 **/
public class SuperTest02 {

    /**
     * super不是一个引用,也不保存内存地址,也不指向任何对象,它只代表当前对象内部的那部分父类型特征
     * 所以是不能单独使用的,而this可以
     * @param args
     */
    public static void main(String[] args) {
        Vip vip = new Vip("小明");
        vip.shop();
    }
}

//顾客
class Customer{
    String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }
}

//vip顾客
class Vip extends Customer{

    public Vip() {
    }

    public Vip(String name) {
        super(name);
    }

    public void shop(){
        //this表示当前对象,这里的name就是jvm中创建的对象的name属性
        System.out.println(this.name+"购物");
        //super表示当前对象的父类型特征,就是this指向的jvm中的对象的一部分
        System.out.println(super.name+"购物");
        System.out.println(name+"购物");
    }
}
