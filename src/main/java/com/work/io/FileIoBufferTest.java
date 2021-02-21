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

import java.io.*;

/**
 *@ClassName FileIoBufferTest
 *@Description 缓冲流 : 一种处理流,因为使用了缓冲区,所以更快
 *@Author zhutao
 *@Date 2021/2/18 11:20
 *@Version 1.0
 **/
public class FileIoBufferTest {
    /**步骤 :
     * 1.先创建对应的输入/输出流对象
     * 2.在创建对应的缓冲流对象
     * 3.执行操作
     * 4.关闭流 : 要求先关闭外层流,再关闭内层流,关闭外层流时,内层流也会自动关闭
     */
    public static void main(String[] args) {
        //字节缓冲流 -> 复制
//        bufferStream();

        //字符缓冲流 -> 复制
        bufferChar();
    }

    //字节流的缓冲流
    public static void bufferStream(){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.创建字节输入/输出流对象
            FileInputStream inputStream = new FileInputStream("src\\main\\java\\com\\work\\io\\iotest.jpg");
            FileOutputStream outputStream = new FileOutputStream("src\\main\\java\\com\\work\\io\\iotestBuffer01.jpg");
            //2.创建对应的缓冲流对象
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            //3.复制操作
            byte[] bytes = new byte[1024];
            int lenth;
            while ((lenth = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,lenth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if (bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字符缓冲流
    public static void bufferChar(){
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            FileReader fileReader = new FileReader("src\\main\\java\\com\\work\\io\\hello.txt");
            FileWriter fileWriter = new FileWriter("src\\main\\java\\com\\work\\io\\helloBuffer.txt");

            reader = new BufferedReader(fileReader);
            writer = new BufferedWriter(fileWriter);
            //方式一:
//            char[] chars = new char[1024];
//            int lenth;
//            while ((lenth = reader.read(chars)) != -1){
//                writer.write(chars,0,lenth);
//                //清空缓存区:会自动执行
////                writer.flush();
//            }
            //方式二:整行读取
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                //换行操作
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
