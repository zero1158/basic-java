package com.work.this_and_static;


/**
 *@ClassName test01
 *@Description this关键字
 *@Author zhutao
 *@Date 2021/1/20 11:25
 *@Version 1.0
 **/
public class Thistest01 {

    public static void main(String[] args) {
        //通过new关键字调用对象的自定义有参构造方法
        Student xiaoming = new Student("小明",null,null);
        xiaoming.study();

        //被static修饰的方法/变量直接用"类名."的方式调用
        Student.eat();

        Student xiaohua = new Student();
        System.out.println(xiaohua.toString());
        /**
         * 使用"引用."的方式可以调用static调用的方法,但是实际上还是使用"类名."的方式调用的
         * 使用引用的方式调用static方法,程序会出现警告
         * 这里可以执行成功,并且没有空指针异常
         */
        xiaohua = null;
        xiaohua.eat();
    }

}
