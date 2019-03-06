package com.myweb.app.service;

import com.myweb.app.DTO.FoodsDTO;
import com.myweb.app.bean.Fooddetial;
import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import com.myweb.app.mapper.FoodsMapper;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by weipan on 2019/2/22 18:50
 */
@Service
public class FoodsService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private FoodsMapper foodsMapper;


  public List<FoodsDTO> getAllFoods(){
    Fooddetial fooddetial = new Fooddetial();
    fooddetial.setSpecs("常规");
    fooddetial.setPacking_fee(0);
    fooddetial.setPrice(0);
    ArrayList<Fooddetial> fooddetials = new ArrayList<>();
    fooddetials.add(fooddetial);
    List<Menu> typeList = foodsMapper.getAllTypeList();
    List<Foods> foodsList = foodsMapper.getAllFoodsList();
    List<Foods> foo = null;
    List<FoodsDTO> foodsDTOS = new ArrayList<>();
    FoodsDTO foodsDTO = null;
    for(Menu menu : typeList){
      foodsDTO = new FoodsDTO();
      foo = new ArrayList<>();
      foodsDTO.setName(menu.getType());
      for (Foods food : foodsList){
        if (food.getType().equals(menu.getId().toString())){
          food.setSize(fooddetials);
          food.setTem(fooddetials);
          foo.add(food);
        }
      }
      foodsDTO.setFoods(foo);
      foodsDTOS.add(foodsDTO);
    }
    return foodsDTOS;
  }
}
