package com.myweb.app.utils;

import java.util.Random;

/**
 * Created by weipan on 2019/2/24 9:47
 */
public class WxPayOrdrIDUtil {


  public static Integer getMachineId(){
    Random random = new Random();
    Integer machineid = random.nextInt(10);
    return machineid;
  }
  //machineid 集群时的激起代码 为1-9的随机的数字
  public static String getWxPayOrderID(String machineId){
    String orderId =
        machineId +
            (System.currentTimeMillis() + "").substring(1) +
            (System.nanoTime() + "").substring(7, 10);
    return orderId;
  }

}
