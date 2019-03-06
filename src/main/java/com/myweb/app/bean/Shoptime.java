package com.myweb.app.bean;

/**
 * Created by weipan on 2019/2/22 14:52
 */
public class Shoptime {

  private Integer id;
  private Integer open;
  private Integer close;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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

  @Override
  public String toString() {
    return "Shoptime{" +
        "id=" + id +
        ", open=" + open +
        ", close=" + close +
        '}';
  }
}
