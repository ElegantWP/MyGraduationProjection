package com.myweb.app.DTO;

/**
 * Created by weipan on 2019/2/25 10:53
 */

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/**
 * data: {
 out_trade_no: out_trade_no,
 cartList: wx.getStorageSync('cartList'),
 sumMonney: wx.getStorageSync('sumMonney') - that.data.cutMonney,
 cutMonney: that.data.cutMonney,
 cutText:that.data.cutText,
 cupNumber: wx.getStorageSync('cupNumber'),
 model:this.data.model,
 appointTime: this.data.appointTime,
 packages:packages,
 note:that.data.note,
 },
 */
public class BuyerOrderDTO {

  @JSONField(name = "out_trade_no")
  private String orderId;
  private List<CartListDTO> cartList;
  @JSONField(name = "sumMonney")
  private Double sumMoney;
  @JSONField(name = "cutMonney")
  private Double cutMoney;
  private String cutText;
  private Integer cupNumber;
  private Integer model; //到店支付还是预约支付
  private String appointTime;
  private String packages;
  private String note;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

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

  public String getCutText() {
    return cutText;
  }

  public void setCutText(String cutText) {
    this.cutText = cutText;
  }

  public Integer getCupNumber() {
    return cupNumber;
  }

  public void setCupNumber(Integer cupNumber) {
    this.cupNumber = cupNumber;
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

  public String getPackages() {
    return packages;
  }

  public void setPackages(String packages) {
    this.packages = packages;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return "BuyerOrderDTO{" +
        "orderId='" + orderId + '\'' +
        ", cartList=" + cartList +
        ", sumMoney=" + sumMoney +
        ", cutMoney=" + cutMoney +
        ", cutText='" + cutText + '\'' +
        ", cupNumber=" + cupNumber +
        ", model=" + model +
        ", appointTime='" + appointTime + '\'' +
        ", packages='" + packages + '\'' +
        ", note='" + note + '\'' +
        '}';
  }
}
