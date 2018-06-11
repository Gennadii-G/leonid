package com.spacefox.frida.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatterJH {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat dtimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String dateOnlyFormat(Date date) throws ParseException {
        String sDate = dateFormat.format(new Date());
        return sDate;
    }

    public static String dateTimeFormat(Date date) {
        String sDate = dtimeFormat.format(new Date());
        return sDate;
    }
}
