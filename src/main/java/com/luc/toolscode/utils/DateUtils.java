package com.luc.toolscode.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtils extends DateUtil{


    /**
     * 获取时间刻度
     * @param beginTime
     * @param endTime
     * @return
     */
    public static List<String> getMonthTimescale(Date beginTime, Date endTime){
        SimpleDateFormat format = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
        List<DateTime> dateTimes = rangeToList(beginTime, endTime, DateField.DAY_OF_MONTH);
        return dateTimes.stream().map(format::format).collect(Collectors.toList());
    }


    /**
     * 获取时间刻度
     * @param beginTime
     * @param endTime
     * @return
     */
    public static List<String> getMonthTimescale(Date beginTime, Date endTime,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(DatePattern.NORM_DATE_PATTERN);
        Calendar calendar = Calendar.getInstance();

        List<String> result = new ArrayList<>();
        while (beginTime.getTime() <= endTime.getTime()){
            result.add(format.format(beginTime));

            calendar.setTime(beginTime);
            calendar.add(Calendar.MONTH,1);
            beginTime = calendar.getTime();
        }
        return result;
    }


    public static String format(Date date,String format){
       return new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN).format(date);
    }


    public static Date addDay(Date date,Integer p){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,p);
        return calendar.getTime();
    }


}
