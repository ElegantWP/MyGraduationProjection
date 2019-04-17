package com.myweb.app.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weipan on 2019/3/2 18:58
 */
public class TimeUtil {

  public static String getStartTimeOfTheDay(){
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd 00:00:00");
    String startTime = simpleDateFormat.format(date);
    return startTime;
  }
  public static String getEndTimeOfTheDay(){
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd 23:59:59");
    String endTime = simpleDateFormat.format(date);
    return endTime;
  }

  public static Date getDateTimeByString(String date) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return simpleDateFormat.parse(date);
  }

  public static String getDateTimeByDate(Date date) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return simpleDateFormat.format(date);
  }

}
