package com.myweb.app.mapper;

import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import com.myweb.app.bean.Order;
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

}
