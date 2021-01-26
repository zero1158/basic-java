package com.work.abstract_implements;
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
 *@ClassName ImplementsTest02
 *@Description 接口-->在jdk7中:只能定义全局变量和抽象方法
 *                              >全局变量:由public static final修饰,但是可以不写
 *                              >抽象方法:public abstract,但是一般都可以省略
 *                    在jdk8中:除了全局变量和抽象方法还可以定义静态方法和默认方法
 *@Author zhutao
 *@Date 2021/1/26 17:24
 *@Version 1.0
 **/
public class ImplementsTest02 {
    public static void main(String[] args) {
        StudentImpl student = new StudentImpl();
        //1.接口中的静态方法,只能通过接口调用,无法通过实现类调用
        Person01.run();
        //2.实现类可以调用接口中的默认方法,若是实现类重写了默认方法,则调用的是重写后的方法
        student.look();
        //3.若子类(或实现类)继承的父类和实现的接口中声明了同名同参数列表的默认方法,
        // 那么在子类没有重写改方法时-->类优先原则
        student.smile();

        //4.若实现类实现了多个接口,而这些接口中定义了同名同参数列表的默认方法,
        // 那么在实现类没有重写改方法的前提下,实现类报错->接口冲突
    }
}

/**
 * 接口01
 */
interface Person01{
    //全局变量-->虽然没有写出来,但是实际上是个final修饰的,无法修改
    int i = 10;
    //抽象方法
    public abstract void eat();

    public static void run(){
        System.out.println("跑步...........");
    }

    //默认方法
    default void look(){
//        i = 20;修改会报错
        System.out.println(i+"Person01-->默认方法-->看书..........");
    }
    //默认方法
    default void smile(){
        System.out.println(i+"默认方法-->笑..........");
    }
    //默认方法
    default void work(){
        System.out.println("Person01-->默认方法-->工作..........");
    }

}

/**
 * 实现类
 */
class StudentImpl extends People implements Person01,Person02 {

    @Override
    public void eat() {
        System.out.println("吃饭.........");
    }

    @Override
    public void look() {
        System.out.println("实现类重写默认方法.........");
    }

    @Override
    public void work() {
        System.out.println("实现类重写  Person01和Person02中同名同参的默认方法.........");
    }
}

/**
 * 父类
 */
class People{
    public void smile(){
        System.out.println("父类中的同名方法------>和接口默认方法同名");
    }
}
/**
 * 接口02
 */
interface Person02{
    default void work(){
        System.out.println("Person02-->默认方法-->工作..........");
    }
}
