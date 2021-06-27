package com.work.thread.lock_other;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/6/3          zhutao                 1.0            Initial Version
 **/

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 *@ClassName SynchronousQueueTest
 *@Description SynchronousQueue同步阻塞队列 代码演示
 *@Author zhutao
 *@Date 2021/6/3 20:22
 *@Version 1.0
 **/
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue queue = new SynchronousQueue();
        //负责放 ->一次性放入三个
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t 放入"+1);
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t 放入"+2);
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t 放入"+3);
                queue.put("3");
            } catch (InterruptedException e) { e.printStackTrace(); }
        },"aaa").start();
        //负责取 ->每3秒取一次
        new Thread(()->{
            try {
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t 取出"+queue.take());

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t 取出"+queue.take());

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t 取出"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bbb").start();
    }
}
