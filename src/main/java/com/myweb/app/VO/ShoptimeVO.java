package com.myweb.app.VO;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by weipan on 2019/2/22 16:14
 */
public class ShoptimeVO {
  @JSONField(name = "openTime")
  private Integer open;
  @JSONField(name = "closeTime")
  private Integer close;

  public Integer getOpen() {
    return open;
  }

  public void setOpen(Integer open) {
    this.open = open;
  }

  public Integer getClose() {
    return close;
  }

  public void setClose(Integer close) {
    this.close = close;
  }
}
