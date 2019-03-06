package com.myweb.app.core;

/**
 * Created by weipan on 2019/2/23 11:13
 */
public class ResponseMsg<T> {
  private int code;
  private T data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "ResponseMsg{" +
        "code=" + code +
        ", data=" + data +
        '}';
  }
}
