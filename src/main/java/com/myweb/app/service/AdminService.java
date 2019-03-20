package com.myweb.app.service;

import com.myweb.app.mapper.AdminMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by weipan on 2019/3/19 10:30
 */
@Service
public class AdminService {
  
  @Autowired
  private AdminMapper adminMapper;

  private Logger logger = LoggerFactory.getLogger(getClass());

  public boolean validateAdminLogin(String adminname,String adminpassword){
    boolean flag = false;
    int res = adminMapper.validateAdminLogin(adminname, adminpassword);
    if (res == 1){
      flag = true;
    }
    return flag;
  }

}
