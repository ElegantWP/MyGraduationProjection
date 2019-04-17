package com.myweb.app.config;

/**
 * @author weipan
 * @date 2019/4/16 11:36
 */
public class AccessTokenConfig {

  // 获取到的凭证
  private String access_token;
  // 凭证有效时间，单位：秒
  private int expiresIn;

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public int getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(int expiresIn) {
    this.expiresIn = expiresIn;
  }

  @Override
  public String toString() {
    return "AccessTokenConfig{" +
        "access_token='" + access_token + '\'' +
        ", expiresIn=" + expiresIn +
        '}';
  }
}
