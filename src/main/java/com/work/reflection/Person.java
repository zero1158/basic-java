package com.work.reflection;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/19          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName Person
 *@Description TODO
 *@Author zhutao
 *@Date 2021/2/19 19:54
 *@Version 1.0
 **/
public class Person {
    private String name;
    private Integer age = 11;

    public String id = "0";
    Integer max;

    private static String SEX = "MAN";

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

//    public static String getSEX() {
//        return SEX;
//    }
//
//    public static void setSEX(String SEX) {
//        Person.SEX = SEX;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", max=" + max +
                '}';
    }

    public void show01(){
        System.out.println("这是一个public方法");
    }

    public void show02(String name,Integer age){
        System.out.println("这是一个带参数的-->public方法");
        System.out.println("name : "+name+" ; age: "+age);
    }

    private void read01(){
        System.out.println("这是一个私有化方法");
    }
    private String read02(String id,Integer max){
        System.out.println("这是一个私有化方法");
        return id;
    }

    private static String run(String name){
        System.out.println("name : " +name +" ;这是一个私有化的静态方法");
        return name;
    }
}
