package com.myweb.app.core;

/**
 * Created by weipan on 2019/2/15 22:44
 */
public class ResponseMessage<T> {

    private int code;
    private T msg;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public T getMsg() {
    return msg;
  }

  public void setMsg(T msg) {
    this.msg = msg;
  }
}
