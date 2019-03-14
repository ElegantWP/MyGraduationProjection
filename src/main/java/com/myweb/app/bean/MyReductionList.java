package com.myweb.app.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
 * Created by weipan on 2019/3/14 9:11
 */
public class MyReductionList {

  private Integer id;
  private String openid;
  private Integer reduction;
  private Integer status;
  @JSONField (format="yyyy-MM-dd HH:mm:ss")
  private Date getTime;
  @JSONField (format="yyyy-MM-dd HH:mm:ss")
  private Date useTime;
  @JSONField(name = "detail")
  private Reduction detial;

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

  public Reduction getDetial() {
    return detial;
  }

  public void setDetial(Reduction detial) {
    this.detial = detial;
  }

  @Override
  public String toString() {
    return "MyReductionList{" +
        "id=" + id +
        ", openid='" + openid + '\'' +
        ", reduction=" + reduction +
        ", status=" + status +
        ", getTime=" + getTime +
        ", useTime=" + useTime +
        ", detial=" + detial +
        '}';
  }
}
