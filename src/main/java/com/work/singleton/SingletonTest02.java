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
 *@ClassName Singleton02
 *@Description 单例模式之--->懒汉式:线程不安全
 *@Author zhutao
 *@Date 2021/1/22 16:40
 *@Version 1.0
 **/
public class SingletonTest02 {
    public static void main(String[] args) {
        Animal a1 = Animal.getInstance();
        Animal a2 = Animal.getInstance();

        System.out.println(a1 == a2);
    }
}

class Animal{
    //1.私有化构造器(当对象有属性时,还需要在私有化的构造器中给属性赋默认值)
    private Animal(){}
    //2.在类的内部创建对象实例,声明的对象实例必须时静态的
    private static Animal instance = null;
    //3.提供公共的静态方法将对象实例暴露出去
    public static Animal getInstance(){
        if (instance == null)
            instance = new Animal();
        return instance;
    }
}
