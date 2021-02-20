package com.work.reflection;
/**
 * Licensed to CMSR,Inc. under the terms of the CMSR
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date               Author               Version              Comments
 * 2021/2/19          zhutao                 1.0            Initial Version
 **/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *@ClassName ReflectionPropertiesTest
 *@Description 加载配置文件
 *@Author zhutao
 *@Date 2021/2/19 20:04
 *@Version 1.0
 **/
public class ReflectionPropertiesTest {
    public static void main(String[] args) {
        //1.创建存放配置文件信息的类:Properties,就是Map接口下的HashTable接口下的集合类:
        //class Properties extends Hashtable<Object,Object>
        Properties properties = new Properties();
        //2.1 方式一:创建一个输入流,读取配置文件中的内容,再通过Properties中的load()方法获取数据
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("src\\main\\resources\\application.properties");
            //3.通过load(InputStream) 获取配置文件中的了内容
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String name = properties.getProperty("name");
        System.out.println("方式一: "+name);

        //2.2 方式二:通过ClassLoader
//        ClassLoader classLoader = ReflectionPropertiesTest.class.getClassLoader();
//        InputStream resourceAsStream = classLoader.getResourceAsStream("application.properties");
//        try {
//            properties.load(resourceAsStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String age = properties.getProperty("age");
//        System.out.println("方式二:通过ClassLoader---> : " +age);
    }
}
