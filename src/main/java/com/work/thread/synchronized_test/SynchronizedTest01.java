package com.work.thread.synchronized_test;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/29          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName SynchronizedTest01
 *@Description 继承Thread类 解决线程安全  -->使用同步代码块
 *                                      -->同步方法
 *@Author zhutao
 *@Date 2021/1/29 15:11
 *@Version 1.0
 **/
public class SynchronizedTest01 {
    public static void main(String[] args) {
        //测试同步代码块
//        ThreadSyn01 syn01 = new ThreadSyn01();
//        ThreadSyn01 syn02 = new ThreadSyn01();
//        syn01.start();
//        syn02.start();

        //测试同步方法
        ThreadSyn02 syn03 = new ThreadSyn02();
        ThreadSyn02 syn04 = new ThreadSyn02();
        syn03.start();
        syn04.start();
    }
}

//同步代码块
class ThreadSyn01 extends Thread{

    private static int ticket = 100;
    /**
     * 创建一个对象作为同步监视器,可以是任意对象,但是synchronized中使用的必须时同一个对象
     * 也可以直接使用类.class的形式-->实际上是:Class cla = xxxx.class;
     */
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //同步代码块
            synchronized (ThreadSyn01.class){
                if(ticket > 0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(currentThread().getName()+"-->同步代码块,当前票数: "+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

//同步方法
class ThreadSyn02 extends Thread{
    private static int ticket1 = 100;

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    /**
     * 用继承Thread的方式创建的线程,在使用同步方法的时候,必须将同步方法设置成静态的,
     * 因为,同步方法的同步监视器就是this,只是省略了没有写出,当没新建一个线程的时候所对应的this都是不同的
     * 所以线程还是不安全的
     */
    public static synchronized void show(){
        if (ticket1 > 0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName()+"-->同步方法,当前票数: "+ticket1);
            ticket1--;
        }
    }
}
