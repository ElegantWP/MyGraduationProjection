package com.myweb.app.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/**
 * Created by weipan on 2019/2/22 18:30
 */
public class Foods {

  private Integer id;
  private String type;
  private String name;
  private Double price;
  private String img;
  private Integer num;
  private String enName;
  private Integer status;
  private String desc;
  private List<Fooddetial> tem;
  private List<Fooddetial> size;


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

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getEnName() {
    return enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

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

  public List<Fooddetial> getTem() {
    return tem;
  }

  public void setTem(List<Fooddetial> tem) {
    this.tem = tem;
  }

  public List<Fooddetial> getSize() {
    return size;
  }

  public void setSize(List<Fooddetial> size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Foods{" +
        "id=" + id +
        ", type='" + type + '\'' +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", img='" + img + '\'' +
        ", num=" + num +
        ", enName='" + enName + '\'' +
        ", status=" + status +
        ", desc='" + desc + '\'' +
        ", tem=" + tem +
        ", size=" + size +
        '}';
  }
}
