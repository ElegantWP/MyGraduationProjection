package com.myweb.app.DTO;

/**
 * Created by weipan on 2019/2/25 10:55
 */
public class CartListDTO {

  private Integer cIndex;
  private Integer cType;
  private String name;
  private String desc;
  private String detail;
  private String enName;
  private String img;
  private Integer number;
  private Double price;
  private Double sum;

  public Integer getcIndex() {
    return cIndex;
  }

  public void setcIndex(Integer cIndex) {
    this.cIndex = cIndex;
  }

  public Integer getcType() {
    return cType;
  }

  public void setcType(Integer cType) {
    this.cType = cType;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getEnName() {
    return enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getSum() {
    return sum;
  }

  public void setSum(Double sum) {
    this.sum = sum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "CartListDTO{" +
        "cIndex=" + cIndex +
        ", cType=" + cType +
        ", name='" + name + '\'' +
        ", desc='" + desc + '\'' +
        ", detail='" + detail + '\'' +
        ", enName='" + enName + '\'' +
        ", img='" + img + '\'' +
        ", number=" + number +
        ", price=" + price +
        ", sum=" + sum +
        '}';
  }
}
