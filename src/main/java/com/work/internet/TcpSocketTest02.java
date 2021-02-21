package com.work.internet;
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

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@ClassName TcpSocketTest02
 *@Description socket之 文件接收
 *@Author zhutao
 *@Date 2021/2/18 19:54
 *@Version 1.0
 **/
public class TcpSocketTest02 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream stream = null;
        FileInputStream inputStream = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            stream = socket.getOutputStream();
            //创建输入流读取文件
            inputStream = new FileInputStream("src\\main\\java\\com\\work\\internet\\test.jpg");
            byte[] bytes = new byte[1024];
            int lenth;
            while ((lenth = inputStream.read(bytes)) != -1){
                //将读取到的文件发送出去
                stream.write(bytes,0,lenth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流和socket
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream stream = null;
        try {
            serverSocket = new ServerSocket(9999);
            socket = serverSocket.accept();
            stream = socket.getInputStream();
            FileOutputStream outputStream = new FileOutputStream("src\\main\\java\\com\\work\\internet\\test01.jpg");
            byte[] bytes = new byte[10];
            int read;
            while ((read = stream.read(bytes)) != -1){
                outputStream.write(bytes,0,read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
