package com.myweb.app.controller;

import com.myweb.app.VO.ShoptimeVO;
import com.myweb.app.core.ResponseMsg;
import com.myweb.app.service.ShoptimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weipan on 2019/2/22 16:17
 */
@RestController
public class ShoptimeController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private ShoptimeService shoptimeService;

  @GetMapping("/getShopTime")
  public ResponseMsg getShopTime(){
    ShoptimeVO shoptimeVO = shoptimeService.getShoptime();
    ResponseMsg<Object> message = new ResponseMsg<>();
    message.setCode(0);
    message.setData(shoptimeVO);
    return message;
  }
}
