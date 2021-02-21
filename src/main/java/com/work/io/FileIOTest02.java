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

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *@ClassName FileIOTest02
 *@Description IO流  :  字符流的读写操作
 *@Author zhutao
 *@Date 2021/2/18 10:47
 *@Version 1.0
 **/
public class FileIOTest02 {
    public static void main(String[] args) {
        //字符流 读取操作
//        reader();
        //字符流 写出操作
//        writer();

        //复制操作
        fileIoTest();
    }

    //字符流 : 读 ->字符流不能用来读取图片,视频等文件
    public static void reader(){
        FileReader reader = null;
        try {
            reader = new FileReader("src\\main\\java\\com\\work\\io\\hello.txt");
            //作为reader的参数,指定每次读取的个数,当不存在时,每次只读取一个字符
            char[] chars = new char[5];
            //无参的时候每次只读取一个字符
            int read;
            while ((read=reader.read(chars)) != -1){
                System.out.println("读取字符个数 : "+read);
                String str = new String(chars, 0, read);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    //关闭流
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字符流  : 写入
    public static void writer(){
        FileWriter writer = null;
        try {
            //设置true ,在原文件中添加
            writer = new FileWriter("src\\main\\java\\com\\work\\io\\hello.txt",true);
            writer.write("\nI have a dream !\n");
            writer.write("小华是个好学生");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    //关闭流
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //实现文本类文件的复制
    public static void fileIoTest(){
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("src\\main\\java\\com\\work\\io\\hello.txt");
            writer = new FileWriter("src\\main\\java\\com\\work\\io\\hello1.txt");
            char[] chars = new char[5];
            int read;
            while ((read=reader.read(chars)) != -1){
                //每次写出读入的字符
                writer.write(chars,0,read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
