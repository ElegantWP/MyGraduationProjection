package com.myweb.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myweb.app.DTO.FoodsDTO;
import com.myweb.app.core.ResponseMsg;
import com.myweb.app.service.FoodsService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weipan on 2019/2/23 11:12
 */
@RestController
public class FoodsController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private FoodsService foodsService;

  @GetMapping("getfoodList")
  public JSONObject getFoods(){
    List<FoodsDTO> allFoods = foodsService.getAllFoods();
    ResponseMsg<Object> msg = new ResponseMsg<>();
    msg.setCode(0);
    msg.setData(allFoods);
    JSONObject jsonObj = (JSONObject) JSON.toJSON(msg);
    return jsonObj;
  }

}
