package com.myweb.app.core;

/**
 * Created by weipan on 2019/1/18 14:40
 */

/**
 * 相应结果枚举类型
 */
public enum ResultCode {
  SUCCESS(200),//成功
  FAIL(400),//失败
  UNAUTHORIZED(401),//未认证（签名错误）
  NOT_FOUND(404),//接口不存在
  INTERNAL_SERVER_ERROR(500);//服务器内部错误

  private final int code;

  ResultCode(int code) {
    this.code = code;
  }

  public int code() {
    return code;
  }
}
