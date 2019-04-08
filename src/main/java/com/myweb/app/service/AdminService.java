package com.myweb.app.service;

import com.google.gson.Gson;
import com.myweb.app.DTO.AdminFoodDTO;
import com.myweb.app.VO.AdminOrderVO;
import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import com.myweb.app.bean.Order;
import com.myweb.app.bean.User;
import com.myweb.app.config.QiniuConfig;
import com.myweb.app.core.FoodStatus;
import com.myweb.app.mapper.AdminMapper;
import com.myweb.app.mapper.FoodsMapper;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
   * @param file
   * @param key
   * @return
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
          logger.info("异常上传图片");
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
    System.out.println(foods);
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
}
