package com.myweb.app.DTO;

import java.util.Date;

/**
 * @author weipan
 * @date 2019/4/14 23:05
 */
public class ReductionDTO {
  private Integer rule;
  private Integer cut;
  private String type;
  private String typeDes;
  private String startDate;
  private String endDate;

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

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "ReductionDTO{" +
        "rule=" + rule +
        ", cut=" + cut +
        ", type='" + type + '\'' +
        ", typeDes='" + typeDes + '\'' +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        '}';
  }
}
