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

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

/**
 *@ClassName LockTest02
 *@Description 例: 有两个储户分别向同一个账户中存3000元，每次存1000，存完打印账户余额
 *@Author zhutao
 *@Date 2021/1/31 12:01
 *@Version 1.0
 **/
public class LockTest02 {
    public static void main(String[] args) {
        //账户
        Accent accent = new Accent();
        //储户1号
        Customer01 customer01 = new Customer01(accent);
        //储户2号
        Customer01 customer02 = new Customer01(accent);

        customer01.start();
        customer02.start();
    }
}

/**
 * 账户对象
 */
class Accent{
    private int accent = 0;

    @SneakyThrows
    public void insertMoney(double amt) {
        Thread.sleep(1000);
        accent += amt;
        System.out.println(Thread.currentThread().getName()+"->存钱: "+amt+"当前余额: "+accent);
    }
}

/**
 * 储户对象01
 */
class Customer01 extends Thread{

    private Accent accent;

    //自定义一个有参构造器-->将账户作为储户的属性
    public Customer01(Accent accent){
        this.accent = accent;
    }
    //这里的lock对象需要是静态的 被static修饰
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lock();
            //分三次存钱
            for (int i = 0;i < 3;i++){
                //调用账户中的存钱方法
                accent.insertMoney(1000);
            }
        }finally {
            lock.unlock();
        }

    }
}
