package com.work.base_use.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class jdk8Test {
    public static void main(String[] args) {
        //获取一个当前日期+时间的对象-->常用
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //获取一个当前时间对象
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //获取一个当前日期对象
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //创建一个指定时间的对象
        LocalDateTime of = LocalDateTime.of(2020,10,15,20,19,19);
        System.out.println(of);

        System.out.println("==============================================");

        //getXxx()
        Month month = localDateTime.getMonth();
        System.out.println(month);
        //获取月份-->数字
        int monthValue = localDateTime.getMonthValue();
        System.out.println(monthValue);

        //setXxx()
        LocalDateTime localDateTime1 = localDateTime.withMonth(3);
        System.out.println(localDateTime1);

        //plusXxx()
        LocalDateTime localDateTime2 = localDateTime.plusMonths(5);
        System.out.println(localDateTime2);

        //minusXxx()
        LocalDateTime localDateTime3 = localDateTime.minusMonths(1);
        System.out.println(localDateTime3);
    }
}
