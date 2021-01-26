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
 *@ClassName InnerTest01
 *@Description 内部类
 *@Author zhutao
 *@Date 2021/1/26 18:38
 *@Version 1.0
 **/

/**
 * 内部类:将一个类A声明在另一个类B中,那么A就是一个内部类,B就是外部类
 * 分为  :成员内部类(静态/非静态),局部内部类(方法内,代码块内,构造器内)
 */
public class InnerTest01 {
    public static void main(String[] args) {
        Person person = new Person();
        //1.实例化成员内部类对象(静态,非静态)
        //静态
        Person.Girl girl = new Person.Girl();
        girl.unHappy();
        //非静态
        Person.Boy boy = person.new Boy();
        boy.happy();
        //2.成员内部类种区分调用外部结构
        boy.work("小红");
        //3.开发中的局部内部类的使用-->见InnerTest02
    }
}

/**
 * 成员内部类:1.作为外部类的成员
 *              >调用外部类的结构
 *              >可以被static修饰
 *              >可以被4种权限修饰
 *           2.作为一个类
 *              >类内可以定义属性,方法,构造器
 *              >可以被final修饰,表示不能被继承
 *              >可以被abstract修饰-->不能被实例化
 */
class Person{

    private String name = "小华";
    public void eat(){
        System.out.println("吃饭......");
    }

    //非静态成员内部类
    class Boy{
        //属性
        int i = 10;
        String name ="小明";
        //构造器
        public Boy(){}
        //方法
        public void happy(){
            System.out.println("Boy --> 开心");
            //全称:Person.this.eat();
            eat();
        }

        public void work(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }
    }

    //静态成员内部类
    static class Girl{
        public void unHappy(){
            System.out.println("Girl --->不开心");
        }
    }
}
