package com.myweb.app.bean;

import java.util.Date;

/**
 * Created by weipan on 2019/2/26 11:08
 */
public class Order {

  private Integer id;
  private String openId;
  private Double sumMoney;
  private Integer cupNumber;
  private String cartList;
  private Date time;
  private String orderId;
  private String cathNumber;
  private Integer model;
  private String appointTime;
  private Integer status;
  private Date disTime;
  private Double cutMoney;
  private String packages;
  private String cutText;
  private String note;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public Double getSumMoney() {
    return sumMoney;
  }

  public void setSumMoney(Double sumMoney) {
    this.sumMoney = sumMoney;
  }

  public Integer getCupNumber() {
    return cupNumber;
  }

  public void setCupNumber(Integer cupNumber) {
    this.cupNumber = cupNumber;
  }

  public String getCartList() {
    return cartList;
  }

  public void setCartList(String cartList) {
    this.cartList = cartList;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getCathNumber() {
    return cathNumber;
  }

  public void setCathNumber(String cathNumber) {
    this.cathNumber = cathNumber;
  }

  public Integer getModel() {
    return model;
  }

  public void setModel(Integer model) {
    this.model = model;
  }

  public String getAppointTime() {
    return appointTime;
  }

  public void setAppointTime(String appointTime) {
    this.appointTime = appointTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getDisTime() {
    return disTime;
  }

  public void setDisTime(Date disTime) {
    this.disTime = disTime;
  }

  public Double getCutMoney() {
    return cutMoney;
  }

  public void setCutMoney(Double cutMoney) {
    this.cutMoney = cutMoney;
  }

  public String getPackages() {
    return packages;
  }

  public void setPackages(String packages) {
    this.packages = packages;
  }

  public String getCutText() {
    return cutText;
  }

  public void setCutText(String cutText) {
    this.cutText = cutText;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", openId='" + openId + '\'' +
        ", sumMoney=" + sumMoney +
        ", cupNumber=" + cupNumber +
        ", cartList='" + cartList + '\'' +
        ", time=" + time +
        ", orderId='" + orderId + '\'' +
        ", cathNumber='" + cathNumber + '\'' +
        ", model=" + model +
        ", appointTime='" + appointTime + '\'' +
        ", status=" + status +
        ", disTime=" + disTime +
        ", cutMoney=" + cutMoney +
        ", packages='" + packages + '\'' +
        ", cutText='" + cutText + '\'' +
        ", note='" + note + '\'' +
        '}';
  }
}
