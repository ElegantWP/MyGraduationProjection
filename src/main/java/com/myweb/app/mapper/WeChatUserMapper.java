package com.myweb.app.mapper;

import com.myweb.app.bean.User;
import com.myweb.app.core.ServiceException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by weipan on 2019/2/22 12:39
 */
@Mapper
@Repository
public interface WeChatUserMapper {

  //weixin用户信息写入数据库
  int registerUser(User user) throws ServiceException;
  //查询数据库中是否已经存在该用户 根据openId
  String isExistInUser(User user);
  //更新最后一次的登录时间
  int updateLastLoginTime(User user);
  //更新微信用户的消费金额
  void updateResumeMoney(@Param("openid") String openid,@Param("sumMoney") double sumMoney);
}
