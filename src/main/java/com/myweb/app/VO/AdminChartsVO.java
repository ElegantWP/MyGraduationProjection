package com.myweb.app.VO;

import java.util.Date;

/**
 * @author weipan
 * @date 2019/4/15 16:04
 */
public class AdminChartsVO {

  private String days;
  private double orderCurrentMoney;

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public double getOrderCurrentMoney() {
    return orderCurrentMoney;
  }

  public void setOrderCurrentMoney(double orderCurrentMoney) {
    this.orderCurrentMoney = orderCurrentMoney;
  }

  @Override
  public String toString() {
    return "AdminChartsVO{" +
        "days='" + days + '\'' +
        ", orderCurrentMoney=" + orderCurrentMoney +
        '}';
  }
}
