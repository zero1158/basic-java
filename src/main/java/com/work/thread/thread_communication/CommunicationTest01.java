package com.work.thread.thread_communication;
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

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

/**
 *@ClassName CommunicationTest01
 *@Description 线程通信: 涉及到wait(),notify(),notifyAll()三个方法
 *@Author zhutao
 *@Date 2021/1/31 12:33
 *@Version 1.0
 **/

/**
 * 注意:
 * 1.这三个方法必须在同步方法或者同步代码块中使用
 * 2.这三个方法的调用者必须同步方法或者同步代码块中的同步监视器
 * 3.这三个方法实际是定义在Object类中的
 */
public class CommunicationTest01 {
    public static void main(String[] args) {
        Number01 number01 = new Number01();
        Number01 number02 = new Number01();

        number01.start();
        number02.start();

        Number02 number03 = new Number02();
        Number02 number04 = new Number02();

        number03.start();
        number04.start();
    }
}

class Number01 extends Thread{
    //共用变量使用static修饰
    private static int num = 0;

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            synchronized (Number.class){
                //必须用同步监视器调用
                Number.class.notify();
                if (num < 100){
                    sleep(100);
                    System.out.println(currentThread().getName()+"-->打印: "+num);
                    num++;
                    //必须用同步监视器调用
                    Number.class.wait();
                }else {
                    break;
                }
            }
        }
    }
}

/**
 * Lock内没有同步监视器Lock的实现是基于AQS(AbstractQueuedSynchronizer)实现的，
 * 其实就是一个简单的类，只是利用了优秀的设计来实现了锁。wait,notify,notifyAll调用的前提都得获得对象监视器
 * java.lang.IllegalMonitorStateException
 * 	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(ReentrantLock.java:151)
 * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(AbstractQueuedSynchronizer.java:1261)
 * 	at java.util.concurrent.locks.ReentrantLock.unlock(ReentrantLock.java:457)
 * 	at com.work.thread.thread_communication.Number02.run(CommunicationTest01.java:94)
 */
class Number02 extends Thread{
    //共用变量使用static修饰
    private static int num = 0;

    private static ReentrantLock lock = new ReentrantLock();

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            try {
                ReentrantLock.class.notify();
                lock.lock();
                if (num < 100){
                    sleep(100);
                    System.out.println(currentThread().getName()+"-->打印: "+num);
                    num++;
                    ReentrantLock.class.wait();
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}

