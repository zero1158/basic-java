package com.work.inner_class;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/26          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName InnerTest02
 *@Description 内部类--->局部内部类:在方法中,代码块中,构造器中
 *@Author zhutao
 *@Date 2021/1/26 19:07
 *@Version 1.0
 **/
public class InnerTest02 {
    public static void main(String[] args) {
        /**
         * 开发中常见在方法中的局部内部类
         */

    }
}

class People {
    //方法中的局部内部类
    public void method() {
        class AA {

        }
    }

    //代码块中的局部内部类
    {
        class BB{

        }
    }

    //构造器中的局部内部类
    public People(){
        class CC{

        }
    }

    //返回一个实现了Comparable接口的类的对象--->标准版
    public Comparable getComparable01(){
        //局部内部类
        class MyComparable implements Comparable{
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new MyComparable();
    }

    //创建了一个实现Comparable接口的匿名实现类的匿名对象-->
    public Comparable getComparable02(){
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
