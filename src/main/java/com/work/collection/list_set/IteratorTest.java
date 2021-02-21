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
import java.util.Iterator;
import java.util.List;

/**
 *@ClassName IteratorTest
 *@Description TODO
 *@Author zhutao
 *@Date 2021/2/9 13:22
 *@Version 1.0
 **/
public class IteratorTest {
    /**
     * Iterator迭代器:
     * 一个迭代器在被创建后只能使用在一个循环中,且集合对象每次调用iterator()都能获得一个全新的迭代器,游标默认在第一个
     * 当迭代器执行hasNext()方法时,游标不会动,
     * 当迭代器执行next()时游标(指针)首先下移一位,然后返回下移以后的指向的集合元素-->先移动到指定位置,在返回该位置的元素
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("123");
        list.add(123);
        list.add("呵呵呵");
        list.add(new CollectionVO("小明",11));

        //1.首先获取指定集合的迭代器
        Iterator<Object> iterator = list.iterator();
        //2.迭代器中的重要方法: hasNext(),next(),remove()
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------------------------------");
        /**
         * 错误的使用
         */
        Iterator<Object> iterator1 = list.iterator();
        while (iterator1.next() != null)
            System.out.println(iterator1.next());
    }
}
