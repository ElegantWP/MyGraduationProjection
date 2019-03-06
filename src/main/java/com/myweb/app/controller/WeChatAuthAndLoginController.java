package com.myweb.app.controller;

import com.google.common.base.Preconditions;
import com.myweb.app.DTO.RegisterDTO;
import com.myweb.app.VO.WeChatAuthVO;
import com.myweb.app.core.ResponseMessage;
import com.myweb.app.service.WeChatAuthAndLoginService;
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
 * Created by weipan on 2019/2/15 21:55
 */
@RestController
public class WeChatAuthAndLoginController {

  @Autowired
  private WeChatAuthAndLoginService weChatAuthAndLoginService;

  private Logger logger = LoggerFactory.getLogger(getClass());

  //获取用户的登录凭证
  @GetMapping("/getUserOpenId")
  public ResponseMessage getUserOpenId(@RequestParam String code){
    logger.info(code);
    Preconditions.checkArgument(StringUtils.isNotEmpty(code));
    WeChatAuthVO weChatAuthVO = weChatAuthAndLoginService.getUserOpenId(code);
    ResponseMessage<Object> message = new ResponseMessage<>();
    message.setCode(0);
    message.setMsg(weChatAuthVO);
    return message;
  }

  //注册
  @PostMapping("/register")
  public ResponseMessage register(@RequestBody RegisterDTO registerDTO){
    ResponseMessage<Object> message = new ResponseMessage<>();
    Preconditions.checkNotNull(registerDTO);
    boolean res = weChatAuthAndLoginService.registerUser(registerDTO);
    if (res){
      //注册成功
      message.setCode(0);
      message.setMsg("注册成功");
    }else {
      message.setCode(-2);
      message.setMsg("用户已经注册");
    }
    return message;
  }

  //登录
  @GetMapping("/login")
  public ResponseMessage updateLastLoginTime(@RequestParam String openId){
    ResponseMessage<Object> message = new ResponseMessage<>();
    boolean res = weChatAuthAndLoginService.updateLastLoginTime(openId);
    if (res){
      message.setCode(0);
      message.setMsg("登陆成功");
    }else {
      message.setCode(-1);
      message.setMsg("登录失败");
    }
    return message;
  }

}
