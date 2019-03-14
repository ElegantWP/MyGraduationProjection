package com.myweb.app.mapper;

import com.myweb.app.bean.MyCut;
import com.myweb.app.bean.MyReductionList;
import com.myweb.app.bean.Reduction;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by weipan on 2019/3/6 17:38
 */
@Mapper
@Repository
public interface ReductionMapper {

  //获取用户可以获得的优惠券列表
  List<Reduction> getUserCanUseReductionList();

  //查询用户是否领取过优惠券
  MyCut isGetCut(@Param("openid") String openid, @Param("id") Integer id);

  //想MyCut表中写入数据
  void getCut(MyCut myCut);

  //获取我的所有优惠券的列表集合
  List<MyReductionList> getMyReductonList(@Param("openid") String openid);

  //用户使用优惠间 更新字段的状态的值
  void useCut(@Param("id") Integer id,@Param("time")Date time);

}
