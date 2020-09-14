package com.hooli.manage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 3:09 下午
 * @description：管理平台接口文档
 */
@Configuration
@EnableSwagger2
public class ManageSwaggerConfig {

    @Bean
    public Docket manageDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("manage")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hooli.manage"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("管理平台接口文档")
                .description("管理平台接口文档")
                .termsOfServiceUrl("https://qq.com")
                .version("1.0.0")
                .build();
    }
}
