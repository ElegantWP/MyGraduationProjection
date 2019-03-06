package com.myweb.app.bean;

/**
 * Created by weipan on 2019/2/23 14:53
 */
public class Fooddetial {

  private String specs;
  private Integer  packing_fee;
  private Integer price;

  public String getSpecs() {
    return specs;
  }

  public void setSpecs(String specs) {
    this.specs = specs;
  }

  public Integer getPacking_fee() {
    return packing_fee;
  }

  public void setPacking_fee(Integer packing_fee) {
    this.packing_fee = packing_fee;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Fooddetial{" +
        "specs='" + specs + '\'' +
        ", packing_fee=" + packing_fee +
        ", price=" + price +
        '}';
  }
}
