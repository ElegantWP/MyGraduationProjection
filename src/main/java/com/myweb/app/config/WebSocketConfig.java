package com.myweb.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by weipan on 2019/2/24 23:50
 */
@Configuration
//webSocket的配置类
public class WebSocketConfig {

  @Bean
  public ServerEndpointExporter endpointExporter(){
    return new ServerEndpointExporter();
  }
}
