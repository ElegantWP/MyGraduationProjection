package com.myweb.app.mapper;

import com.myweb.app.VO.AdminChartOrderNumVO;
import com.myweb.app.VO.AdminChartsVO;
import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import com.myweb.app.bean.Order;
import com.myweb.app.bean.Reduction;
import com.myweb.app.bean.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by weipan on 2019/3/19 10:30
 */
@Mapper
@Repository
public interface AdminMapper {

  /**
   * 校验管理员登录
   * @param adminname
   * @param adminpassword
   * @return
   */
  int validateAdminLogin(@Param("adminname") String adminname ,@Param("adminpassword") String adminpassword);

  /**
   * 管理员获取已经授权的用户列表
   * @return
   */
  List<User> getAllUser();

  /**
   * 管理员增加商品
   * @param foods
   * @return
   */
  int adminAddFood(Foods foods);

  /**
   * 根据openid获取用户的昵称
   * @param openid
   * @return
   */
  String getUserNameByOpenid(@Param("openid") String openid);

  /**
   * 管理员获取所有的订单
   * @return
   */
  List<Order> getOrderList();

  /**
   * 根据商品编号获取商品
   * @param id 商品编号
   * @return
   */
  Foods getFoodById(@Param("id") Integer id);

  /**
   * 管理员更新商品的图片信息
   * @param foods
   */
  void updateFoodDetial(Foods foods);

  /**
   * 管理员根据编号删除商品
   * @param id
   */
  void deleteFoodById(@Param("id") Integer id);

  /**
   * 管理员根据订单编号获取订单详情
   * @param orderId 订单编号
   */
  Order getOrderDetialByOrderId(@Param("orderId") String orderId);

  /**
   * 更新订单状态 根据订单编号
   * @param orderId 订单编号
   */
  void updateOrderStatus(@Param("orderId") String orderId);

  /**
   * 管理员获取所有的优惠券列表
   * @return
   */
  List<Reduction> getAllReduction();

  /**
   * 管理员添加优惠券
   * @param reduction
   */
  void addReduction(Reduction reduction);

  /**
   * 管理员删除过期无用的优惠券
   * @param id 优惠券编号
   */
  void delReductionById(@Param("id") Integer id);

  /**
   * 通过编号获取优惠券编号
   * @param id
   * @return
   */
  Reduction getReductionById(@Param("id") Integer id);

  /**
   * 更新优惠券信息
   * @param reduction
   */
  void updateReduction(Reduction reduction);

  /**
   * 管理员获取每日的订单金额
   * @return VO页面对象
   */
  List<AdminChartsVO> getAdminCountsMsg();

  /**
   * 管理员获取每日订单的数量变化的折线图
   * @return
   */
  List<AdminChartOrderNumVO> getAdminCountNumMsg();
}
