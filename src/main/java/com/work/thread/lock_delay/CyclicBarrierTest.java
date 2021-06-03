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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *@ClassName CyclicBarrierTest
 *@Description 循环屏障 - 计数器加1,直到到达预计值,被阻塞的线程才开始运行
 * 试用举例 :7个人开会,只有人全部到齐了,才能开始
 *@Author zhutao
 *@Date 2021/6/3 18:05
 *@Version 1.0
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7
                //计数完成要做的事
                ,()->{System.out.println(Thread.currentThread().getName()+"\t "+"开始会议");});
        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t "+"进入了会议");
                try {
                    //人没到齐,先到的线程被阻塞
                    cyclicBarrier.await();
                } catch (InterruptedException e) { e.printStackTrace(); } catch (BrokenBarrierException e) { e.printStackTrace(); }
            },String.valueOf(i)).start();
        }
    }
}
