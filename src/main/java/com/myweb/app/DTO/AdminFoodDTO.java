package com.myweb.app.DTO;

/**
 * @author weipan
 * @date 2019/3/28 23:14
 */
public class AdminFoodDTO {

  private String name;
  private Double price;
  private String kustatus;
  private String enName;
  private String desc;
  private String type;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getKustatus() {
    return kustatus;
  }

  public void setKustatus(String kustatus) {
    this.kustatus = kustatus;
  }

  public String getEnName() {
    return enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "AdminFoodDTO{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", kustatus='" + kustatus + '\'' +
        ", enName='" + enName + '\'' +
        ", desc='" + desc + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}
