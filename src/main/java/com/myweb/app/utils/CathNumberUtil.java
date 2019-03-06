package com.myweb.app.utils;

/**
 * Created by weipan on 2019/2/28 11:07 h
 */
public class CathNumberUtil {

  public static String getCathNumber(int todaySum){
    todaySum++;
    //生成取餐号码的前缀   之后进行判断
    String cathNumber = null;
    if(todaySum<=9){
      cathNumber = "NWU00" + todaySum;
    }
    if(todaySum<=99&&todaySum>9){
      cathNumber = "NWU0" + todaySum;
    }
    if(todaySum<=999&&todaySum>99){
      cathNumber = "NWU" + todaySum;
    }
    if(todaySum>999){
      cathNumber = "NWU" + todaySum;
    }

    return cathNumber;
  }

}
