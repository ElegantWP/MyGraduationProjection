package com.myweb.app.mapper;

import com.myweb.app.bean.Foods;
import com.myweb.app.bean.Menu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by weipan on 2019/2/22 18:41
 */
@Mapper
@Repository
public interface FoodsMapper {

//  获取所有food
  List<Foods> getAllFoodsList();
  //获取所有type
  List<Menu> getAllTypeList();

}
