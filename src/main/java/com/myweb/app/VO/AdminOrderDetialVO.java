package com.myweb.app.VO;

import com.myweb.app.DTO.CartListDTO;
import java.util.List;

/**
 * @author weipan
 * @date 2019/4/13 15:02
 */
public class AdminOrderDetialVO {

  private String model;
  private String appointTime;
  private List<CartListDTO> carts;
  private String note;
  private Double sumMoney;
  private String cathNumber;

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getAppointTime() {
    return appointTime;
  }

  public void setAppointTime(String appointTime) {
    this.appointTime = appointTime;
  }

  public List<CartListDTO> getCarts() {
    return carts;
  }

  public void setCarts(List<CartListDTO> carts) {
    this.carts = carts;
  }

  public Double getSumMoney() {
    return sumMoney;
  }

  public void setSumMoney(Double sumMoney) {
    this.sumMoney = sumMoney;
  }

  public String getCathNumber() {
    return cathNumber;
  }

  public void setCathNumber(String cathNumber) {
    this.cathNumber = cathNumber;
  }

  @Override
  public String toString() {
    return "AdminOrderDetialVO{" +
        "model='" + model + '\'' +
        ", appointTime='" + appointTime + '\'' +
        ", carts=" + carts +
        ", note='" + note + '\'' +
        ", sumMoney=" + sumMoney +
        ", cathNumber='" + cathNumber + '\'' +
        '}';
  }
}
