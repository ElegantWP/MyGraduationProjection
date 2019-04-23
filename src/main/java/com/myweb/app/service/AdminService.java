package com.myweb.app.service;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.myweb.app.DTO.AdminFoodDTO;
import com.myweb.app.DTO.CartListDTO;
import com.myweb.app.DTO.ReductionDTO;
import com.myweb.app.VO.AdminChartOrderNumVO;
import com.myweb.app.VO.AdminChartsVO;
import com.myweb.app.VO.AdminOrderDetialVO;
import com.myweb.app.VO.AdminOrderVO;
import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import com.myweb.app.bean.Order;
import com.myweb.app.bean.Reduction;
import com.myweb.app.bean.User;
import com.myweb.app.config.QiniuConfig;
import com.myweb.app.core.FoodStatus;
import com.myweb.app.mapper.AdminMapper;
import com.myweb.app.mapper.FoodsMapper;
import com.myweb.app.utils.TimeUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by weipan on 2019/3/19 10:30
 * @author ElegantWP
 */
@Service
public class AdminService {
  
  @Autowired
  private AdminMapper adminMapper;

  @Autowired
  private QiniuConfig qiniuConfig;

  @Autowired
  private FoodsMapper foodsMapper;

  @Autowired
  private WxminiPushMsgService wxminiPushMsgService;

  private Logger logger = LoggerFactory.getLogger(getClass());

  public boolean validateAdminLogin(String adminname,String adminpassword){
    boolean flag = false;
    int res = adminMapper.validateAdminLogin(adminname, adminpassword);
    if (res == 1){
      logger.info("管理员验证成功");
      flag = true;
    }
    return flag;
  }

  /**
   * 将图片上传七牛云  并返回图片链接
   * @param file 文件的流格式
   * @param key  文件的文件名
   * @return 图片存储的外链
   */
  public String uploadQNImg(FileInputStream file, String key) {
    // 构造一个带指定Zone对象的配置类   华东机房  配置空间所在的区域
    Configuration cfg = new Configuration(Zone.zone0());
    // 其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);
    // 生成上传凭证，然后准备上传

    try {
      Auth auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
      String upToken = auth.uploadToken(qiniuConfig.getBucket());
      try {
        Response response = uploadManager.put(file, key, upToken, null, null);
        // 解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

        String returnPath = qiniuConfig.getPath() + "/" + putRet.key;
        return returnPath;
      } catch (QiniuException ex) {
        Response r = ex.response;
        logger.error(r.toString());
        try {
          logger.error(r.bodyString());
        } catch (QiniuException ex2) {
          logger.info("[异常上传图片]:{}",ex2);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  /**
   * 获取所有已经注册的用户
   * @return
   */
  public List<User> getAllUser(){
    return adminMapper.getAllUser();
  }

  /**
   * 获取所有的商品信息
   * @return
   */
  public List<Foods> getAllFoodsList(){
    List<Foods> foodsList = foodsMapper.getAllFoodsList();
    List<Menu> allTypeList = foodsMapper.getAllTypeList();
    List<Foods> res = new ArrayList<>();
    for (Foods food : foodsList){
      for (Menu menu : allTypeList){
        if (food.getType().equals(menu.getId().toString())){
          food.setMenu(menu);
          res.add(food);
        }
      }
    }
    return res;
  }

  /**
   * 获取所有的类型列表
    * @return
   */
  public List<Menu> getMenuList(){
    return foodsMapper.getAllTypeList();
  }

  /**
   * 管理员向系统中增加商品信息
   * @param file
   * @param adminFoodDTO
   * @return
   * @throws IOException
   */
  public boolean addAdminFood(MultipartFile file,AdminFoodDTO adminFoodDTO)throws IOException{
    boolean flag = false;
    FileInputStream inputStream = (FileInputStream) file.getInputStream();
    String path = uploadQNImg(inputStream, UUID.randomUUID().toString());
    logger.info("图片Http连接：{}",path);
    Foods foods = new Foods();
    foods.setName(adminFoodDTO.getName());
    foods.setPrice(adminFoodDTO.getPrice());
    foods.setEnName(adminFoodDTO.getEnName());
    foods.setDesc(adminFoodDTO.getDesc());
    //获得七牛云图片的外链存储
    foods.setImg(path);
    foods.setType(adminFoodDTO.getType());
    if (adminFoodDTO.getKustatus().equals(FoodStatus.SCUUESS.getDesc())){
      foods.setStatus(FoodStatus.SCUUESS.getStatus());
    }else if (adminFoodDTO.getKustatus().equals(FoodStatus.FAILED.getDesc())){
      foods.setStatus(FoodStatus.FAILED.getStatus());
    }
    if (adminMapper.adminAddFood(foods) == 1){
      flag =true;
    }
    return flag;
  }

  public List<AdminOrderVO> getOrderList(){
    List<Order> orderList = adminMapper.getOrderList();
    List<AdminOrderVO> res = new ArrayList<>();
    for (Order order : orderList) {
      AdminOrderVO adminOrderVO = new AdminOrderVO();
      adminOrderVO.setOrderId(order.getOrderId());
      String nickName = adminMapper.getUserNameByOpenid(order.getOpenId());
      adminOrderVO.setNickName(nickName);
      adminOrderVO.setOrderNum(order.getCupNumber());
      adminOrderVO.setCreateTime(order.getTime());
      adminOrderVO.setOrderPatten(order.getModel());
      adminOrderVO.setOrderStatus(order.getStatus());
      adminOrderVO.setCutMoney(order.getCutMoney());
      adminOrderVO.setSumMoney(order.getSumMoney());
      res.add(adminOrderVO);
    }
    return res;
  }

  public Foods getFoodById(Integer id){
    return adminMapper.getFoodById(id);
  }

  /**
   * 没有跟新图片的额操作
   * @param id
   * @param adminFoodDTO
   */
  public void updateFoodDetial(Integer id ,AdminFoodDTO adminFoodDTO,MultipartFile file) throws IOException{

    Foods foods = new Foods();
    foods.setId(id);
    foods.setName(adminFoodDTO.getName());
    foods.setPrice(adminFoodDTO.getPrice());
    foods.setEnName(adminFoodDTO.getEnName());
    foods.setDesc(adminFoodDTO.getDesc());
    foods.setType(adminFoodDTO.getType());
    if (adminFoodDTO.getKustatus().equals(FoodStatus.SCUUESS.getDesc())){
      foods.setStatus(FoodStatus.SCUUESS.getStatus());
    }else if (adminFoodDTO.getKustatus().equals(FoodStatus.FAILED.getDesc())){
      foods.setStatus(FoodStatus.FAILED.getStatus());
    }
    if (StringUtils.isNotBlank(file.getOriginalFilename())) {
      logger.info("管理员更新商品图片 重新进行存储");
      //设置图片更新商品明细
      FileInputStream inputStream = (FileInputStream) file.getInputStream();
      String path = uploadQNImg(inputStream, UUID.randomUUID().toString());
      logger.info("更新商品图片Http连接：{}",path);
      foods.setImg(path);
      logger.info(foods.toString());
      adminMapper.updateFoodDetial(foods);
      logger.info("更新商品信息成功");
    }else {
      logger.info("用户没有更新图片，无需进行上传文件的操作");
      //更新商品明细
      logger.info(foods.toString());
      adminMapper.updateFoodDetial(foods);
      logger.info("更新商品信息成功");
    }
  }

  /**
   * 管理员根据商品id删除商品
   * @param id
   */
  public void deleteFood(Integer id){
    adminMapper.deleteFoodById(id);
  }

  /**
   * 管理员根据订单编号获取订单详情 想页面显示数据
   * @param orderId 订单编号
   * @return AdminOrderDetialVO
   */
  public AdminOrderDetialVO getOrderDetialByOrderId(String orderId){
    Order order = adminMapper.getOrderDetialByOrderId(orderId);
    AdminOrderDetialVO orderDetialVO = new AdminOrderDetialVO();
    orderDetialVO.setModel(order.getModel().toString());
    List<CartListDTO> carts= JSON.parseArray(order.getCartList(), CartListDTO.class);
    orderDetialVO.setCarts(carts);
    orderDetialVO.setAppointTime(order.getAppointTime());
    orderDetialVO.setNote(order.getNote());
    orderDetialVO.setSumMoney(order.getSumMoney());
    orderDetialVO.setCathNumber(order.getCathNumber());
    return orderDetialVO;
  }

  /**
   * 管理员根据订单编号完结订单状态
   * @param orderId
   */
  @Transactional
  public void updateOrderStatus(String orderId){
    adminMapper.updateOrderStatus(orderId);
    /**
     * 获取订单详情信息  使得可以发送微信模板消息
     */
    Order order = adminMapper.getOrderDetialByOrderId(orderId);
    wxminiPushMsgService.sendWxMsg(order);
  }

  /**
   * 管理员获取所有的优惠券列表
   * @return 所有的优惠券信息
   */
  public List<Reduction> getAllReduction(){
    return adminMapper.getAllReduction();
  }

  /**
   * 管理员添加优惠卷信息
   * @param reductionDTO 优惠券的数据传输对象
   */
  public void addReductionMsg(ReductionDTO reductionDTO) throws ParseException {
    Reduction reduction = new Reduction();
    reduction.setCut(reductionDTO.getCut());
    reduction.setRule(reductionDTO.getRule());
    reduction.setType(reductionDTO.getType());
    reduction.setTypeDes(reductionDTO.getTypeDes());
    //设置优惠券状态可用
    reduction.setStatus(1);
    reduction.setStartDate(TimeUtil.getDateTimeByString(reductionDTO.getStartDate()));
    reduction.setEndDate(TimeUtil.getDateTimeByString(reductionDTO.getEndDate()));
    adminMapper.addReduction(reduction);
  }

  /**
   * 管理员通过编号删除无用的优惠券
   * @param id
   */
  public void adminDelReductionById(Integer id){
    adminMapper.delReductionById(id);
  }

  /**
   * 根据编号获取指定的优惠券信息
   * @param id
   * @return
   */
  public Reduction getReductionById(Integer id){
    return adminMapper.getReductionById(id);
  }

  public void updateReduction(Integer id,ReductionDTO reductionDTO)throws ParseException {
    Reduction reduction = new Reduction();
    reduction.setId(id);
    reduction.setCut(reductionDTO.getCut());
    reduction.setRule(reductionDTO.getRule());
    reduction.setType(reductionDTO.getType());
    reduction.setTypeDes(reductionDTO.getTypeDes());
    //设置优惠券状态可用
    reduction.setStatus(1);
    reduction.setStartDate(TimeUtil.getDateTimeByString(reductionDTO.getStartDate()));
    reduction.setEndDate(TimeUtil.getDateTimeByString(reductionDTO.getEndDate()));
    logger.info(reductionDTO.toString());
    logger.info(reduction.toString());
    adminMapper.updateReduction(reduction);
  }

  /**
   * 管理员获取每日订单金额变化的柱状图表
   * @return
   */
  public List<AdminChartsVO> getCountOrderMsg(){
    return adminMapper.getAdminCountsMsg();
  }

  public List<AdminChartOrderNumVO> getCountOrderNumMsg(){
    return adminMapper.getAdminCountNumMsg();
  }
}
