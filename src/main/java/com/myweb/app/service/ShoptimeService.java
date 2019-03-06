package com.myweb.app.service;

import com.myweb.app.VO.ShoptimeVO;
import com.myweb.app.bean.Shoptime;
import com.myweb.app.mapper.ShoptimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by weipan on 2019/2/22 16:13
 */
@Service
public class ShoptimeService {

  @Autowired
  private ShoptimeMapper shoptimeMapper;

  public ShoptimeVO getShoptime(){
    Shoptime shoptime = shoptimeMapper.getShoptime();
    ShoptimeVO shoptimeVO = new ShoptimeVO();
    shoptimeVO.setOpen(shoptime.getOpen());
    shoptimeVO.setClose(shoptime.getClose());
    return shoptimeVO;
  }


}
