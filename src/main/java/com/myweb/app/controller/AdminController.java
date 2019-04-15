package com.myweb.app.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.myweb.app.DTO.AdminFoodDTO;
import com.myweb.app.DTO.ReductionDTO;
import com.myweb.app.VO.AdminChartOrderNumVO;
import com.myweb.app.VO.AdminChartsVO;
import com.myweb.app.VO.AdminOrderDetialVO;
import com.myweb.app.VO.AdminOrderVO;
import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import com.myweb.app.bean.Reduction;
import com.myweb.app.bean.User;
import com.myweb.app.core.ResponseMsg;
import com.myweb.app.service.AdminService;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public String getMenuList(Model model,@RequestParam(defaultValue = "1") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize){
    PageHelper.startPage(pageNo, pageSize);
    List<Foods> foodsList = adminService.getAllFoodsList();
    PageInfo<Foods> pageInfo = new PageInfo<Foods>(foodsList);
    logger.info("pageInfo {}",pageInfo.toString());
    logger.info("总页数：{}",pageInfo.getPages() );
    logger.info("总记录数：{}",pageInfo.getTotal() );
    model.addAttribute("pageInfo", pageInfo);
    return "adminfoodslist";
  }

  /**
   * 管理员更新商品请求 返回到添加商品的页面进行数据的回显操作
   * @param id
   * @return
   */
  @GetMapping("/admin/food/{id}")
  public String toUpdateFood(@PathVariable("id") Integer id ,Model model){
    Preconditions.checkNotNull(id);
    Foods food = adminService.getFoodById(id);
    List<Menu> menus = adminService.getMenuList();
    model.addAttribute("food",food);
    model.addAttribute("menus",menus);
    return "adminupdatefoods";
  }

  /**
   * 管理员更新商品详情
   * @param file
   * @param adminFoodDTO
   * @param id
   * @return
   * @throws IOException
   */
  @PostMapping("admin/food")
  public String updateFood(@RequestParam(value = "file",required = false)MultipartFile file,
                            AdminFoodDTO adminFoodDTO,
                            @RequestParam Integer id)throws IOException{
    Preconditions.checkNotNull(adminFoodDTO);
    Preconditions.checkNotNull(id);
    adminService.updateFoodDetial(id,adminFoodDTO,file);
    return "redirect:/admin/getFoodList";
  }
  @GetMapping("/admin/delete/{id}")
  public String deleteFood(@PathVariable("id") Integer id){
    Preconditions.checkNotNull(id);
    adminService.deleteFood(id);
    logger.info("删除商品编号为{}成功",id);
    return "redirect:/admin/getFoodList";
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

  @GetMapping("admin/detial/{id}")
  public String adminGetOrderDetial(@PathVariable("id") String id,Model model){
    Preconditions.checkArgument(StringUtils.isNotEmpty(id));
    AdminOrderDetialVO detial = adminService.getOrderDetialByOrderId(id);
    model.addAttribute("detial",detial);
    logger.info(detial.toString());
    return "adminorderdetial";
  }

  @GetMapping("/admin/order/status/{id}")
  public String updateOrderStatus(@PathVariable("id") String id){
    Preconditions.checkArgument(StringUtils.isNotEmpty(id));
    adminService.updateOrderStatus(id);
    return "redirect:/admin/getOrderList";
  }

  /**
   * 管理员后台获取所有的优惠券
   * @return
   */
  @GetMapping("/admin/reductionList")
  public String getAllRuduction(Model model){
    List<Reduction> reductions = adminService.getAllReduction();
    model.addAttribute("reductions",reductions);
    return "reductionlist";
  }

  /**
   * 管理员进入添加优惠券的页面
   * @return
   */
  @GetMapping("/admin/toAddReducion")
  public String toAddReduction(){
    return "reductiondetial";
  }

  /**
   * 管理员添加优惠券
   * @param reductionDTO
   * @return
   * @throws ParseException
   */
  @PostMapping("/admin/addReduction")
  public String addReduction(ReductionDTO reductionDTO) throws ParseException {
   Preconditions.checkNotNull(reductionDTO);
   adminService.addReductionMsg(reductionDTO);
   return "redirect:/admin/reductionList";
  }

  /**
   * 管理员删除优惠券信息
   * @param id
   * @return
   */
  @GetMapping("/admin/reductionDel/{id}")
  public String delReductionById(@PathVariable("id") Integer id) {
    Preconditions.checkNotNull(id);
    adminService.adminDelReductionById(id);
    return "redirect:/admin/reductionList";
  }

  /**
   * 通过编号获取指定优惠券信息 回显数据至指定的页面
   * @param id
   * @return
   */
  @GetMapping("admin/reductionEdit/{id}")
  public String editReduction(@PathVariable("id") Integer id,Model model){
    Preconditions.checkNotNull(id);
    Reduction reduction = adminService.getReductionById(id);
    model.addAttribute("reduction",reduction);
    return "reductionedit";
  }

  /**
   * 管理员修改优惠卷信息
   * @param reductionDTO
   * @param id
   * @return
   * @throws ParseException
   */
  @PostMapping("/admin/updateReduction")
  public String updateReduction(ReductionDTO reductionDTO,Integer id) throws ParseException{
    Preconditions.checkNotNull(reductionDTO);
    adminService.updateReduction(id,reductionDTO);
    return "redirect:/admin/reductionList";
  }

  /**
   * 跳转至图表统计的页面
   * @return
   */
  @GetMapping("/admin/count/charts")
  public String toCountChartsMsg(){
    return "charts";
  }

  /**
   * 管理员获取orderMoney信息
   * @return
   */
  @ResponseBody
  @GetMapping("/admin/count/ordermoney")
  public List<AdminChartsVO> getOrderCountMsg(){
    List<AdminChartsVO> data = adminService.getCountOrderMsg();
    return data;
  }

  @ResponseBody
  @GetMapping("/admin/count/ordernum")
  public List<AdminChartOrderNumVO> getOrderCountNumMsg(){
    List<AdminChartOrderNumVO> data = adminService.getCountOrderNumMsg();
    return data;
  }
}
