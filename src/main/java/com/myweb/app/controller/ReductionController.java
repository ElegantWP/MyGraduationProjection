package com.myweb.app.controller;

import com.google.common.base.Preconditions;
import com.myweb.app.VO.ReductionVO;
import com.myweb.app.bean.MyReductionList;
import com.myweb.app.core.ResponseMessage;
import com.myweb.app.service.ReductionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weipan on 2019/3/6 17:30
 */
@RestController
public class ReductionController {

  private Logger logger = LoggerFactory.getLogger(getClass());


  @Autowired
  private ReductionService reductionService;

  //获取用户可以领取的所有的优惠券列表
  @GetMapping("/getUserCanUseReductionList")
  public ResponseMessage getUserCanUseReductionList(@RequestParam String openid){
    Preconditions.checkArgument(StringUtils.isNotEmpty(openid));
    List<ReductionVO> userCanUseReductionList = reductionService.getUserCanUseReductionList(openid);
    ResponseMessage<Object> message = new ResponseMessage<>();
    message.setCode(0);
    message.setMsg(userCanUseReductionList);
    return message;
  }

  //用户领取优惠券接口
  @GetMapping("/getCut")
  public ResponseMessage getcut(@RequestParam String openid,@RequestParam Integer reduction){
    Preconditions.checkArgument(StringUtils.isNotEmpty(openid));
    Preconditions.checkNotNull(reduction);
    logger.info("领取优惠券");
    reductionService.getCut(openid,reduction);
    ResponseMessage<Object> message = new ResponseMessage<>();
    message.setCode(0);
    message.setMsg("领取成功");
    return message;
  }

  //获取我的可以使用的忧患卷的集合
  @GetMapping("getCutList")
  public ResponseMessage getMyReductonList(@RequestParam String openid){
    logger.info("获取可以使用的优惠券的集合");
    Preconditions.checkArgument(StringUtils.isNotEmpty(openid));
    List<MyReductionList> myReductonList = reductionService.getMyReductonList(openid);
    ResponseMessage<Object> message = new ResponseMessage<>();
    message.setCode(0);
    message.setMsg(myReductonList);
    return message;
  }

  //用户使用优惠券
  @GetMapping("/useCut")
  public ResponseMessage useCut(@RequestParam Integer id){
    ResponseMessage<Object> message = new ResponseMessage<>();
    if (null == id){
      logger.info("此用户当前没有可以使用的优惠券");
    }else {
      reductionService.useCut(id);
      message.setCode(0);
      message.setMsg("使用成功");
      return message;
    }
    message.setCode(1);
    message.setMsg("无可用优惠券");
    return message;
  }

}
