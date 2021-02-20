package com.work.reflection;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/19          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName ReflectionTest01
 *@Description 获取Class类实例的方式
 *@Author zhutao
 *@Date 2021/2/19 19:53
 *@Version 1.0
 **/
public class ReflectionTest01 {
    public static void main(String[] args) throws Exception {
        //1.调用运行时类的属性 : .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //2.通过运行时类的对象,调用getClass()
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
        //3.调用Class类的静态方法: 会抛出一个找不到该类的异常
        Class<?> clazz3 = Class.forName("com.work.reflection.Person");
        System.out.println(clazz3);
        //4.使用类加载器(了解):先获取系统类加载器(App ClassLoader),通过类加载手动加载类,生成运行时类
        ClassLoader classLoader = ReflectionTest01.class.getClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("类加载器"+classLoader);
        Class<?> clazz4 = classLoader.loadClass("com.work.reflection.Person");
        System.out.println(clazz4);

        //加载到内存中的运行时类,一个对象只会存在一个,且会缓存一定时间
        System.out.println(clazz1==clazz2);
        System.out.println(clazz2==clazz3);
        System.out.println(clazz3==clazz4);
    }
}
