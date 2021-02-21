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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@ClassName TcpSocketTest01
 *@Description 使用socket举例
 *@Author zhutao
 *@Date 2021/2/18 19:16
 *@Version 1.0
 **/
public class TcpSocketTest01 {

    /**socket发送端
     * 1.创建socket对象,指明服务端ip,端口号
     * 2.获取一个输出流,用于输出数据
     * 3.写出数据
     * 4.关闭流
     * 注意 : 必须先开启服务端(接收端),在开启发送端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream stream = null;
        try {
            //1.创建socket对象
            socket = new Socket("127.0.0.1",8888);
            //2.获取socket中的输出流
            stream = socket.getOutputStream();
            //3.要输出的数据
            stream.write("我爱Java!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流和socekt
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
    public void server() throws IOException {
        //
        ServerSocket ss = new ServerSocket(8888);
        //表示可以用来接收来自客户端的socket
        Socket socket = ss.accept();
        InputStream stream = socket.getInputStream();
        //方式一 : 不建议这么写,容易出现乱码->byte数组不一定能拿全一个汉字的ac码,导致乱码
//        byte[] bytes = new byte[1024];
//        int read;
//        while ((read = stream.read(bytes)) != -1){
//            String str = new String(bytes, 0, read);
//            System.out.println(str);
//        }
        //方式二:
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //将byte数组设置的较小也可以
        byte[] bytes = new byte[5];
        int read;
        while ((read = stream.read(bytes)) != -1){
            outputStream.write(bytes,0,read);
        }
        //实际上就是将stream中的数据全部写到outputStream中的指定区域之后,在进行拼接读取出来
        System.out.println(outputStream.toString());

        stream.close();
        outputStream.close();
        socket.close();
        ss.close();
    }

}
