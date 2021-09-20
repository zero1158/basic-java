package com.work.reflection;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/20          zhutao                 1.0            Initial Version
 **/

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *@ClassName ReflectionTest02
 *@Description 通过反射获取对象并调用其中的方法,属性
 *@Author zhutao
 *@Date 2021/2/20 9:19
 *@Version 1.0
 **/
public class ReflectionTest02 {

    /**
     * 反射获取属性
     * @throws Exception
     */
    @Test
    public void getFields() throws Exception{
        //1.获取Class实例->运行时类
        Class<Person> clazz = Person.class;

        //2.1获取运行时类中的属性
        Field[] fields = clazz.getFields();
        for (Field field:fields) {
            System.out.println("--->"+field);
        }
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field1:fields1) {
            System.out.println(field1);
        }
        System.out.println("==========================================");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        //3.创建运行时类对象(通过反射获取对象),调用属性
        Person person = clazz.newInstance();
        name.set(person,"小明");
        System.out.println(person);
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        Object o = age.get(person);
        System.out.println(o);
        //获取静态常量
        Field sex = clazz.getDeclaredField("SEX");
        sex.setAccessible(true);
        Object o1 = sex.get(person);
        System.out.println("调用静态常量 : "+o1);
    }


    /**
     * 反射获取方法
     */
    @Test
    public void getMethods() throws Exception {
        Class<Person> clazz = Person.class;
        //获取运行时类对象,作为参数
        Person person = clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show01");
        //通过invoke()调用方法,返回调用方法的返回值,若没有返回值,则结果为null
        Object invoke = show.invoke(person);
        System.out.println("调用public方法,无返回值 : "+invoke);
        Method read02 = clazz.getDeclaredMethod("read02", String.class, Integer.class);
        //解除私有化限制
        read02.setAccessible(true);
        Object o = read02.invoke(person, "小红", 12);
        System.out.println("--->"+o);

        //调用静态方法
        Method run = clazz.getDeclaredMethod("run", String.class);
        run.setAccessible(true);
//        String static01 = (String) run.invoke(person,"小华");
        //调用静态方法,参数对象为null也可以,因为静态方法本身就不需要通过对象调用
        String static01 = (String) run.invoke(null,"小华");
        System.out.println("调用私有化静态方法的返回值 : "+static01);
    }
}
