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
 *@ClassName TestThread02
 *@Description 创建线程的方式一:继承Thread类--->Thread中的方法
 *@Author zhutao
 *@Date 2021/1/28 15:44
 *@Version 1.0
 **/

/**
 * Thread中的方法-->见图4
 * Thread中的等级-->见图5
 */
public class ThreadTest02 {

    public static void main(String[] args) {
        TestThread02 thread01 = new TestThread02("thread01-->");
        thread01.setName("线程改名: ");
        //设置线程优先级为最高
        thread01.setPriority(Thread.MAX_PRIORITY);
        thread01.start();
        for (int i = 0;i<100;i++){
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName()+" --->"+i);
            if (i == 20){
                try {
                    /**
                     * 在a线程中执行b.join()方法,意味着堵塞a线程,先执行b线程,等b线程执行完之后
                     * 在继续执行a线程
                     */
                    thread01.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class TestThread02 extends Thread{

    //自定义构造器-->通过构造器指定线程名称
    public TestThread02(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0;i<100;i++){
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName()+" --->"+i);
        }
    }
}
