package com.myweb.app.service;

import com.alibaba.fastjson.JSON;
import com.myweb.app.VO.TemplateData;
import com.myweb.app.VO.WxMssVo;
import com.myweb.app.bean.Order;
import com.myweb.app.config.AccessTokenConfig;
import com.myweb.app.config.WeChatConfig;
import com.myweb.app.utils.TimeUtil;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author weipan
 * @date 2019/4/16 10:36
 */
@Service
public class WxminiPushMsgService {

  @Autowired
  private WeChatConfig weChatConfig;

  @Value("${wxmsg.template_id}")
  private String wxTemplateId;

  @Value("${wxmsg.url}")
  private String wxTemplateUrl;

  private Logger logger = LoggerFactory.getLogger(getClass());

  public String getAccessToken(){
    RestTemplate restTemplate = new RestTemplate();
    //获取access_token
    String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" +
        "&appid=" + weChatConfig.getAppid() + "&secret=" + weChatConfig.getSecret();
    String json = restTemplate.getForObject(url, String.class);
    AccessTokenConfig config = JSON.parseObject(json, AccessTokenConfig.class);
    return config.getAccess_token();
  }

  public void sendWxMsg(Order order){

    //获取access_token
    String access_token = getAccessToken();
    String url = wxTemplateUrl +
        "?access_token=" + access_token;

    //拼接推送的模版
    WxMssVo wxMssVo = new WxMssVo();
    //用户openid
    wxMssVo.setTouser(order.getOpenId());
    wxMssVo.setTemplate_id(wxTemplateId);//模版id
    wxMssVo.setForm_id(order.getPackages());//formid
    wxMssVo.setPage("pages/order/list/list");

    Map<String, TemplateData> m = new HashMap<>(5);

    //keyword1：订单类型，keyword2：下单金额，keyword3：配送地址，keyword4：取件地址，keyword5备注
    TemplateData keyword1 = new TemplateData();
    keyword1.setValue("西大毕业设计");
    m.put("keyword1", keyword1);

    TemplateData keyword2 = new TemplateData();
    keyword2.setValue(order.getOrderId());
    m.put("keyword2", keyword2);
    wxMssVo.setData(m);

    TemplateData keyword3 = new TemplateData();
    try {
      keyword3.setValue(TimeUtil.getDateTimeByDate(order.getTime()));
    } catch (ParseException e) {
      logger.info("时间类型切分错误 再试一次{}",e);
    }
    m.put("keyword3", keyword3);
    wxMssVo.setData(m);

    TemplateData keyword4 = new TemplateData();
    keyword4.setValue(order.getCathNumber());
    m.put("keyword4", keyword4);
    wxMssVo.setData(m);

    TemplateData keyword5 = new TemplateData();
    keyword5.setValue("￥："+order.getSumMoney().toString());
    m.put("keyword5", keyword5);
    wxMssVo.setData(m);

    TemplateData keyword6 = new TemplateData();
    keyword6.setValue("您的餐品制作完成，请前往领取");
    m.put("keyword6", keyword6);
    wxMssVo.setData(m);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity =
        restTemplate.postForEntity(url, wxMssVo, String.class);
    logger.error("小程序推送结果={}", responseEntity.getBody());
  }

}
