package com.work.collection.list_set;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/9          zhutao                 1.0            Initial Version
 **/

import java.util.Iterator;
import java.util.TreeSet;

/**
 *@ClassName TreeSetTest
 *@Description TODO
 *@Author zhutao
 *@Date 2021/2/9 16:29
 *@Version 1.0
 **/
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(123);
        treeSet.add(11);
        treeSet.add(55);
        Iterator<Object> iterator = treeSet.iterator();
        /**
         * 1.可以按照添加对象的指定属性进行排序 -->11,55,123
         * 2.向TreeSet中添加的数据,要求是相同类的对象
         * treeSet.add(new SetVO())--->报错
         * java.lang.ClassCastException: com.work.collection.list_set.SetVO cannot be cast to java.lang.Comparable
         */
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println("----------------------------------");
        treeSet.clear();
        /**
         * 使用TreeSet存自定义类,必须指定排序方式:自然排序,定制排序
         */
        treeSet.add(new SetVO("json",15));
        treeSet.add(new SetVO("happy",66));
        treeSet.add(new SetVO("tom",8));
        treeSet.add(new SetVO("jerry",23));
        System.out.println(treeSet);

        System.out.println("===================================");
        //定制排序 -- > 指定比较器(compare)
        TreeSet<SetVO> set = new TreeSet<>((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        set.add(new SetVO("json",15));
        set.add(new SetVO("happy",66));
        set.add(new SetVO("tom",8));
        set.add(new SetVO("jerry",23));
        System.out.println(set);
    }
}
