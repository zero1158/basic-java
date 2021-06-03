package com.work.thread.lock_delay;
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

import java.util.concurrent.CountDownLatch;

/**
 *@ClassName CountDownLatchTest
 *@Description 计数减的代码实现
 *  试用举例 : 全班有7个人,班长负责锁门-->班长必须最后一个离开,且离开时锁门
 *@Author zhutao
 *@Date 2021/6/3 17:23
 *@Version 1.0
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        //除了班长,其他六个人必须先走
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"\t " + "离开了教室");
            },String.valueOf(i)).start();
        }
        //main线程(主线程作为班长),最后离开,并且关门
        try {
            countDownLatch.await();
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName()+"\t "+"班长最后走并且锁门");
    }
}
