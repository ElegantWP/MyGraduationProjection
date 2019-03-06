package com.myweb.app.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by weipan on 2018/12/17 10:56
 */

/**
 * 获取spring对象的工具类（bean对象）
 * 使用事列：FrameSpringBeanUtil.getBean(JedisCluster.class);
 * 解决多线程情况下无法注入bean的问题
 */
@Component
public class FrameSpringBeanUtil implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext arg0) throws BeansException {
    applicationContext = arg0;
  }

  @SuppressWarnings("unchecked")
  public static <T> T getBean(String name) {
    return (T) applicationContext.getBean(name);
  }

  public static <T> T getBean(Class<T> cls) {
    return applicationContext.getBean(cls);
  }
}