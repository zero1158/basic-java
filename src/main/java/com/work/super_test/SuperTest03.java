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
 *@ClassName SuperTest02
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/21 19:30
 *@Version 1.0
 **/
public class SuperTest03 {

    public static void main(String[] args) {
        Dog dog = new Dog("花花");
        dog.run();
    }
}

//顾客
class Animal{
    String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }
}

//vip顾客
class Dog extends Animal{

    /**
     * 子类中存在和父类相同的属性:
     * 在构造方法中,是需要给所有的属性赋一个默认值的,当子类中有和父类相同的属性,调用有参构造的时候,实际上
     * 在super()方法后面还会执行this.name=null的默认语句
     */
    String name;

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    public void run(){
        //this表示当前对象,这里的name就是jvm中创建的对象的name属性,此时已被默认一句设置为null
        System.out.println(this.name+"跑......");
        //super表示当前对象的父类型特征,就是this指向的jvm中的对象的一部分,就是父类型的属性,为花花
        System.out.println(super.name+"跑.....");
        System.out.println(name+"跑.....");
    }
}
