package com.work.singleton;
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
 *@ClassName SingletonTest01
 *@Description 单例设计模式之--->饿汉式,线程安全
 * 例:见RunTime.class
 *@Author zhutao
 *@Date 2021/1/22 16:00
 *@Version 1.0
 **/
public class SingletonTest01 {
    public static void main(String[] args) {
        Person p1 = Person.getInstance();
        Person p2 = Person.getInstance();

        //判断是不是通过一个对象实例
        System.out.println(p1 == p2);
    }
}

/**
 * 对象
 */
class Person{
    //1.私有化构造器(当对象有属性时,还需要在私有化的构造器中给属性赋默认值)
    private Person(){}
    //2.在类的内部创建对象实例,声明的对象实例必须时静态的
    private static Person instance = new Person();
    //3.提供公共的静态方法将对象实例暴露出去
    public static Person getInstance(){
        return instance;
    }
}
