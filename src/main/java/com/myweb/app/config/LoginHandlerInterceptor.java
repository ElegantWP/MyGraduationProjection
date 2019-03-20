package com.myweb.app.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by weipan on 2019/3/20 10:23
 */
//登录功能的拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor{

  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o) throws Exception {
    Object username = httpServletRequest.getSession().getAttribute("username");
    if (null == username){
      //未登录 重定向到登陆页面
      httpServletRequest.setAttribute("errmsg","没有权限访问请重新登录");
      httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest,httpServletResponse);
      return false;
    }else {
      //已经成功登录
      return true;
    }
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
      throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

  }
}
