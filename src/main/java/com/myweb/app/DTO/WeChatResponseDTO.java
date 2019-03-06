package com.myweb.app.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by weipan on 2019/2/15 22:01
 */
public class WeChatResponseDTO {

  private String openid;
  @JsonProperty("session_key")
  private String sessionKey;
  private String unionid;
  private int errcode;
  private String errmsg;

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getSessionKey() {
    return sessionKey;
  }

  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }

  public String getUnionid() {
    return unionid;
  }

  public void setUnionid(String unionid) {
    this.unionid = unionid;
  }

  public int getErrcode() {
    return errcode;
  }

  public void setErrcode(int errcode) {
    this.errcode = errcode;
  }

  public String getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }
}
