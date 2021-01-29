package com.work.thread;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/29          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName RunnableTest01
 *@Description 创建线程的方式二 : 实现Runnable接口
 *@Author zhutao
 *@Date 2021/1/29 15:12
 *@Version 1.0
 **/
public class RunnableTest01 {
    /**
     * 创建线程步骤:
     * 1.创建一个类实现Runnable接口,并重写run()抽象方法
     * 2.创建实现类对象
     * 3.将此对象当作参数传到Thread类的构造器中,创建Thread对象
     * 4.用Thread对象
     */
    public static void main(String[] args) {

    }
}

class TestRunnable implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println("当前票数 -->"+ticket);
                ticket--;
            }
        }
    }
}
