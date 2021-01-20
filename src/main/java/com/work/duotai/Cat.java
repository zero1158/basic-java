package com.work.duotai;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/1/20          zhutao                 1.0            Initial Version
 **/

/**
 *@ClassName Cat
 *@Description TODO
 *@Author zhutao
 *@Date 2021/1/20 18:51
 *@Version 1.0
 **/
public class Cat extends Animals{

    @Override
    public void eat(){
        System.out.println("猫吃鱼......");
    }

    public void catchMouse(){
        System.out.println("猫抓老鼠........");
    }
}
