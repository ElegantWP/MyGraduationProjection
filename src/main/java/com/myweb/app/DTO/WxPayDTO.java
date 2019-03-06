package com.myweb.app.DTO;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by weipan on 2019/2/24 16:10
 */
public class WxPayDTO {


  private String timeStamp;
  private String nonceStr;
  @JSONField(name = "package")
  private String packagt;
  private String signType;
  private String paySign;
  @JSONField(name = "out_trade_no")
  private String outTradeNo;

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getPackagt() {
    return packagt;
  }

  public void setPackagt(String packagt) {
    this.packagt = packagt;
  }

  public String getSignType() {
    return signType;
  }

  public void setSignType(String signType) {
    this.signType = signType;
  }

  public String getPaySign() {
    return paySign;
  }

  public void setPaySign(String paySign) {
    this.paySign = paySign;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  @Override
  public String toString() {
    return "WxPayDTO{" +
        "timeStamp='" + timeStamp + '\'' +
        ", nonceStr='" + nonceStr + '\'' +
        ", packagt='" + packagt + '\'' +
        ", signType='" + signType + '\'' +
        ", paySign='" + paySign + '\'' +
        ", outTradeNo='" + outTradeNo + '\'' +
        '}';
  }
}
