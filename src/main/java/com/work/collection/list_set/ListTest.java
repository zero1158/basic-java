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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *@ClassName ListTest
 *@Description 源码分析
 *@Author zhutao
 *@Date 2021/2/9 14:34
 *@Version 1.0
 **/
public class ListTest {
    public static void main(String[] args) {
        /**
         * 证明了List接口下的ArrayList和linkedList都是有序的,根据插入的顺序排列元素
         * 但是HashSet是无序的
         * LinkedHashMap也是有序的,根据插入的顺序排序
         * TreeMap也是有序的
         */
        List<Object> list = new ArrayList<>();
        list.add("123");
        list.add(456);
        list.add("789");
        list.add("小环");
        list.add("小明");
        list.add("小航");
        for (Object o :list){
            System.out.println(o);
        }

        System.out.println("=================================");

        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("123");
        linkedList.add("456");
        linkedList.add("789");
        linkedList.add("小华");
        linkedList.add("小红");
        for (Object o :linkedList){
            System.out.println(o);
        }

        HashSet<Object> set = new HashSet<>();
        set.add("第一个");
        set.add("第二个");
        set.add("第三个");
        for (Object o:set){
            System.out.println(o);
        }
    }
}
