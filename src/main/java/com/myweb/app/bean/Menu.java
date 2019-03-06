package com.myweb.app.bean;

/**
 * Created by weipan on 2019/2/22 18:40
 */
public class Menu {

  private Integer id;
  private String type;

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

  @Override
  public String toString() {
    return "Menu{" +
        "id=" + id +
        ", type='" + type + '\'' +
        '}';
  }
}
