package com.myweb.app.VO;

/**
 * @author weipan
 * @date 2019/4/15 18:57
 */
public class AdminChartOrderNumVO {

  private String days;
  private String orderCurrentNum;

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public String getOrderCurrentNum() {
    return orderCurrentNum;
  }

  public void setOrderCurrentNum(String orderCurrentNum) {
    this.orderCurrentNum = orderCurrentNum;
  }

  @Override
  public String toString() {
    return "AdminChartOrderNumVO{" +
        "days='" + days + '\'' +
        ", orderCurrentNum='" + orderCurrentNum + '\'' +
        '}';
  }
}
