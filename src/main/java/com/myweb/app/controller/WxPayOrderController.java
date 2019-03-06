package com.myweb.app.controller;

import com.myweb.app.DTO.WxPayDTO;
import com.myweb.app.core.ResponseMessage;
import com.myweb.app.utils.WxPayOrdrIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weipan on 2019/2/24 9:44
 */
@RestController
public class WxPayOrderController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  //参考微信支付的开发文档

  @PostMapping("wxPay")
  public ResponseMessage getWxPay(){
    WxPayDTO wxPayDTO = new WxPayDTO();
    String orderId = WxPayOrdrIDUtil.getWxPayOrderID(WxPayOrdrIDUtil.getMachineId().toString());
    wxPayDTO.setOutTradeNo(orderId);
    wxPayDTO.setPackagt("wx14093815872929748b4110d40700673305");
    ResponseMessage<Object> message = new ResponseMessage<>();
    message.setCode(0);
    message.setMsg(wxPayDTO);
    return message;
  }



}
