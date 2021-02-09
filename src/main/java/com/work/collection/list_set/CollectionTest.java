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
import java.util.Collection;

/**
 *@ClassName CollectionTest
 *@Description Collection接口中的方法
 *@Author zhutao
 *@Date 2021/2/9 10:55
 *@Version 1.0
 **/

/**
 * 1.contains(Object obj)
 * 2.remove(Object obj) : 注意区分remove(index)
 * 3.retainAll(List<T>) :求两个集合交际,并返回给当前集合
 * 4.list.toArray()和Arrays.tiList()
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection list = new ArrayList<>();
        list.add("123");
        list.add(123);
        list.add("happy");
        list.add(new CollectionVO("Tom",18));
        list.add(new CollectionVO("json",7));
        /**1.1
         * 这里用的其实是String中重写的equals()方法 --->返回true
         */
        System.out.println(list.contains("happy"));
        /**1.2:
         * ArrayList实现contains()方法底层实际还是调用的事indexof()方法,在indexOf中循环并用equals()方法
         * 判断对象是否已经存在,若存在则返回循环次数(i,即对象角标),若不存在则返回-1.
         * 我们可以重写对象类中的equals()方法,来实现我们自己的判断逻辑
         * 如: 只要名字相同则认为对象存在
         * 重写前 : System.out.println(list.contains(new CollectionVO("json",12)))-->false
         *         System.out.println(list.contains(new CollectionVO("json",7)));//true
         */
        //重写CollectionVO-->结果为true
        System.out.println(list.contains(new CollectionVO("json",12)));

        /**2.1
         * 底层还是调用所属类的equals()方法先比较是否存在,并获取要删除的元素角标
         * 然后调用System.arraycopy()方法------>
         */
        System.out.println(list.remove(new CollectionVO("Tom1",18) ));
        System.out.println(list.remove("222"));


    }
}
