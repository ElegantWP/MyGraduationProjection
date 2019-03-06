package com.myweb.app.core;

import com.alibaba.fastjson.JSON;

/**
 * Created by weipan on 2019/1/18 14:39
 */

/**
 * 定义统一返回的JSON
 * @param <T>
 */
public class Result<T> {

  private int code;
  private String message;
  private T data;

  public Result setCode(ResultCode resultCode) {
    this.code = resultCode.code();
    return this;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public Result setMessage(String message) {
    this.message = message;
    return this;
  }

  public T getData() {
    return data;
  }

  public Result setData(T data) {
    this.data = data;
    return this;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

}
