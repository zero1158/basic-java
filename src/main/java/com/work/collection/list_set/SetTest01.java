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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *@ClassName SetTest01
 *@Description HashSet
 *@Author zhutao
 *@Date 2021/2/9 15:27
 *@Version 1.0
 **/
public class SetTest01 {
    /**
     * 验证 : set中数据的不可重复性
     */
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(new SetVO("json",15));
        set.add(new SetVO("tom",13));
        /**
         * 通过修改SetVO类的equals()与hashCode()方法
         * hashCode()方法被调用了--------
         * hashCode()方法被调用了--------
         * hashCode()方法被调用了--------
         * equals()方法被调用了.........
         */
        set.add(new SetVO("tom",13));
        System.out.println(set);
        System.out.println("=========================================");

        HashSet<Object> linkedhashset = new LinkedHashSet<>();
        linkedhashset.add("123");
        linkedhashset.add("456");
        linkedhashset.add("789");
        System.out.println(linkedhashset);
    }
}
