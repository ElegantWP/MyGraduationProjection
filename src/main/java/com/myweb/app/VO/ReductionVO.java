package com.myweb.app.VO;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
 * Created by weipan on 2019/3/13 14:35
 */
public class ReductionVO {

  private Integer id;
  private String type;
  private String typeDes;
  private Integer rule;
  private Integer cut;
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date startDate;
  @JSONField (format="yyyy-MM-dd HH:mm:ss")
  private Date endDate;
  private Integer status;
  private String img;
  private Integer isR;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTypeDes() {
    return typeDes;
  }

  public void setTypeDes(String typeDes) {
    this.typeDes = typeDes;
  }

  public Integer getRule() {
    return rule;
  }

  public void setRule(Integer rule) {
    this.rule = rule;
  }

  public Integer getCut() {
    return cut;
  }

  public void setCut(Integer cut) {
    this.cut = cut;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Integer getIsR() {
    return isR;
  }

  public void setIsR(Integer isR) {
    this.isR = isR;
  }

  @Override
  public String toString() {
    return "ReductionVO{" +
        "id=" + id +
        ", type='" + type + '\'' +
        ", typeDes='" + typeDes + '\'' +
        ", rule=" + rule +
        ", cut=" + cut +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", status=" + status +
        ", img='" + img + '\'' +
        ", isR=" + isR +
        '}';
  }
}
