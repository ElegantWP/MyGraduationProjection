package com.myweb.app.service;

import com.alibaba.fastjson.JSON;
import com.myweb.app.DTO.RegisterDTO;
import com.myweb.app.VO.WeChatAuthVO;
import com.myweb.app.bean.User;
import com.myweb.app.config.WeChatConfig;
import com.myweb.app.mapper.WeChatUserMapper;
import com.myweb.app.utils.BeanUtil;
import com.myweb.app.utils.ConvertDomainUtils;
import com.myweb.app.utils.HttpUtils;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by weipan on 2019/2/15 21:57
 */
@Service
public class WeChatAuthAndLoginService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private WeChatConfig weChatConfig;

  @Autowired
  private WeChatUserMapper weChatUserMapper;

  //获取openid和session_key
  public WeChatAuthVO getUserOpenId(String code){
    WeChatAuthVO weChatAuthVO = null;
    //获取openid的url
    String baseurl = weChatConfig.getUrl()+ code;
    String url = baseurl + "&"+"grant_type"+weChatConfig.getGrant_type();
    logger.info(url);
    String data = HttpUtils.get(url, null);
    if (StringUtils.isNotEmpty(data)){
      logger.info(data);
      weChatAuthVO = JSON.parseObject(data, WeChatAuthVO.class);
      logger.info("获取openid成功");
      return weChatAuthVO;
    }
    return weChatAuthVO;
  }


  //用户注册
  public boolean registerUser(RegisterDTO registerDTO){
    boolean flag = false;
    User user = ConvertDomainUtils.convertObject(registerDTO,User.class);
    logger.info(user.toString());
    user.setRole(0);
    user.setRoot(0);
    user.setResum(0.0);
    String isExist = weChatUserMapper.isExistInUser(user);
    if (StringUtils.isEmpty(isExist)){
      logger.info("用户还未注册");
      weChatUserMapper.registerUser(user);
      flag = true;
      logger.info("用户注册成功");
    }else {
      logger.info("用户已经注册");
    }
    return flag;
  }

  //更新用户最后一登录的时间
  public boolean updateLastLoginTime(String openId){
    boolean flag = false;
    User user = new User();
    user.setLastLoginTime(new Date());
    user.setOpenId(openId);
    int res = weChatUserMapper.updateLastLoginTime(user);
    if (res>0){
      flag = true;
      logger.info("登录时间更新成功");
    }
    return flag;
  }



}
