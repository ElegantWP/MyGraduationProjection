package com.myweb.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by weipan on 2019/3/14 14:45
 */
@Controller
public class AdminController {


  @GetMapping("/")
  public String adminLogin(){
    return "login";
  }



  @GetMapping("/adminlogin")
  public String index(){
    return "index";
  }
}
