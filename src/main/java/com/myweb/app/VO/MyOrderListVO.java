package com.myweb.app.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myweb.app.DTO.CartListDTO;
import java.util.Date;
import java.util.List;

/**
 * Created by weipan on 2019/3/5 10:37
 */
public class MyOrderListVO {

  private String orderId;
  private Double sumMoney;
  private String appointTime;
  @JSONField (format="yyyy-MM-dd HH:mm:ss")
  private Date time;
  private Integer cupNumber;
  @JSONField(name = "cartList")
  private List<CartListDTO> cartListDTOS;
  //序列化时忽略此字段
  @JsonIgnore
  private String cartList;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Double getSumMoney() {
    return sumMoney;
  }

  public void setSumMoney(Double sumMoney) {
    this.sumMoney = sumMoney;
  }

  public String getAppointTime() {
    return appointTime;
  }

  public void setAppointTime(String appointTime) {
    this.appointTime = appointTime;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Integer getCupNumber() {
    return cupNumber;
  }

  public void setCupNumber(Integer cupNumber) {
    this.cupNumber = cupNumber;
  }

  public List<CartListDTO> getCartListDTOS() {
    return cartListDTOS;
  }

  public void setCartListDTOS(List<CartListDTO> cartListDTOS) {
    this.cartListDTOS = cartListDTOS;
  }

  public String getCartList() {
    return cartList;
  }

  public void setCartList(String cartList) {
    this.cartList = cartList;
  }

  @Override
  public String toString() {
    return "MyOrderListVO{" +
        "orderId='" + orderId + '\'' +
        ", sumMoney=" + sumMoney +
        ", appointTime='" + appointTime + '\'' +
        ", time=" + time +
        ", cupNumber=" + cupNumber +
        ", cartListDTOS=" + cartListDTOS +
        ", cartList='" + cartList + '\'' +
        '}';
  }
}
