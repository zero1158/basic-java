package com.work.thread.lock_spin;
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

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 *@ClassName SpinLockTest
 *@Description 手写自旋锁 : 模拟当获取锁的线程发现,锁已经被其他线程获取后,自旋等待的流程
 *@Author zhutao
 *@Date 2021/6/3 11:46
 *@Version 1.0
 **/
public class SpinLockTest {
    /**
     * 创建一个原子引用类,将线程类(Thread)当作引用类,不设置默认值,则默认值为null
     */
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    //加锁
    public void mySpinLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t"+"开始进入线程----->加锁");
        while (!atomicReference.compareAndSet(null,thread)){
            //开始自旋等待
        }
    }
    //解锁
    public void UnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t"+"开始进入线程------>解锁");
    }

    public static void main(String[] args) {
        SpinLockTest test = new SpinLockTest();
        new Thread(()->{
            test.mySpinLock();
            //睡5秒模拟,锁被占用5秒
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            test.UnLock();
        },"aaa").start();
        //主线程睡1秒,让aaa线程先获得锁并加锁-->bbb线程无法获取锁,进入自旋状态等待
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(()->{
            test.mySpinLock();
            test.UnLock();
        },"bbb").start();
    }
}
