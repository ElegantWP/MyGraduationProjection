package com.myweb.app.controller;

import com.google.common.base.Preconditions;
import com.myweb.app.DTO.AdminFoodDTO;
import com.myweb.app.VO.AdminOrderVO;
import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import com.myweb.app.bean.User;
import com.myweb.app.core.ResponseMsg;
import com.myweb.app.service.AdminService;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by weipan on 2019/3/14 14:45
 * @author ElegantWP
 */
@Controller
public class AdminController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private AdminService adminService;


  /**
   * 管理员登录 并配置登陆拦截器
   * @param adminname
   * @param adminpassword
   * @param msg
   * @param session
   * @return
   */
  @PostMapping("/admin/login")
  public String toGoAdminIndex(@RequestParam("adminname") String adminname,
                            @RequestParam("adminpassword") String adminpassword,
                            Map<String,Object> msg,HttpSession session,
                            Model model){
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

  /**
   * 向对象存储空间上传图片
   * @param file
   * @return
   * @throws IOException
   */
  @PostMapping("/qiniu")
  @ResponseBody
  public ResponseMsg uploadImgQiniu(@RequestParam("file")MultipartFile file) throws IOException {
    FileInputStream inputStream = (FileInputStream) file.getInputStream();
    String path = adminService.uploadQNImg(inputStream, UUID.randomUUID().toString());
    logger.info(path);
    ResponseMsg<Object> msg = new ResponseMsg<>();
    msg.setCode(0);
    msg.setData(path);
    return msg;
  }

  /**
   * 获取所有已经注册用户的注册列表
   * @param model
   * @return
   */
  @GetMapping("/admin/getUserList")
  public String getUserList(Model model){
    List<User> users = adminService.getAllUser();
    model.addAttribute("users",users);
    logger.info("获取用户列表成功");
    return "index";
  }

  /**
   * 管理员进入商品主页
   * @param model
   * @return
   */
  @GetMapping("/admin/getFoodList")
  public String getMenuList(Model model){
    List<Foods> foodsList = adminService.getAllFoodsList();
    model.addAttribute("foods", foodsList);
    return "adminfoodslist";
  }

  /**
   * 管理员进入订单的主页
   * @param model
   * @return
   */
  @GetMapping("/admin/getOrderList")
  public String getOrderList(Model model){
    List<AdminOrderVO> orderList = adminService.getOrderList();
    model.addAttribute("orders",orderList);
    return "adminorderlist";
  }

  /**
   * 进入添加商品的页面
   * @return
   */
  @GetMapping("/admin/toAddFoods")
  public String toAddFoods(){
    return "adminaddfoods";
  }

  /**
   * 管理员获取菜单列表
   * @return
   */
  @GetMapping("/admin/getMenuList")
  @ResponseBody
  public List<Menu> getMenuList(){
    List<Menu> menuList = adminService.getMenuList();
    return menuList;
  }

  /**
   * 管理员增加商品 及上传商品图片
   * @param file
   * @param adminFoodDTO
   * @return
   * @throws IOException
   */
  @PostMapping("/admin/addFood")
  public String adminAddFood(@RequestParam("file")MultipartFile file,AdminFoodDTO adminFoodDTO,Model model)throws IOException{
    logger.info("前台的数据的DTO对象{}",adminFoodDTO);
    boolean res = adminService.addAdminFood(file, adminFoodDTO);
    if (res){
      //新的商品信息添加成功  弹窗
      model.addAttribute("msg","添加成功");
      return "adminaddfoods";
    }else {
      //新的商品信息添加失败
      model.addAttribute("msg","添加失败");
      return "adminaddfoods";
    }
  }

  @GetMapping("admin/orderdetial/{orderId}")
  public String adminGetOrderDetial(@PathParam("orderid") String orderId){
    return "adminorderdetial";
  }
}
