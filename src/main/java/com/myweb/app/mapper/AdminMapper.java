package com.myweb.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by weipan on 2019/3/19 10:30
 */
@Mapper
@Repository
public interface AdminMapper {

  //检测管理员登录
  int validateAdminLogin(@Param("adminname") String adminname ,@Param("adminpassword") String adminpassword);


}
