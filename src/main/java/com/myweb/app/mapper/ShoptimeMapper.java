package com.myweb.app.mapper;

import com.myweb.app.bean.Shoptime;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by weipan on 2019/2/22 15:50
 */
@Mapper
@Repository
public interface ShoptimeMapper {

  //获取营业时间
  Shoptime getShoptime();

}
