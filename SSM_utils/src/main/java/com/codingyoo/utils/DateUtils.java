package com.codingyoo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换字符串
    public static String date2String(Date date, String patt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }

    //字符串转日期
    public static Date string2Date(Date date,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date dates = simpleDateFormat.parse(String.valueOf(date));
        return dates;
    }

}
