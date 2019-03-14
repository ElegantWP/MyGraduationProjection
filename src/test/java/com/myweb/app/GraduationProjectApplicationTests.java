package com.myweb.app;

import com.myweb.app.VO.MyOrderDetailVO;
import com.myweb.app.VO.MyOrderListVO;
import com.myweb.app.bean.MyCut;
import com.myweb.app.bean.MyReductionList;
import com.myweb.app.bean.Order;
import com.myweb.app.bean.Reduction;
import com.myweb.app.bean.Shoptime;
import com.myweb.app.bean.User;
import com.myweb.app.config.WeChatConfig;
import com.myweb.app.mapper.OrderMapper;
import com.myweb.app.mapper.ReductionMapper;
import com.myweb.app.mapper.ShoptimeMapper;
import com.myweb.app.mapper.WeChatUserMapper;
import com.myweb.app.service.BuyerOrderService;
import com.myweb.app.utils.WxPayOrdrIDUtil;
import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//所有的单元测试
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraduationProjectApplicationTests {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private WeChatConfig weChatConfig;

  @Autowired
  private WeChatUserMapper weChatUserMapper;

  @Autowired
  private ShoptimeMapper shoptimeMapper;

  @Autowired
  private OrderMapper orderMapper;

  @Autowired
  private BuyerOrderService buyerOrderService;

  @Autowired
  private ReductionMapper reductionMapper;

	@Test
	public void contextLoads() {
//	  配置druid数据源成功  运行显示配置
    System.out.println(dataSource.getClass().getName());
	}


	@Test
  public void testWxChatConfig(){
    System.out.println(weChatConfig.getUrl());
  }

  @Test
  public void testRegisterUser(){
    User user = new User();
    user.setAvatarUrl("sdadasad");
    user.setNickName("倾城");
    int result = weChatUserMapper.registerUser(user);
    System.out.println(result);
  }

  @Test
  public void testShoptime(){
    Shoptime shoptime = shoptimeMapper.getShoptime();
    System.out.println(shoptime.toString());
  }
  //测试订单编号的唯一性
  //订单编号的生成策略 满足高并发量(每秒的并发量达到2000) 已经不可猜测性
  @Test
  public void testOrderId(){
    String res = WxPayOrdrIDUtil
        .getWxPayOrderID(WxPayOrdrIDUtil.getMachineId().toString());
    System.out.println(res.length());
  }

  @Test
  public void testTime(){
	  //获取当日的订单总数 以便于之后的取餐号码的设置
    int count = orderMapper.getOrderCount();
    System.out.println(count);
  }

  @Test
  public void testMyOrderDetial(){
    Order orderDetial = orderMapper
        .getMyOrderDetial("osoJK5J0DQhwKgRgbRdBYQlUbpjA", "2551616943445264");
    System.out.println(orderDetial);

  }

  //测试订单详情
  @Test
  public void testOrderService(){
    MyOrderDetailVO detailVO = buyerOrderService
        .getMyOrderDetial("osoJK5J0DQhwKgRgbRdBYQlUbpjA", "2551616943445264");
    System.out.println(detailVO);
  }

  @Test
  public void testMyOrderList() {
    List<MyOrderListVO> list = orderMapper
        .getMyOrderList("osoJK5J0DQhwKgRgbRdBYQlUbpjA", 0);
    System.out.println(list);
  }

  //测试优惠券的情况
  @Test
  public void testReduction(){
    List<Reduction> list = reductionMapper.getUserCanUseReductionList();
    System.out.println(list);
  }

  @Test
  public void testMyReductionList(){
    List<MyReductionList> list = reductionMapper
        .getMyReductonList("osoJK5J0DQhwKgRgbRdBYQlUbpjA");
    System.out.println(list);

  }

}

