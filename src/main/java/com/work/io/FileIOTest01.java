package com.work.io;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/18          zhutao                 1.0            Initial Version
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *@ClassName IOFileTest
 *@Description IO流  :  字节流的读写操作
 *@Author zhutao
 *@Date 2021/2/18 9:47
 *@Version 1.0
 **/
public class FileIOTest01 {
    /**步骤:
     * 1.实例化文件对象
     * 2.创建流对象
     * 3.执行操作
     * 4.关闭流
     */
    public static void main(String[] args) {
        //字节流 ->读
//        inputStreamTest();
        //字节流 ->写
//        outputStreamTest();

        //复制
        ioFileTest();
    }

    //字节流-> 读:字节流不适用于读取文件类(如:txt),一般用来处理图片视频等
    public static void inputStreamTest(){
        FileInputStream stream = null;
        try {
            //1.实例化File(文件)对象
            File file = new File("src\\main\\java\\com\\work\\io\\hello.txt");
            //2.提供具体的流对象
            stream = new FileInputStream(file);
            //3.读
            byte[] bytes = new byte[5];
            //每次返回读入bytes中的个数,若已经到达文件末尾,则返回-1
            int read ;
            while ((read=stream.read(bytes)) != -1){
                System.out.println("------->: "+read);
                for (byte b:bytes){
                    System.out.print((char) b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null){
                try {
                    //4.关闭流
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字节流->写 : 用来向文件中写入数据,也可以用来复制文件,图片,视频等
    public static void outputStreamTest(){
        FileOutputStream stream = null;
        try {
            //1.实例化文件
            File file = new File("src\\main\\java\\com\\work\\io\\hello.txt");
            //2.创建流对象 -->false:覆盖原有文件中的内容 ; true:在原有文件中添加
            stream = new FileOutputStream(file,true);
            //3.写 -->向hello.txt中添加字母,bytes中为要写入的数据,用AC码表示
            byte[] bytes = new byte[]{97,98,99};
            stream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null){
                try {
                    //4.关闭流
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //复制文件
    public static void ioFileTest(){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            //1.实例化File(文件)对象
            File inFile = new File("src\\main\\java\\com\\work\\io\\iotest.jpg");
            //复制的文件
            File outFile = new File("src\\main\\java\\com\\work\\io\\testFileIO.jpg");
            //2.提供具体的流对象
            inputStream = new FileInputStream(inFile);
            outputStream = new FileOutputStream(outFile);
            //每次读写的长度
            byte[] bytes = new byte[1024];
            int lenth;
            //读和写  --> 复制的效果
            while ((lenth=inputStream.read(bytes)) != -1){
                //仅仅写出读入的字节
                outputStream.write(bytes,0,lenth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    //4.关闭输入流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream!= null){
                try {
                    //4.关闭输出流
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

