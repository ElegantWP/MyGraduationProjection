package com.myweb.app.VO;

import java.util.Date;

/**
 * @author weipan
 * @date 2019/4/3 16:27
 */
public class AdminOrderVO {

  private String orderId;
  private String nickName;
  private Integer orderNum;
  private Date createTime;
  private Integer orderPatten;
  private Integer orderStatus;
  private Double cutMoney;
  private Double sumMoney;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Integer getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(Integer orderNum) {
    this.orderNum = orderNum;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getOrderPatten() {
    return orderPatten;
  }

  public void setOrderPatten(Integer orderPatten) {
    this.orderPatten = orderPatten;
  }

  public Integer getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Integer orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Double getCutMoney() {
    return cutMoney;
  }

  public void setCutMoney(Double cutMoney) {
    this.cutMoney = cutMoney;
  }

  public Double getSumMoney() {
    return sumMoney;
  }

  public void setSumMoney(Double sumMoney) {
    this.sumMoney = sumMoney;
  }

  @Override
  public String toString() {
    return "AdminOrderVO{" +
        "orderId='" + orderId + '\'' +
        ", nickName='" + nickName + '\'' +
        ", orderNum=" + orderNum +
        ", createTime=" + createTime +
        ", orderPatten=" + orderPatten +
        ", orderStatus=" + orderStatus +
        ", cutMoney=" + cutMoney +
        ", sumMoney=" + sumMoney +
        '}';
  }
}
