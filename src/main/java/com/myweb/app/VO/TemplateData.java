package com.myweb.app.VO;

/**
 * @author weipan
 * @date 2019/4/16 12:48
 */
public class TemplateData {

  /**
   * 消息内容
   */
  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "TemplateData{" +
        "value='" + value + '\'' +
        '}';
  }
}
