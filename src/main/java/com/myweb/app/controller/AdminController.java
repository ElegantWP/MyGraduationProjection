package com.myweb.app.controller;

import com.google.common.base.Preconditions;
import com.myweb.app.service.AdminService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**、
 * Created by weipan on 2019/3/14 14:45
 */
@Controller
public class AdminController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private AdminService adminService;

  //管理员登录 校验
  @PostMapping("/admin/login")
  public String toGoAdminIndex(@RequestParam("adminname") String adminname,
                            @RequestParam("adminpassword") String adminpassword,
                            Map<String,Object> msg,HttpSession session){
    Preconditions.checkArgument(StringUtils.isNotEmpty(adminname),"账户名不能为空");
    Preconditions.checkArgument(StringUtils.isNotEmpty(adminpassword),"密码不能为空");
    if (adminService.validateAdminLogin(adminname,adminpassword)){
      //登录成功
      session.setAttribute("username",adminname);
      logger.info("管理员已经成功上线");
      return "redirect:/adminIndex.html";
    }else {
      //登录失败
      logger.info("管理员登录失败，请检查账户名和密码");
      msg.put("errmsg","用户名或密码错误");
      return "login";
    }
  }
}
