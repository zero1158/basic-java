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

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *@ClassName SemaphoreTest
 *@Description 信号量 :可增可减,当一个线程持有共享变量时,计数减1,当一个线程放弃共享变量时,计数加1,
 *  实例说明 :现在有3个停车位,却有6辆车准备停车,所以只能先抢到车位的停进去,剩下的在外面等待,直到有车出来,在停进去
 *@Author zhutao
 *@Date 2021/6/3 19:16
 *@Version 1.0
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//表示3个停车位
        //6个线程表示6辆车
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t "+"进入停车位");
                    //模拟停车5秒
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"\t "+"停车5秒后离开车位");
                } catch (InterruptedException e) { e.printStackTrace(); }
                finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
