package com.funliving.info.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weizhigang on 16/9/2.
 */
public class DateHelper {
    public static Date parse(String source,String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
    public static Date parse(String source){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

}
