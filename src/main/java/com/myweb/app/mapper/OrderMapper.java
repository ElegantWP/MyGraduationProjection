package com.myweb.app.mapper;

import com.myweb.app.VO.MyOrderListVO;
import com.myweb.app.bean.Order;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by weipan on 2019/3/2 18:43
 */
@Repository
@Mapper
public interface OrderMapper {

  //获得当日的订单总数
  int getOrderCount();

  //增加订单
  void addToDayOrder(Order order);

  //查询我的订单详情
  Order getMyOrderDetial(@Param("openid") String openid,@Param("orderId") String orderId);

  //查询我的订单列表 预约订单 即时订单
  List<MyOrderListVO> getMyOrderList(@Param("openid") String openid,@Param("model") Integer model);
}
