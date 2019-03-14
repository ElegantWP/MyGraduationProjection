package com.myweb.app.service;

import com.myweb.app.VO.ReductionVO;
import com.myweb.app.bean.MyCut;
import com.myweb.app.bean.MyReductionList;
import com.myweb.app.bean.Reduction;
import com.myweb.app.mapper.ReductionMapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by weipan on 2019/3/6 17:34
 */
@Service
public class ReductionService {

  @Autowired
  private ReductionMapper reductionMapper;


  //获取用户可以领取的优惠券的列表
  public List<ReductionVO> getUserCanUseReductionList(String openid){
    List<Reduction> reductionList = reductionMapper.getUserCanUseReductionList();
    List<ReductionVO> res = new ArrayList<>();
    for (Reduction reduction : reductionList){
      ReductionVO reductionVO = new ReductionVO();
      BeanUtils.copyProperties(reduction,reductionVO);
      res.add(reductionVO);
    }
    for (ReductionVO reductionVO1 : res){
      MyCut myCut = reductionMapper.isGetCut(openid, reductionVO1.getId());
      if (null != myCut){
        reductionVO1.setIsR(1);
      }else {
        reductionVO1.setIsR(0);
      }
    }

    return res;
  }

  //用户领取优惠券的业务逻辑 向MyCut表中插入数据
  public void getCut(String openid,Integer reduction){
    MyCut myCut = new MyCut();
    myCut.setOpenid(openid);
    myCut.setGetTime(new Date());
    myCut.setReduction(reduction);
    myCut.setStatus(0);
    reductionMapper.getCut(myCut);
  }

  //获取我的可以使用的优惠券的列表集合
  public List<MyReductionList> getMyReductonList(String openid){
    List<MyReductionList> myReductonList = reductionMapper.getMyReductonList(openid);
    return myReductonList;
  }

  //用户使用优惠券
  public void useCut(Integer id){
    reductionMapper.useCut(id,new Date());
  }

}
