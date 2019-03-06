package com.myweb.app.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.myweb.app.DTO.CartListDTO;
import java.util.Date;
import java.util.List;

/**
 * Created by weipan on 2019/3/4 8:41
 */
public class MyOrderDetailVO {

  private List<CartListDTO> cartList;
  private Double sumMoney;
  @JSONField(name = "cutMonney")
  private Double cutMoney;
  private Integer cupNumber;
  private String orderId;
  private String cathNumber;
  @JSONField (format="yyyy-MM-dd HH:mm:ss")
  private Date time;
  private Integer model;
  private String appointTime;
  private Integer status;

  public List<CartListDTO> getCartList() {
    return cartList;
  }

  public void setCartList(List<CartListDTO> cartList) {
    this.cartList = cartList;
  }

  public Double getSumMoney() {
    return sumMoney;
  }

  public void setSumMoney(Double sumMoney) {
    this.sumMoney = sumMoney;
  }

  public Double getCutMoney() {
    return cutMoney;
  }

  public void setCutMoney(Double cutMoney) {
    this.cutMoney = cutMoney;
  }

  public Integer getCupNumber() {
    return cupNumber;
  }

  public void setCupNumber(Integer cupNumber) {
    this.cupNumber = cupNumber;
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

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
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

  @Override
  public String toString() {
    return "MyOrderDetailVO{" +
        "cartList=" + cartList +
        ", sumMoney=" + sumMoney +
        ", cutMoney=" + cutMoney +
        ", cupNumber=" + cupNumber +
        ", orderId='" + orderId + '\'' +
        ", cathNumber='" + cathNumber + '\'' +
        ", time=" + time +
        ", model=" + model +
        ", appointTime='" + appointTime + '\'' +
        ", status=" + status +
        '}';
  }
}
