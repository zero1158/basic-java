package com.work.thread.lock;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/31          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName LockTest01
 *@Description 解决线程安全问题 -->Lock锁  jdk1.5新增
 *@Author zhutao
 *@Date 2021/1/31 11:28
 *@Version 1.0
 **/

import java.util.concurrent.locks.ReentrantLock;

/**
 * 步骤:
 *      1.实例化ReentrantLock类 -->ctrl+p显示类中的构造器
 *      2.调用lock()方法
 *      3.调用unlock()方法
 */
public class LockTest01 {
    public static void main(String[] args) {
        TestLock lock = new TestLock();
        Thread thread01 = new Thread(lock);
        Thread thread02 = new Thread(lock);

        thread01.start();
        thread02.start();
    }
}

class TestLock implements Runnable{
    private int i = 100;
    /**
     * ReentrantLock中有一个无参构造器和一个boolean类的构造器public ReentrantLock(boolean fair)
     * 默认为false,即获取锁时是无序的
     */
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (i > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"->当前数量: "+i);
                    i--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}


