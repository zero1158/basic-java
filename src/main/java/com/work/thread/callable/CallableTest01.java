package com.work.thread.callable;
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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@ClassName CallableTest01
 *@Description 创建线程的方式之三: 实现Callable接口
 *@Author zhutao
 *@Date 2021/1/31 13:09
 *@Version 1.0
 **/

/**
 * 步骤:
 *      1.创建一个类实现Callable接口,并重写接口中的call()方法
 *      2.创建实现类对象
 *      3.将这个Callable接口实现类对象作为参数传到FutureTask构造器中,创建FutureTask对象
 *      4.将FutureTask对象作为参数传到Thread类的构造器中,创建Thread对象,调用start()方法启动线程
 */
public class CallableTest01 {
    public static void main(String[] args) {
        TestCallable01 call = new TestCallable01();
        FutureTask task = new FutureTask(call);
        Thread thread = new Thread(task);
        thread.start();

        /**
         * 使用泛型的方式获取返回值
         */
        FutureTask<Integer> task01 = new FutureTask(call);
        Thread thread1 = new Thread(task01);
        thread1.start();

        try {
            //获取线程执行之后的返回值
            Object obj = task.get();
            //获取指定类型的返回值
            Integer integer = task01.get();

            System.out.println(obj);
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 其中public interface Callable<V>是一个泛型的接口,我们可以在实现接口的时候指定返回类型,
 * 并且public FutureTask(Callable<V> callable) ,FutureTask也是包含泛型的,也需要在创建FutureTask对象的
 * 时候指定泛型类型且和实现类一致,这样我们就可以直接获取期望的返回值类型了
 */
class TestCallable01 implements Callable<Integer>{
    private int sum = 0;
    @Override
    public Integer call() throws Exception {
        for (int i=1;i<=100;i++){
            if (i % 2 == 0){
                Thread.sleep(100);
                sum += i;
                System.out.println(Thread.currentThread().getName()+"-->当前数量"+i);
            }
        }
        return sum;
    }
}
