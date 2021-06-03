package com.work.thread.lock_readorwiter;
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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *@ClassName ReadAndWiterTest
 *@Description 手写读写锁实例: 5个线程同时写如数据,另有5个线程同时读取数据
 * 写时独占锁->一个写完才能开始写入下一个; 读时共享锁->大家一起读
 *@Author zhutao
 *@Date 2021/6/3 16:08
 *@Version 1.0
 **/
public class ReadAndWiterTest {
    //模拟缓存中的数据,缓存数据修改必须立即通知其他线程更新数据,所以要用volatile修饰
    volatile Map<String,String> map = new HashMap<>();
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key,String value){

        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t  开始写入数据--->"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t  写入数据结束--->success!"+value);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t  开始读出数据--->"+key);
            String s = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t  读出数据结束--->success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadAndWiterTest readAndWiterTest = new ReadAndWiterTest();
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(()->{
                readAndWiterTest.put(finalI +"", finalI +"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(()->{
                readAndWiterTest.get(finalI+"");
            },String.valueOf(i)).start();
        }

    }
}
