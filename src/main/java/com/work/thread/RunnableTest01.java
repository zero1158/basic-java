package com.work.thread;
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
 *@ClassName RunnableTest01
 *@Description 创建线程的方式二 : 实现Runnable接口
 *@Author zhutao
 *@Date 2021/1/29 15:12
 *@Version 1.0
 **/
public class RunnableTest01 {
    /**
     * 创建线程步骤:
     * 1.创建一个类实现Runnable接口,并重写run()抽象方法
     * 2.创建实现类对象
     * 3.将此对象当作参数传到Thread类的构造器中,创建Thread对象
     * 4.用Thread对象的start()方法调用线程
     */
    public static void main(String[] args) {
        TestRunnable runnable = new TestRunnable();
        Thread thread = new Thread(runnable);
        //启动一个线程
        thread.start();
        //启动多个线程
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        /**
         * 创建thread,thread1,thread2线程时,因为是共用同一个对象runnable作为参数创建的线程,
         * 所以他们共享runnable中的变量ticket,所以不需要加static就可以保证公用变脸tikect
         * 而对于继承的方式创建线程来说,每一次new xxxThread()就是创建了一个新对象,就会添加一个ticket变量
         * 此时需要将变量设置为static,才可以作为公用变量
         */
    }
}

class TestRunnable implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "当前票数 -->"+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
