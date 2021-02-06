package com.work.base_use.time;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        //1.实例化
        //Calendar是一个抽象类,只能new其子类对象,这里通过getInstance()获取的其实也是其子类对象,只是用Calendar接受了-->多态
        //这里的calendar就是当前时间对象
        Calendar calendar = Calendar.getInstance();

        //2.get()
        //Calendar获取的月份从0开始-->都比实际月份少1
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(day);

        //set()->将指定位置的参数改为我们想要的值
        calendar.set(Calendar.DAY_OF_YEAR,1);
        //getTime()
        Date time = calendar.getTime();
        System.out.println(time);

        //setTime()
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
    }
}
