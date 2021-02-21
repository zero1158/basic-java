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

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 *@ClassName CollectionVO
 *@Description TODO
 *@Author zhutao
 *@Date 2021/2/9 11:22
 *@Version 1.0
 **/
@Data
@Slf4j
public class CollectionVO {
    private String name;
    private Integer age;

    public CollectionVO() {
    }

    public CollectionVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        log.info("重写equals()方法 -->名字相同即为存在-------");
        //判断内存地址
        if (this == o) return true;
        //判断类文件
        if (o == null || getClass() != o.getClass()) return false;
        //强转
        CollectionVO that = (CollectionVO) o;
        //自定义为只判断名字
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
