package com.work.thread.pool;
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@ClassName ThreadPool01
 *@Description 创建线程方式之四 : 通过线程池
 *@Author zhutao
 *@Date 2021/1/31 13:29
 *@Version 1.0
 **/
public class ThreadPool01 {
    public static void main(String[] args) {
        //1.创建一个线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        //2.执行指定线程的指定操作,需要提供实现了Runnable接口或者Callable接口的实现类对象
        service.execute(new TestPool01());
//        service.submit(Callable callable);

        //关闭连接池
        service.shutdown();

    }
}

class TestPool01 implements Runnable{
    private static int sum = 0;

    @SneakyThrows
    @Override
    public void run() {
        for (int i=1;i<=100;i++){
            if (i % 2 == 0){
                Thread.sleep(100);
                sum += i;
                System.out.println(Thread.currentThread().getName()+"-->当前数量"+i);
            }
        }
    }
}
