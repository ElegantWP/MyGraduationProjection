package com.myweb.app.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import com.myweb.app.bean.Foods;
import java.util.List;

/**
 * Created by weipan on 2019/2/22 18:50
 */
public class FoodsDTO {


  /**
   * id : 17
   * type : 5
   * name : 泰芒
   * price : 24
   * img : 4
   * num : 0
   * enName : THAILAND MANGO
   * status : 1
   * desc : null
   * tem : null
   * size : null
   */

  private String name;
  @JSONField(name = "foods")
  private List<Foods> foods;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "FoodsDTO{" +
        "name='" + name + '\'' +
        ", foods=" + foods +
        '}';
  }

  public List<Foods> getFoods() {
    return foods;
  }

  public void setFoods(List<Foods> foods) {
    this.foods = foods;
  }
}
