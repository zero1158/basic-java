package com.work.thread.synchronized_test;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/30          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName SynchronizedSingletonTest
 *@Description 懒汉式 -->线程安全问题
 *@Author zhutao
 *@Date 2021/1/30 20:45
 *@Version 1.0
 **/
public class SynchronizedSingletonTest {
    public static void main(String[] args) {
        SingletonTest instance01 = SingletonTest.getInstance();
        SingletonTest instance02 = SingletonTest.getInstance();
        System.out.println(instance01 == instance02);
        System.out.println(instance01.toString());
        System.out.println(instance02.toString());

//        SingletonTest instance03 = SingletonTest.getInstance01();
//        SingletonTest instance04 = SingletonTest.getInstance01();
//        System.out.println(instance03 == instance04);
//        System.out.println(instance03.toString());
//        System.out.println(instance04.toString());
    }
}

//懒汉式
class SingletonTest{
    private SingletonTest(){
    }
    private static SingletonTest instance = null;
    public static SingletonTest getInstance(){
        if (instance == null){
            synchronized (SingletonTest.class) {
                instance = new SingletonTest();
            }
        }
        return instance;
    }

    public static synchronized SingletonTest getInstance01(){
        if (instance == null){
            instance = new SingletonTest();
        }
        return instance;
    }
}
