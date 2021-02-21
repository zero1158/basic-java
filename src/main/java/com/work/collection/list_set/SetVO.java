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

import java.util.Objects;

/**
 *@ClassName SetVO
 *@Description TODO
 *@Author zhutao
 *@Date 2021/2/9 16:13
 *@Version 1.0
 **/
@Data
public class SetVO implements Comparable<SetVO>{
    private String name;
    private Integer age;

    public SetVO() {
    }

    public SetVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals()方法被调用了.........");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetVO setVO = (SetVO) o;
        return Objects.equals(name, setVO.name) &&
                Objects.equals(age, setVO.age);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode()方法被调用了--------");
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(SetVO o) {
        //指定根据age大小顺序排列
        return Integer.compare(this.age,o.age);
    }
}
