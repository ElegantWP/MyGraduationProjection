package com.myweb.app.bean;

import java.util.Date;

/**
 * Created by weipan on 2019/3/6 19:50
 */
public class MyCut {

  private Integer id;
  private String openid;
  private Integer reduction;
  private Integer status;
  private Date getTime;
  private Date useTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public Integer getReduction() {
    return reduction;
  }

  public void setReduction(Integer reduction) {
    this.reduction = reduction;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getGetTime() {
    return getTime;
  }

  public void setGetTime(Date getTime) {
    this.getTime = getTime;
  }

  public Date getUseTime() {
    return useTime;
  }

  public void setUseTime(Date useTime) {
    this.useTime = useTime;
  }

  @Override
  public String toString() {
    return "MyCut{" +
        "id=" + id +
        ", openid='" + openid + '\'' +
        ", reduction=" + reduction +
        ", status=" + status +
        ", getTime=" + getTime +
        ", useTime=" + useTime +
        '}';
  }
}
