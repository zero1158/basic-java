package com.work.base_use.compare;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator接口 : 定制排序
 *
 * Arrays.sort(arr,comparator);
 * Collections.sort(list,comparator);
 * new TreeSet(comparator);
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("小米","26","gggg"));
        list.add(new Student("小红","10","bbbb"));
        list.add(new Student("小刚","56","cccc"));
        list.add(new Student("小华","16","dddd"));

        Comparator<Student> comparator = (o1, o2) -> -o1.getMessage().compareTo(o2.getMessage());
        Comparator<Student> comparator1 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        };

        Collections.sort(list,comparator);
        for (Student student:list) {
            System.out.println(student.toString());
        }
    }
}
