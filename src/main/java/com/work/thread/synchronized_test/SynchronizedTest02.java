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
 *@ClassName SynchronizedTest02
 *@Description 实现Runnable接口  解决线程安全 --> 同步代码块
 *                                          --> 同步方法
 *@Author zhutao
 *@Date 2021/1/30 20:33
 *@Version 1.0
 **/
public class SynchronizedTest02 {
    public static void main(String[] args) {
        RunnableSyn01 syn01 = new RunnableSyn01();
        //同步代码块
        Thread thread01 = new Thread(syn01);
        Thread thread02 = new Thread(syn01);
        thread01.start();
        thread02.start();

//        RunnableSyn02 syn02 = new RunnableSyn02();
//        Thread thread03 = new Thread(syn02);
//        Thread thread04 = new Thread(syn02);
//        thread03.start();
//        thread04.start();
    }
}

class RunnableSyn01 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            /**
             * 同步代码块:因为继承的方式创建线程对象时使用同一个实现类对象作为参数,
             *           所以这里可以使用this作为同步监视器
             */
            synchronized (this){
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"-->同步代码块,当前票数: "+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

/**
 * 对于实现Runnable接口的方式创建的线程而言,同步方法不需要设置成static
 */
class RunnableSyn02 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->同步方法,当前票数: " + ticket);
            ticket--;
        }
    }
}