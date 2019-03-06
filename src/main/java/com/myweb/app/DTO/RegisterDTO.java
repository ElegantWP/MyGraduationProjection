package com.myweb.app.DTO;

/**
 * Created by weipan on 2019/2/22 12:06
 */
public class RegisterDTO {


  /**
   * nickName : এ᭄゛primary
   * gender : 1
   * language : zh_CN
   * city : Xi'an
   * province : Shaanxi
   * country : China
   * avatarUrl : https://wx.qlogo.cn/mmopen/vi_32/IR5xyTwib2icgDU3NdG9MhN2kiaZfIia7SlJywkLranfHIDic15Jh9Ju2mdZ7cBflen1dV0d6Bum7OibGq11h2no8OnQ/132
   * openId : osoJK5J0DQhwKgRgbRdBYQlUbpjA
   */

  private String nickName;
  private int gender;
  private String language;
  private String city;
  private String province;
  private String country;
  private String avatarUrl;
  private String openId;

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }
}
