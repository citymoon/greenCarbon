package com.dhb.platform.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    //取当前的年份
    public static String getNowYear()
    {
        Date objDate = new Date();
        SimpleDateFormat objFormat = new SimpleDateFormat("yyyy");
        String strDate = objFormat.format(objDate);
        return strDate;
    }
    
    //取当前的月份
    public static String getNowMonth()
    {
        Date objDate = new Date();
        SimpleDateFormat objFormat = new SimpleDateFormat("MM");
        String strDate = objFormat.format(objDate);
        return strDate;
    }
    

    //得到当前系统日期,并返回"yyyy-MM-dd"格式的字符串
   public static String getNowDate()
   {
       Date objDate = new Date();//调用date()的默认构造函数,取得当前日期;
       SimpleDateFormat objSDateFormat= new SimpleDateFormat("yyyy-MM-dd");
       String strConstructDate = objSDateFormat.format(objDate);
       return strConstructDate;//返回yyyy-MM-dd格式的当前日期;
   }

   //得到当前系统时间,返回hh:dd的字符串
   public static String getNowTime()
    {
        String strTime;
        Date objDate=new Date();
        SimpleDateFormat objFormat=new SimpleDateFormat("HH:mm");
        strTime=objFormat.format (objDate);
        return strTime;

    }

   
}
