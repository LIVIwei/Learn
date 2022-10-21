package org.example.CountDays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: LIVI
 * @Time: 2022/09/29  17:59
 * @Description: java实现时间相减得到天数
 */
public class ToDate {
    public static void main(String[] args) {
        String beginDateStr = "2009-09-01";
        String endDateStr = "2019-09-01";
        getDaySub(beginDateStr, endDateStr);
    }

    public static long getDaySub(String beginDateStr,String endDateStr) {

        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate;
        Date endDate;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("day:"+day);

        return day;
    }

}
