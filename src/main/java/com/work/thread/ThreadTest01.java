package com.work.thread;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/28          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName ThreadTest01
 *@Description 创建线程的方式一:继承Thread类
 *@Author zhutao
 *@Date 2021/1/28 10:02
 *@Version 1.0
 **/
public class ThreadTest01 {
    /**
     * 1.创建一类继承Thread类,并重写其中的run()方法,在重写的run()中写自己要执行的逻辑
     * 2.创建Thread类的子类对象
     * 3.通过此对象调用strat()方法,启动新线程
     *  注意:-->对象.strat()方法其实还是调用的当前线程的run()方法,但是我们不能直接调用run(),这样不会启动新线程
     *  注意:-->一个子类对象只能调用启动一次线程
     */
    public static void main(String[] args) {
        TestThread01 thread01 = new TestThread01();
        TestThread01 thread02 = new TestThread01();
        System.out.println("------->主线程");
        //启动一个新的线程
        thread01.start();
        //启动多个线程
        thread02.start();
        //主线程中执行
        for (int i = 0;i<100;i++){
            if (i % 2 == 0)
                System.out.println("主线程 --->"+i);
        }
        System.out.println("主线程---------->结束!!!");
        /**
         * 使用匿名子类启动线程
         */
        new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<10;i++){
                    if (i % 2 == 0)
                        System.out.println("匿名子类启动线程 --->"+i);
                }
            }
        }.start();
    }
}

class TestThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<100;i++){
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName()+" --->"+i);
        }
    }
}