package com.work.this_and_static;

/**
 *@ClassName Student
 *@Description 学习this关键字
 *@Author zhutao
 *@Date 2021/1/20 10:54
 *@Version 1.0
 **/

import lombok.Data;

/**
 * this关键字:1.意为这个
 *           2.是一个引用,也是一个变量,this变量中存放了引用的对象本身的内存地址,this储存在jvm堆内存Java对象内部
 *           3.每个对象都自己的this
 *           4.this可以出现在实例方法中,但是不能出现在静态方法中,因为静态方法是通过"类名."的方式调用,没有对象或者
 *           对象的引用,this出现在实例方法中时,指向正在执行的这个动作的对象
 *           5.this在多数情况下可以不写
 *           6.this不能用在static修饰的方法中
 *           7.用来区分局部变量和实例变量的时候this不能省略
 *           8.this可以使用在构造方法中,通过当前的构造方法调用其他的构造方法,且只能出现在构造方法第一行(只能使用一次)
 */
@Data
public class Student {

    /**
     *  带有static关键字的方法/变量被称为静态方法/变量,可以通过"类名."的方式去访问
     *  不带有stiatic的方法/变量为实例变量,必须要通过"引用."的方式去访问
     *  注意:当一个方法的执行过程中是需要对象参与的,那么这个对象一定定义为实例方法
     */
    private String name;
    private String age;
    //得分
    private Integer score;

    private static String SCHOOL_NAME = "xx小学";

    /** 一下程序中name和实例变量name无关,不能采用这种方式
     *     public void setName(String name) {
     *         name = name;
     *     }
     */
    public void setName(String name) {
        //等号左边的是实例变量name,等号右边的是局部变量name
        this.name = name;
    }

    /**
     * 需求:调用无参构造器时,创建默认对象
     * 采用以下方法完成构造方法的调用,这种方式不会创建新的对象,但同时又可以达到调用其他的构造方法
     */
    public Student() {
        this("小华","18",88);
    }

    public Student(String name, String age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    /**
     * 该方法为实例方法在调用的时候必然是"引用."的方式,这时方法中的this就是调用该方法的引用
     * 所以这里可以使用this.name的方式获取参数
     */
    public void study(){
        //实例变量name必须使用"引用."的方式去访问,这里的this可以省略
        System.out.println(SCHOOL_NAME+"的学生--->"+this.name +"正在学习!");
    }

    public static void eat(){
        /**
         * 该方法在执行过程中没有当前对象,因为static的方法时通过"类名."的方式访问的
         * 自然也就没有this(this代表当前正在执行这个动作的对象)
         * System.out.println(this.name+"吃饭............")会导致编译失败-->因this.name的含义是:
         * 访问当前对象的name,而eat()是用类名调用的,没有当前对象,自然也不能访问当前对象的name
         */
        System.out.println("吃饭............");
    }
}
