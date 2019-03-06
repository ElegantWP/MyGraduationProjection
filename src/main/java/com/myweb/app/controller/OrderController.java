package com.myweb.app.controller;

import com.google.common.base.Preconditions;
import com.myweb.app.DTO.BuyerOrderDTO;
import com.myweb.app.VO.MyOrderDetailVO;
import com.myweb.app.VO.MyOrderListVO;
import com.myweb.app.VO.OrderVO;
import com.myweb.app.bean.Order;
import com.myweb.app.core.ResponseMessage;
import com.myweb.app.core.ResponseMsg;
import com.myweb.app.service.BuyerOrderService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weipan on 2019/2/25 13:06
 */
@RestController
public class OrderController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private BuyerOrderService buyerOrderService;


  @PostMapping("/addOrder")
  public ResponseMessage addOrder(@RequestParam String openid,@RequestBody BuyerOrderDTO buyerOrderDTO){
    Preconditions.checkNotNull(buyerOrderDTO);
    Preconditions.checkArgument(StringUtils.isNotEmpty(openid));
    logger.info(openid+"创建当前订单");
    logger.info(buyerOrderDTO.toString());
    Order order = buyerOrderService.addOrder(buyerOrderDTO, openid);
    OrderVO orderVO = new OrderVO();
    orderVO.setCathNumber(order.getCathNumber());
    orderVO.setCartList(buyerOrderDTO.getCartList());
    orderVO.setTime(order.getTime());
    orderVO.setOrderId(order.getOrderId());
    orderVO.setSumMoney(order.getSumMoney());
    ResponseMessage<Object> message = new ResponseMessage<>();
    message.setCode(0);
    message.setMsg(orderVO);
    return message;
  }



  @GetMapping("/getMyOrderDetail")
  public ResponseMsg getMyOrderDetial(@RequestParam String openid, @RequestParam String orderId){
    //做一个简单的参数校验  出错则直接抛出illlarguments 异常  统一处理
    Preconditions.checkArgument(StringUtils.isNotEmpty(openid));
    Preconditions.checkArgument(StringUtils.isNotEmpty(orderId));
    MyOrderDetailVO detailVO = buyerOrderService.getMyOrderDetial(openid, orderId);
    ResponseMsg<Object> msg = new ResponseMsg<>();
    msg.setCode(0);
    msg.setData(detailVO);
    return msg;
  }

  //买家获取自己的订单列表
  @GetMapping("/getMyOrderList")
  public ResponseMsg getMyOrderList(@RequestParam String openid,@RequestParam Integer model){
    //校验参数是否为空
    Preconditions.checkArgument(StringUtils.isNotEmpty(openid));
    Preconditions.checkNotNull(model);
    List<MyOrderListVO> myOrderList = buyerOrderService.getMyOrderList(openid, model);
    ResponseMsg<Object> msg = new ResponseMsg<>();
    msg.setCode(0);
    msg.setData(myOrderList);
    return msg;

  }
}
