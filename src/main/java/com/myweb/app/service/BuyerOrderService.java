package com.myweb.app.service;

import com.alibaba.fastjson.JSON;
import com.myweb.app.DTO.BuyerOrderDTO;
import com.myweb.app.DTO.CartListDTO;
import com.myweb.app.VO.MyOrderDetailVO;
import com.myweb.app.VO.MyOrderListVO;
import com.myweb.app.bean.Order;
import com.myweb.app.mapper.OrderMapper;
import com.myweb.app.mapper.WeChatUserMapper;
import com.myweb.app.utils.CathNumberUtil;
import com.myweb.app.utils.ConvertDomainUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by weipan on 2019/2/26 0:22
 */
@Service
public class BuyerOrderService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private WeChatUserMapper weChatUserMapper;

  @Autowired
  private OrderMapper orderMapper;

  //向订单表中写入数据 并且修改user表中的个人的消费金额
  @Transactional
  public Order addOrder(BuyerOrderDTO buyerOrderDTO,String openid){
    Order order = ConvertDomainUtils.convertObject(buyerOrderDTO, Order.class);
    order.setOpenId(openid);
    order.setCathNumber(CathNumberUtil.getCathNumber(orderMapper.getOrderCount()));
    order.setTime(new Date());
    order.setStatus(1);
    order.setCartList(JSON.toJSON(buyerOrderDTO.getCartList()).toString());
    orderMapper.addToDayOrder(order);
    logger.info("订单写入成功");
    weChatUserMapper.updateResumeMoney(openid,order.getSumMoney());
    logger.info("用户消费金额更新成功");
    return order;
  }

  //获取买家的订单详情
  public MyOrderDetailVO getMyOrderDetial(String openid,String orderId){
    MyOrderDetailVO detailVO = new MyOrderDetailVO();
    Order detial = orderMapper.getMyOrderDetial(openid, orderId);
    BeanUtils.copyProperties(detial,detailVO);
    List<CartListDTO> cartList= JSON.parseArray(detial.getCartList(), CartListDTO.class);
    detailVO.setCartList(cartList);
    logger.info("获取订单信息成功");
    return detailVO;
  }

  //获取买家的订单列表
  public List<MyOrderListVO> getMyOrderList(String openid,Integer model){
    List<MyOrderListVO> orderList = orderMapper.getMyOrderList(openid, model);
    for (MyOrderListVO myOrderListVO : orderList){
      //为CartListDTO切分对象  转换为JavaBean
      myOrderListVO.setCartListDTOS(JSON.parseArray(myOrderListVO.getCartList(),CartListDTO.class));
    }
    return orderList;
  }


}
