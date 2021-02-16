package com.work.io;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/16          zhutao                 1.0            Initial Version
 **/

import java.io.File;

/**
 *@ClassName FileTest01
 *@Description TODO
 *@Author zhutao
 *@Date 2021/2/16 11:23
 *@Version 1.0
 **/
public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("readme.txt");
        System.out.println(file);
    }

}
