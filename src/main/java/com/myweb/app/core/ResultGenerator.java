package com.myweb.app.core;

/**
 * Created by weipan on 2019/1/18 14:41
 */

/**
 * 响应结构生成工具
 *
 */
public class ResultGenerator {
  private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

  public static Result genSuccessResult() {
    return new Result()
        .setCode(ResultCode.SUCCESS)
        .setMessage(DEFAULT_SUCCESS_MESSAGE);
  }

  public static <T> Result<T> genSuccessResult(T data) {
    return new Result()
        .setCode(ResultCode.SUCCESS)
        .setMessage(DEFAULT_SUCCESS_MESSAGE)
        .setData(data);
  }

  public static Result genFailResult(String message) {
    return new Result()
        .setCode(ResultCode.FAIL)
        .setMessage(message);
  }


}
