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
 *@ClassName Test02
 *@Description 多态
 *@Author zhutao
 *@Date 2021/1/20 19:26
 *@Version 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        Animals cat = new Cat();
        if (cat instanceof Cat){
            Cat c = (Cat)cat;
            c.catchMouse();
        }else if(cat instanceof Dog){
            Dog d = (Dog)cat;
            d.kanmen();
        }
    }
}
