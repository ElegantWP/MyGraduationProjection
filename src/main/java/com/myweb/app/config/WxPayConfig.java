package com.myweb.app.config;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by weipan on 2019/2/24 16:01
 */
@Component
@ConfigurationProperties("wxPay")
public class WxPayConfig {

  private String timeStamp;
  private String nonceStr;
  @JSONField(name = "package")
  private String packagt;
  private String signType;
  private String paySign;

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
}
