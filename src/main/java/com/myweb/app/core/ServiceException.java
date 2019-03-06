package com.myweb.app.core;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”WebMvcConfigurer info级别记录 同一抛出异常
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
