package com.myweb.app.VO;

import com.myweb.app.DTO.CartListDTO;
import java.util.Date;
import java.util.List;

/**
 * Created by weipan on 2019/3/3 21:11
 */
public class OrderVO {

  private String cathNumber;
  private List<CartListDTO> cartList;
  private Date time;
  private String orderId;
  private Double sumMoney;

  public String getCathNumber() {
    return cathNumber;
  }

  public void setCathNumber(String cathNumber) {
    this.cathNumber = cathNumber;
  }

  public List<CartListDTO> getCartList() {
    return cartList;
  }

  public void setCartList(List<CartListDTO> cartList) {
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

  public Double getSumMoney() {
    return sumMoney;
  }

  public void setSumMoney(Double sumMoney) {
    this.sumMoney = sumMoney;
  }

  @Override
  public String toString() {
    return "OrderVO{" +
        "cathNumber='" + cathNumber + '\'' +
        ", cartList=" + cartList +
        ", time=" + time +
        ", orderId='" + orderId + '\'' +
        ", sumMoney=" + sumMoney +
        '}';
  }
}
