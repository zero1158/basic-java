package com.work.abstract_test;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/25          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName AbstractTest
 *@Description abstract关键字
 *@Author zhutao
 *@Date 2021/1/25 10:42
 *@Version 1.0
 **/
public class AbstractTest {
    /**
     * abstract关键字:表示抽象的,可以用来修饰-->类,方法
     * 随着子类的增加,类变的越来越具体,子类中的方法又一定比父类丰富,所以在具体使用的时候都可以定位到某一个子类
     * 于是,我们可以将父类设置成不能实例化的abstract类.
     * 抽象类:被abstract修饰的类
     * 1.抽象类中可以有抽象方法,也可以没有
     * 2.抽象类不能被实例化,但是抽象类中一定会有构造器,这里的构造器是让子类实例化时调用的
     * 3.开发中都会提供抽象类的子类,让子类对象实例化完成调用
     *
     * 抽象方法:被abstract修饰的方法
     * 1.抽象方法一定在抽象类中,且只是方法的声明,是没有方法体的.注:没有大括号
     * 2.子类必须重写父类中的所有抽象方法,若不重写,则子类也必须是抽象类
     *
     * 抽象类的匿名子类对象:
     *      匿名:没有确切的子类类名:如Student
     *      子类:不明确指定子类的类名,用父类类名代替,通过子类方法重写,实现父类中需要被重写的方法的具体逻辑
     *      对象:有具体对象名称
     */
    public static void main(String[] args) {
//        new Person(); 抽象类无法被实例化
        Person boy = new Boy();
        boy.eat();
        System.out.println("------------------------------------------------");

        //非匿名类的非匿名对象
        Student student = new Student();
        method(student);
        //匿名对象的使用
        method(new Boy());

        System.out.println("------------------------------------------------");
        //匿名子类对象-->匿名类非匿名对象
        Person p =new Person() {
            @Override
            public void eat() {
                System.out.println("匿名子类对象...吃.....");
            }
            @Override
            public void run() {
                System.out.println("匿名子类对象...跑.....");
            }
            //非抽象方法可以不用重写
        };
        method(p);

        System.out.println("------------------------------------------------");
        method(new Person() {
            @Override
            public void eat() {
                System.out.println("简化版-->匿名子类对象...吃.....");
            }
            @Override
            public void run() {
                System.out.println("简化版--->匿名子类对象...跑.....");
            }
        });
    }

    public static void method(Person person){
        person.eat();
        person.run();
    }
}

abstract class Person {

    //抽象类是有构造器的,这里的构造器是留给子类创建对象是调用的
    public Person(){
    }
    public void look(){
        System.out.println("看.......");
    }
    abstract public void eat();
    abstract public void run();
}

class Boy extends Person{

    public Boy(){
        //调用父类的构造器,-->默认省略
        super();
    }

    @Override
    public void eat(){
        System.out.println("男孩吃饭.....");
    }

    @Override
    public void run(){
        System.out.println("男孩跑步.....");
    }
}

class Student extends Boy{

}
