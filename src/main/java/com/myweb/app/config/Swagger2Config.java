package com.myweb.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author weipan
 * @date 2019/4/22 11:29
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

  /**
   * 是否开启Swagger 可以再配置文件application.properties中进行配置
   */
  @Value(value = "${swagger.enabled}")
  private Boolean swaggerEnabled;

  @Bean
  public Docket createRestApi(){
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        // 是否开启
        .enable(swaggerEnabled).select()
        // 扫描的路径包
        .apis(RequestHandlerSelectors.basePackage("com.myweb.app.controller"))
        // 指定路径处理PathSelectors.any()代表所有的路径
        .paths(PathSelectors.any()).build().pathMapping("/");
  }

  private ApiInfo apiInfo(){
    return new ApiInfoBuilder()
        .title("基于SpringBoot的点餐系统的设计与实现的API文档")
        .description("西北大学|毕业设计")
        // 作者信息
        .contact(new Contact("ElegantWP", "https://github.com/ElegantWP", "elegantwp@foxmail.com"))
        .version("1.0.0")
        .build();
  }

}
