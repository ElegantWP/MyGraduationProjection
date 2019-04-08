package com.myweb.app.core;

/**
 * @author weipan
 * @date 2019/3/29 11:44
 */
public enum FoodStatus {

  /**
   * 库存充足状态
   */
  SCUUESS(1, "库存充足"),
  /**
   * 库存不足状态
   */
  FAILED(2, "库存不足");

  /**
   * 商品的库存状态
   */
  private Integer status;
  /**
   * 状态的详细描述
   */
  private String desc;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  private FoodStatus(Integer status, String desc) {
    this.status = status;
    this.desc = desc;
  }
}
