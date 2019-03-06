package com.myweb.app.VO;

import com.myweb.app.DTO.FoodsDTO;
import java.util.List;

/**
 * Created by weipan on 2019/2/22 19:27
 */
public class FoodsVO {

  private List<FoodsDTO> foods;

  public List<FoodsDTO> getFoods() {
    return foods;
  }

  public void setFoods(List<FoodsDTO> foods) {
    this.foods = foods;
  }

  @Override
  public String toString() {
    return "FoodsVO{" +
        "foods=" + foods +
        '}';
  }
}
