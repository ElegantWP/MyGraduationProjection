package com.myweb.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by weipan on 2019/2/13 20:42
 */
@Component
@ConfigurationProperties("wx")
public class WeChatConfig {

  /**
   * 开发者相关信息
   */
  private String appid;
  private String secret;
  private String grant_type;
  private String url;

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getGrant_type() {
    return grant_type;
  }

  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
