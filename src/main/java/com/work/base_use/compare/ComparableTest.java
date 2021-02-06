package com.work.base_use.compare;

import java.util.*;


/**
 * Comparable接口 : 自然排序
 */
public class ComparableTest {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("小米","16","gggg"));
        list.add(new Student("小红","13","bbbb"));
        list.add(new Student("小刚","26","cccc"));
        list.add(new Student("小华","16","dddd"));

        Collections.sort(list);
        for (Student student:list) {
            System.out.println(student.toString());
        }
    }
}

